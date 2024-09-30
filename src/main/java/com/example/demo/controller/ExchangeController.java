package com.example.demo.controller;

import com.example.demo.model.ExchangeRate;
import com.example.demo.model.dto.request.ConvertRequest;
import com.example.demo.model.dto.response.ExchangeRateResponse;
import com.example.demo.model.mapper.ConvertToConvertHistoryResponseMapper;
import com.example.demo.model.mapper.ConvertToConvertResponseMapper;
import com.example.demo.model.mapper.ExchangeRateToExchangeRateResponseMapper;
import com.example.demo.service.ExchangeRateService;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller named {@link ExchangeController} for handling exchange rate and currency conversion operations.
 * This controller provides endpoints for converting currencies, retrieving exchange rates,
 * and getting conversion history. It also manages cache eviction periodically.
 */
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@Validated
public class ExchangeController {

    private static final Logger logger = LoggerFactory.getLogger(ExchangeController.class);

    private final ExchangeRateService exchangeRateService;



    private final ExchangeRateToExchangeRateResponseMapper exchangeRateToExchangeRateResponseMapper =
            ExchangeRateToExchangeRateResponseMapper.initialize();

    /**
     * Converts currency based on the provided ExchangeRateRequest.
     *
     * @param request the request containing currency conversion details.
     * @return a ResponseEntity containing the ExchangeRateResponse with the conversion result.
     */
    @RateLimiter(name = "basic")
    @PostMapping("/calculate")
    @Operation(
            summary = "Convert Currency",
            description = "Converts currency based on the provided ExchangeRateRequest.",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Successful conversion",
                                 content = @Content(mediaType = "application/json",
                                                    schema = @Schema(implementation = ExchangeRateResponse.class))),
                    @ApiResponse(responseCode = "400", description = "Invalid request format")
            }
    )
    public ResponseEntity<ExchangeRateResponse> exchangeRate(@Valid @RequestBody final ConvertRequest request) {
        ExchangeRate exchangeRate = exchangeRateService.exchangeRate(request);
        return ResponseEntity.ok(exchangeRateToExchangeRateResponseMapper.map(exchangeRate));
    }

}
