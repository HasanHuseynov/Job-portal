package com.example.jobportal.dto.request;


import jakarta.validation.constraints.NotEmpty;
import lombok.*;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class JobTypesRequest {
    private Integer jobTypeId;
    @NotEmpty(message = "Job type cannot be empty or null!")
    private String jobType;


}
