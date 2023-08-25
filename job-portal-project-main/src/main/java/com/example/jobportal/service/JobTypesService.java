package com.example.jobportal.service;

import com.example.jobportal.dto.request.JobTypesRequest;
import com.example.jobportal.dto.response.JobTypesResponse;

import java.util.List;

public interface JobTypesService {
    List<JobTypesResponse> getAllJobTypes();

    JobTypesResponse createNewJobType(JobTypesRequest jobTypeRequest);

    void updateJobType(Integer id, JobTypesRequest jobTypeRequest);

    void deleteById(Integer id);
}
