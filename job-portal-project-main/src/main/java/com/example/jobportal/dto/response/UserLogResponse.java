package com.example.jobportal.dto.response;

import lombok.*;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDate;

@Slf4j
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserLogResponse {
    private Integer userLogId;
    private LocalDate lastLoginDate;
    //private LocalDate lastJobApplyDate;


}
