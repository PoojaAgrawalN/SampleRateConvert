package com.example.demo.model.dto.request;


import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

/**
 * Represents a request to convert an amount from one currency to another.
 * This class encapsulates the details required for a currency conversion request,
 * including the source currency, target currency, and the amount to be converted.
 * It includes validation annotations to ensure that the currency codes and amount
 * meet specific criteria.
 */
@Getter
@Setter
@Builder
public class ConvertRequest {

    private String originalCurrency;

    private String targetCurrency;

    private List<String> items;

    private long customerTenure;

    private String userType;

    @NotNull
    @Positive
    private BigDecimal totalAmount;
}
