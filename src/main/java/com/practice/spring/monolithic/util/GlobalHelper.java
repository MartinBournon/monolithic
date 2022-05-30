package com.practice.spring.monolithic.util;

import com.practice.spring.monolithic.dto.SimpleCRUDResponseDTO;
import com.practice.spring.monolithic.errorHandler.exception.CustomLocalDateParsingException;

import java.time.LocalDate;

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

    public static LocalDate parseLocalDateFromString(String str){
        try{
            return LocalDate.parse(str, Constants.DATE_TIME_FORMATTER);
        }catch (CustomLocalDateParsingException ex){
            throw new CustomLocalDateParsingException(str, Constants.LOCAL_DATE_FORMAT);
        }
    }
}
