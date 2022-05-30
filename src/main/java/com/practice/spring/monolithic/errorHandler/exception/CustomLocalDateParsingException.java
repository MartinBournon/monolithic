package com.practice.spring.monolithic.errorHandler.exception;

public class CustomLocalDateParsingException extends RuntimeException{
    public CustomLocalDateParsingException(String parsedString, String expectedFormat){
        super(String.format(
                "%s does not follow the accepted format: %s",
                parsedString,
                expectedFormat
                ));
    }
}
