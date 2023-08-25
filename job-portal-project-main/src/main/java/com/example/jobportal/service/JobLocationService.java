package com.example.jobportal.service;

import com.example.jobportal.dto.request.JobLocationRequest;
import com.example.jobportal.dto.response.JobLocationResponse;

import java.util.List;

public interface JobLocationService {
    List<JobLocationResponse> getAllJobLocations();

    JobLocationResponse createNewJobLocation(JobLocationRequest jobLocationRequest);

    void updateJobLocation(Integer id, JobLocationRequest jobLocationRequest);

    void deleteById(Integer id);
}
