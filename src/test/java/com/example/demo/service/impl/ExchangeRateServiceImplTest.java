package com.example.demo.service.impl;

import com.example.demo.base.AbstractBaseServiceTest;
import com.example.demo.model.ExchangeRate;
import com.example.demo.model.dto.request.ConvertRequest;
import com.example.demo.model.dto.request.ExchangeRateRequest;
import com.example.demo.model.dto.response.ExchangeResponse;
import com.example.demo.service.ExchangeService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.math.BigDecimal;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class ExchangeRateServiceImplTest {

    @InjectMocks
    private ExchangeRateServiceImpl exchangeRateService;

    @Mock
    private ExchangeService exchangeService;

    @Test
    @DisplayName("Given ExchangeRateRequest - When Exchange Rate is Requested - Then Return Correct Exchange Rate")
    void givenExchangeRateRequest_whenExchangeRateRequested_thenReturnCorrectExchangeRate() {

        // Given
        ConvertRequest request = ConvertRequest.builder()
                .originalCurrency("USD")
                .targetCurrency("EUR")
                .build();

        ExchangeResponse exchangeResponse = ExchangeResponse.builder()
                .result(new BigDecimal("85.00"))
                .success(true)
                .build();

        // When
        when(exchangeService.getExchangeRateWithAmount(request.getOriginalCurrency(), request.getTargetCurrency(), BigDecimal.valueOf(1)))
                .thenReturn(exchangeResponse);

        // Then
        ExchangeRate result = exchangeRateService.exchangeRate(request);

        // Verify
        verify(exchangeService).getExchangeRateWithAmount(request.getOriginalCurrency(), request.getTargetCurrency(), BigDecimal.valueOf(1));

    }


}