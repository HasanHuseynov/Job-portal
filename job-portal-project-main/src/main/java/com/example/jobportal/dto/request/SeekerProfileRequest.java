package com.example.jobportal.dto.request;


import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SeekerProfileRequest {
    private Integer seekerId;
    @NotEmpty(message = "Name cannot be null or empty")
    private String firstName;
    @NotEmpty(message = "last name cannot be null or empty")
    private String lastName;
    @NotEmpty(message = "Major cannot be null or empty")
    private String major;
    private byte[] cv;

}
