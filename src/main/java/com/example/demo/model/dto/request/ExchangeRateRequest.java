package com.example.demo.model.dto.request;

import jakarta.validation.constraints.Pattern;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * Represents a request to retrieve the exchange rate between two currencies.
 * This class encapsulates the details required to request an exchange rate,
 * including the source currency and the target currency. It includes validation
 * annotations to ensure that the currency codes conform to a specific format.
 */
@Getter
@Setter
@Builder
public class ExchangeRateRequest {

    private String from;

    private String to;

}
