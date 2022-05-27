package com.practice.spring.monolithic.errorHandler.exception;

public class ItemsNotMatchQueryException extends RuntimeException{
    public ItemsNotMatchQueryException(String resourceName){
        super(String.format(
                "No %s matches with the given query",
                resourceName
        ));
    }
}
