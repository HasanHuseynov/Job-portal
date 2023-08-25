package com.example.jobportal.dto.response;


import com.example.jobportal.dto.response.bidirectional.JobPostActivityResp;
import com.example.jobportal.dto.response.bidirectional.SeekerProfileResp;
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
public class UserResponse {
    private int id;
    private String email;
    private String password;
    private LocalDate dateOfBirth;
    private String gender;
    private String status;
    private Long contactNumber;
    private LocalDate registrationDate;
    private List<UserLogResponse> userLogs;
    private SeekerProfileResp seekerProfile;

    private List<JobPostActivityResp> jobPostActivities;
}
