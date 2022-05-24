package com.practice.spring.monolitic.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class HotelDTO {
    private String hotelCode;
    private String hotelName;
    private String place;
}
