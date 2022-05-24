package com.practice.spring.monolitic.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class HotelDTO {
    @NotNull
    @NotBlank
    private String hotelCode;
    @NotNull
    @NotBlank
    private String hotelName;
    @NotNull
    @NotBlank
    private String place;
}
