package com.example.jobportal.dto.response;


import lombok.*;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SeekerProfileResponse {
    private Integer seekerId;
    private String firstName;
    private String lastName;
    private String major;
    private UserResponse user;
    private List<EducationDetailResponse> educationDetails;
    private List<ExperienceDetailResponse> experienceDetails;
}
