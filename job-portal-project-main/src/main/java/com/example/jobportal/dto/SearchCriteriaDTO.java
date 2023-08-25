package com.example.jobportal.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDate;

@Slf4j
@Getter
@Setter
public class SearchCriteriaDTO {
    private Integer jobLocationId;
    private Integer jobTypeId;
    private Integer companyId;
    private String major;
    private String status;
    private LocalDate createdDate;
    private String jobDescription;
    private Integer salary;
    private LocalDate expirationDate;
}