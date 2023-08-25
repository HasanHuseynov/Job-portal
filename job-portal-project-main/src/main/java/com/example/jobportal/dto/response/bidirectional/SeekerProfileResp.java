package com.example.jobportal.dto.response.bidirectional;


import com.example.jobportal.dto.response.EducationDetailResponse;
import com.example.jobportal.dto.response.ExperienceDetailResponse;
import lombok.*;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SeekerProfileResp {
    private Integer seekerId;
    private String firstName;
    private String lastName;
    private List<EducationDetailResponse> educationDetails;
    private List<ExperienceDetailResponse> experienceDetails;
    private String major;


}
