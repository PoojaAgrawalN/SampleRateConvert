package com.example.demo.exception;

import com.example.demo.exception.error.CustomError;
import lombok.Getter;


@Getter
public class RestTemplateErrorException extends RuntimeException {

    private final CustomError customError;

    public RestTemplateErrorException(final CustomError customError) {
        super(customError.getMessage());
        this.customError = customError;
    }


}