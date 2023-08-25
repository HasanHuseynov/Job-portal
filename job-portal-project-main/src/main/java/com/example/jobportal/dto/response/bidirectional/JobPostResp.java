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
public class JobPostResp {
    private Integer jobPostId;
    private LocalDate createdDate;
    private String priority;
    private String jobDescription;
    private String status;
    private LocalDate expirationDate;
    private Integer salary;
    private LocalDate promotionEndDate;
    private String major;
}
