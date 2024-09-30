package com.example.demo.service.impl;

import com.example.demo.model.ExchangeRate;
import com.example.demo.model.dto.request.ConvertRequest;
import com.example.demo.model.dto.request.ExchangeRateRequest;
import com.example.demo.model.dto.response.ExchangeResponse;
import com.example.demo.model.mapper.ExchangeResponseToExchangeRateMapper;
import com.example.demo.service.ExchangeRateService;
import com.example.demo.service.ExchangeService;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;


@Service
@RequiredArgsConstructor
@CacheConfig(cacheNames = "exchanges")
public class ExchangeRateServiceImpl implements ExchangeRateService {

    private final ExchangeService exchangeService;

    private static final Integer UNIT_VALUE = 1;

    private final ExchangeResponseToExchangeRateMapper exchangeResponseToExchangeRateMapper =
            ExchangeResponseToExchangeRateMapper.initialize();

    @Override
    public ExchangeRate exchangeRate(ConvertRequest convertRequest) {

        ExchangeResponse exchangeResponse = exchangeService.getExchangeRateWithAmount(
                convertRequest.getOriginalCurrency(),convertRequest.getTargetCurrency(), BigDecimal.valueOf(UNIT_VALUE)
        );
// todo calculation with input
        return exchangeResponseToExchangeRateMapper.map(exchangeResponse);

    }

}
