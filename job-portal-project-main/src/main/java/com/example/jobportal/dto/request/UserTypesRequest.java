package com.example.jobportal.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.*;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserTypesRequest {
    private Integer id;
    @NotBlank(message = "User type cannot be empty or null")
    private String userTypeName;
}
