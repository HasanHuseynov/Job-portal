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
public class ExperienceDetailResponse {
    private int experienceId;
    private String isCurrentJob;
    private LocalDate startDate;
    private LocalDate endDate;
    private String jobTitle;
    private String companyName;
    private String jobLocationCity;
    private String jobLocationState;
    private String jobLocationCountry;
    private String description;


}
