package com.practice.spring.monolithic.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.practice.spring.monolithic.util.deserialization.CustomLocalDateDeserialization;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PersonDTO {
    @NotBlank
    private String name;
    @NotBlank
    private String lastname;
    @NotBlank
    private String dni;
    @JsonDeserialize(using = CustomLocalDateDeserialization.class)
    private LocalDate birthdate;
    @NotBlank
    @Email(regexp = "^[a-zA-Z0-9_!#$%&’*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$", message = "Email is not valid")
    private String email;
}
