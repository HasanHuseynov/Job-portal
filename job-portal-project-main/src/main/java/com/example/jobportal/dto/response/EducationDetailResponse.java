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
public class EducationDetailResponse {
    private Integer educationDetailId;
    private String major;
    private String certificateDegreeName;
    private String universityName;
    private LocalDate startingDate;
    private LocalDate completionDate;
    private String degree;
    private Integer gpa;


}
