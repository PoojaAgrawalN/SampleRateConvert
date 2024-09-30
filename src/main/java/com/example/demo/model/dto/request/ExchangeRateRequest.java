package com.example.demo.model.dto.request;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ExchangeRateRequest {

    private String from;

    private String to;

}
