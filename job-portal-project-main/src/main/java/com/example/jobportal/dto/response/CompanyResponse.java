package com.example.jobportal.dto.response;


import com.example.jobportal.dto.response.bidirectional.JobPostResp;
import lombok.*;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDate;
import java.util.List;

@Slf4j
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CompanyResponse {
    private Integer id;
    private String companyName;
    private String profileDescription;
    private String companyEmail;
    private LocalDate establishmentDate;
    private Integer balance;
    private List<JobPostResp> jobPosts;
}
