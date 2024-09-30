package com.example.demo.model.dto.request;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;


@Getter
@Setter
@Builder
public class ConvertRequest {

    private String originalCurrency;

    private String targetCurrency;

    private List<String> items;

    private long customerTenure;

    private String userType;

    private BigDecimal totalAmount;
}
