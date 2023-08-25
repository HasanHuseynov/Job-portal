package com.example.jobportal.dto.request;


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
public class UserLogRequest {
    private Integer userLogId;
    @NotNull(message = "date cannot be null")
    private LocalDate lastLoginDate;

}
