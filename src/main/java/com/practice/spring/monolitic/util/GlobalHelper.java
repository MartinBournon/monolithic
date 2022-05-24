package com.practice.spring.monolitic.util;

import com.practice.spring.monolitic.dto.SimpleCRUDResponseDTO;

public class GlobalHelper {

    public enum CRUDActionType{
        CREATED("created"),
        UPDATED("updated"),
        DELETED("deleted");

        public final String message;

        CRUDActionType(String message){
            this.message = message;
        }
    }

    public static SimpleCRUDResponseDTO createResponse(String resourceName, String resourceId, CRUDActionType action){
        return new SimpleCRUDResponseDTO(String.format(
                "%s with id %s %s successfully",
                resourceName,
                resourceId,
                action
        ));
    }
}
