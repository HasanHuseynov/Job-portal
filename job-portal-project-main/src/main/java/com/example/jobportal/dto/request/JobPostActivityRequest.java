package com.example.jobportal.dto.request;

import lombok.*;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDate;

@Slf4j
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class JobPostActivityRequest {
    private Integer jobPostActivityId;
    private LocalDate applyDate;
    private Integer userId;
    private Integer jobPostId;

}
