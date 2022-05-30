package com.practice.spring.monolithic.util;

import java.time.format.DateTimeFormatter;

public class Constants {
    public static final String LOCAL_DATE_FORMAT = "dd/MM/yyyy";
    public static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern(LOCAL_DATE_FORMAT);
}
