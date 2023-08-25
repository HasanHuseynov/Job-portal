package com.example.jobportal.service;

import com.example.jobportal.dto.request.JobPostActivityRequest;
import com.example.jobportal.dto.response.JobPostActivityResponse;

import java.util.List;

public interface JobPostActivityService {
    List<JobPostActivityResponse> getAllJobPostActivities();

    JobPostActivityResponse createNewJobPostActivity(JobPostActivityRequest jobPostActivityRequest);

    void updateJobPostActivity(Integer id, JobPostActivityRequest jobPostActivityRequest);

    void deleteById(Integer id);

    JobPostActivityResponse applyToJob(Integer seekerId, Integer jobPostId);

//    void applyToJob(JobPostActivityRequest applicationRequest);
}
