package com.example.jobportal.mapper;

import com.example.jobportal.dto.request.JobLocationRequest;
import com.example.jobportal.dto.response.JobLocationResponse;
import com.example.jobportal.entity.JobLocation;
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
public interface JobLocationMapper {
    JobLocation fromDTO(JobLocationRequest jobLocationRequest);

    JobLocationResponse toDTO(JobLocation jobLocation);

    List<JobLocationResponse> toDTOs(List<JobLocation> jobLocations);

    void mapUpdateRequestToEntity(@MappingTarget JobLocation jobLocation, JobLocationRequest jobLocationRequest);

}
