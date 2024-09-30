package com.example.demo.service.impl;

import com.example.demo.model.ExchangeRate;
import com.example.demo.model.dto.request.ConvertRequest;
import com.example.demo.model.dto.response.ExchangeResponse;
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


    @Override
    public ExchangeRate exchangeRate(ConvertRequest convertRequest) {
        if (convertRequest.getUserType().equalsIgnoreCase("EMP")) {
            BigDecimal discount = new BigDecimal("0.30");
            BigDecimal discountedPrice = convertRequest.getTotalAmount().subtract(convertRequest.getTotalAmount().multiply(discount));
            convertRequest.setTotalAmount(discountedPrice);
        } else if (convertRequest.getUserType().equalsIgnoreCase("affiliate")) {
            BigDecimal discount = new BigDecimal("0.10");
            BigDecimal discountedPrice = convertRequest.getTotalAmount().subtract(convertRequest.getTotalAmount().multiply(discount));
            convertRequest.setTotalAmount(discountedPrice);
        } else if (convertRequest.getCustomerTenure() >= 2L) {
            BigDecimal discount = new BigDecimal("0.05");
            BigDecimal discountedPrice = convertRequest.getTotalAmount().subtract(convertRequest.getTotalAmount().multiply(discount));
            convertRequest.setTotalAmount(discountedPrice);
        }

        ExchangeResponse exchangeResponse = exchangeService.getExchangeRateWithAmount(
                convertRequest.getOriginalCurrency(),convertRequest.getTargetCurrency(), convertRequest.getTotalAmount()
        );

        return new ExchangeRate(exchangeResponse.getResult());
    }

}
