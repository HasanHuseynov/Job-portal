package com.example.jobportal.dto.request;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class JobLocationRequest {
    private int jobLocationId;
    @NotNull(message = "street address cannot be null")
    private String streetAddress;
    @NotNull(message = "City name cannot be null")
    private String city;
    @NotNull(message = "State name  cannot be null")
    private String state;
    @NotNull(message = "Country name cannot be null")
    private String country;
    @NotNull(message = "Zip name cannot be null")
    private String zip;
}
