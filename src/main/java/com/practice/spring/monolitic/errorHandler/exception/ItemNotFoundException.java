package com.practice.spring.monolitic.errorHandler.exception;

public class ItemNotFoundException extends RuntimeException {
    public ItemNotFoundException(String itemName, String id) {
        super(String.format(
                "%s with id %s not found",
                itemName,
                id
        ));
    }
}
