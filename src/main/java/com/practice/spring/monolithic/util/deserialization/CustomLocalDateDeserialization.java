package com.practice.spring.monolithic.util.deserialization;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.practice.spring.monolithic.util.GlobalHelper;

import java.io.IOException;
import java.time.LocalDate;

public class CustomLocalDateDeserialization extends JsonDeserializer<LocalDate> {
    @Override
    public LocalDate deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        return GlobalHelper.parseLocalDateFromString(jsonParser.getText());
    }
}
