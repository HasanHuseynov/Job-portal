package com.example.jobportal.dto.request;


import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Slf4j
public class JobPostRequest {
    private Integer jobPostId;
    @NotNull(message = "Created date cannot be null")
    private LocalDate createdDate;
    @NotNull(message = "Job description cannot be null")
    private String jobDescription;
    @NotNull(message = "Salary cannot be null")
    private Integer salary;
    private String priority;
    @NotEmpty(message = "Statis cannot be null or empty")
    private String status;
    @NotNull(message = "Expiration date cannot be null")
    private LocalDate expirationDate;
    @NotNull(message = "Major cannot be null")
    private String major;
    private LocalDateTime promotionEndDate;
}
