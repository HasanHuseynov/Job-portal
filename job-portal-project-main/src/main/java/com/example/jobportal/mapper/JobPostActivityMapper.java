package com.example.jobportal.mapper;

import com.example.jobportal.dto.request.JobPostActivityRequest;
import com.example.jobportal.dto.response.JobPostActivityResponse;
import com.example.jobportal.entity.JobPostActivity;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(
        componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        builder = @Builder(disableBuilder = true)
)
public interface JobPostActivityMapper {
    JobPostActivity fromDTO(JobPostActivityRequest jobPostActivityRequest);

    JobPostActivityResponse toDTO(JobPostActivity jobPostActivity);

    List<JobPostActivityResponse> toDTOs(List<JobPostActivity> jobPostActivities);

    void mapUpdateRequestToEntity(@MappingTarget JobPostActivity jobPostActivity, JobPostActivityRequest jobPostActivityRequest);

}
