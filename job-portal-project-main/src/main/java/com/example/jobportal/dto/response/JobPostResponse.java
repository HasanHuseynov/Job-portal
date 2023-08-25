package com.example.jobportal.dto.response;


import com.example.jobportal.dto.response.bidirectional.JobLocationResp;
import lombok.*;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDate;

@Slf4j
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class JobPostResponse {
    private Integer jobPostId;
    private LocalDate createdDate;
    private String priority;
    private String jobDescription;
    private String status;
    private LocalDate expirationDate;
    private Integer salary;
    private String major;
    private CompanyResponse company;
    private LocalDate promotionEndDate;
    private JobLocationResp jobLocation;

}
