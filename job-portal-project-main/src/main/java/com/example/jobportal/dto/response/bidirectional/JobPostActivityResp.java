package com.example.jobportal.dto.response.bidirectional;

import lombok.*;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDate;

@Slf4j
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class JobPostActivityResp {
    private Integer jobPostActivityId;

    private LocalDate applyDate;

}
