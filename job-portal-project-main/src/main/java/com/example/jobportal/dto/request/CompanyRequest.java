package com.example.jobportal.dto.request;


import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDate;

@Slf4j
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CompanyRequest {
    private Integer id;
    @Email
    @NotNull(message = "Email cannot be empty or null")
    private String companyEmail;
    @NotNull(message = "Company name cannot be empty or null")
    private String companyName;
    private String profileDescription;
    private LocalDate establishmentDate;
    @NotNull(message = "Balance cannot be empty or null")
    private Integer balance;
}
