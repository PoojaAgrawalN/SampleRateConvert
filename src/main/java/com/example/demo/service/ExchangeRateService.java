package com.example.demo.service;

import com.example.demo.model.ExchangeRate;
import com.example.demo.model.dto.request.ConvertRequest;
import com.example.demo.model.dto.response.ExchangeResponse;

import java.math.BigDecimal;

/**
 * Service interface for handling exchange rate operations.
 */
public interface ExchangeRateService {

    ExchangeRate exchangeRate(ConvertRequest convertRequest);

}
