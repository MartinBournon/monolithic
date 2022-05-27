package com.practice.spring.monolithic.dto;

import lombok.Getter;

@Getter
public class ValidationError {
    private final String field;
    private final String message;

    public ValidationError(String field, String message) {
        this.field = field;
        this.message = message;
    }
}