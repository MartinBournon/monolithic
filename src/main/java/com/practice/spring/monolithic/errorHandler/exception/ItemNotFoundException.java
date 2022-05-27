package com.practice.spring.monolithic.errorHandler.exception;

public class ItemNotFoundException extends RuntimeException {
    public ItemNotFoundException(String itemName, String id) {
        super(String.format(
                "%s with id %s not found",
                itemName,
                id
        ));
    }
}