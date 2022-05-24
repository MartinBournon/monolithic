package com.practice.spring.monolitic.errorHandler.exception;

public class ItemsNotMatchQueryException extends RuntimeException{
    public ItemsNotMatchQueryException(String resourceName){
        super(String.format(
                "No %s matches with the given query",
                resourceName
        ));
    }
}
