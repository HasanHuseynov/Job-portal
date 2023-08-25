package com.example.jobportal.dto.request;


import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDate;

@Slf4j
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EducationDetailRequest {

    private Integer educationDetailId;
    @NotEmpty(message = "Major cannot be null or empty")
    private String major;
    @NotNull(message = "Certificate name cannot be null")
    private String certificateDegreeName;
    @NotNull(message = "University name cannot be null")
    private String universityName;
    @NotNull(message = "Staring date name cannot be null")
    private LocalDate startingDate;
    @NotNull(message = "Completion date name cannot be null")
    private LocalDate completionDate;
    @NotEmpty(message = "Degree name name cannot be null or empty")
    private String degree;
    @Size(max = 3, min = 1)
    private Integer gpa;


}
