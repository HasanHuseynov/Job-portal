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
public class JobPostActivityResponse {
    private Integer jobPostActivityId;

//    private JobPost jobPost;

    private LocalDate applyDate;

    private UserResponse user;

    private JobPostResponse jobPost;

}
