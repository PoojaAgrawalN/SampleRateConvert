package com.example.demo.service.impl;

import com.example.demo.exception.ExchangeNotFoundException;
import com.example.demo.model.dto.response.ExchangeResponse;
import com.example.demo.service.ExchangeService;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.Optional;

import static com.example.demo.utils.Constants.EXCHANGE_API_API_KEY;
import static com.example.demo.utils.Constants.EXCHANGE_API_BASE_URL;

/**
 * Implementation of the {@link ExchangeService} interface.
 * Provides functionality to fetch exchange rates and amounts from a remote exchange rate API.
 * Caches responses for exchange rate requests to improve performance and reduce redundant API calls.
 */
@Service
@RequiredArgsConstructor
public class ExchangeServiceImpl implements ExchangeService {
    @Override
    public ExchangeResponse getExchangeRateWithAmount(final String from, final String to, final BigDecimal amount) {
        RestTemplate restTemplate = new RestTemplate();
        final String url = getExchangeUrl(from, to, amount);

        return Optional.ofNullable(restTemplate.getForObject(url, ExchangeResponse.class))
                .orElseThrow(() -> new ExchangeNotFoundException("Exchange rate not found for " + from + " to " + to));

    }


    private String getExchangeUrl(final String from, final String to, final BigDecimal amount) {
        return String.format("%s/exchangerates_data/convert?apikey=%s&from=%s&to=%s&amount=%s", EXCHANGE_API_BASE_URL, EXCHANGE_API_API_KEY, from, to, amount);
    }

}
