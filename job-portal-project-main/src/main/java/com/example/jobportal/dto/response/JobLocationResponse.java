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
public class JobLocationResponse {
    private int jobLocationId;
    private String streetAddress;
    private String city;
    private String state;
    private String country;
    private String zip;

    private List<JobPostResponse> jobPost;
}
