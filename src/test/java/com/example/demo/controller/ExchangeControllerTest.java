package com.example.demo.controller;

import com.example.demo.base.AbstractRestControllerTest;
import com.example.demo.model.Convert;
import com.example.demo.model.ExchangeRate;
import com.example.demo.model.dto.request.ConvertRequest;
import com.example.demo.model.dto.request.ExchangeRateRequest;
import com.example.demo.model.dto.response.ExchangeRateResponse;
import com.example.demo.service.ExchangeRateService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

class ExchangeControllerTest extends AbstractRestControllerTest {

    @MockBean
    private ExchangeRateService exchangeRateService;


    @Test
    @DisplayName("Given ExchangeRateRequest - When ConvertCurrency - Then Return ExchangeRateResponse")
    void givenExchangeRateRequest_whenConvertCurrency_thenReturnExchangeRateResponse() throws Exception {

        // Given
        ExchangeRateRequest request = ExchangeRateRequest.builder()
                .from("USD")
                .to("EUR")
                .build();

        ExchangeRate exchangeRate = ExchangeRate.builder()
                .result(new BigDecimal("0.85"))
                .build();

        // When
        when(exchangeRateService.exchangeRate(any(ConvertRequest.class)))
                .thenReturn(exchangeRate);


        // Then
        mockMvc.perform(post("/api/calculate")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsBytes(request)))
                .andDo(print());


    }

    @Test
    @DisplayName("Given ConvertRequest - When ExchangeRate - Then Return ConvertResponse")
    void givenConvertRequest_whenExchangeRate_thenReturnConvertResponse() throws Exception {

        // Given
        ConvertRequest request = ConvertRequest.builder()
                .originalCurrency("USD")
                .targetCurrency("EUR")
                .totalAmount(new BigDecimal("100.00"))
                .build();

        Convert convert = Convert.builder()
                .transactionId("12345")
                .amount(new BigDecimal("100.00"))
                .from("USD")
                .to("EUR")
                .convertedAmount(new BigDecimal("85.00"))
                .build();


        DecimalFormat decimalFormat = new DecimalFormat("0.0", new DecimalFormatSymbols(Locale.US));
        // Then
        mockMvc.perform(post("/api/calculate")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsBytes(request)))
                .andDo(print());

    }


}