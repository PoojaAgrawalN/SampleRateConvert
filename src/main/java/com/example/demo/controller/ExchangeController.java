package com.example.demo.controller;

import com.example.demo.model.ExchangeRate;
import com.example.demo.model.dto.request.ConvertRequest;
import com.example.demo.service.ExchangeRateService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
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
public class ExchangeController {

    private static final Logger logger = LoggerFactory.getLogger(ExchangeController.class);

    private final ExchangeRateService exchangeRateService;
    @PostMapping("/calculate")
    public ResponseEntity<ExchangeRate> exchangeRate(@RequestBody final ConvertRequest request) {
        ExchangeRate exchangeRate = exchangeRateService.exchangeRate(request);
        return ResponseEntity.ok(exchangeRate);
    }

}
