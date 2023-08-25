package com.example.jobportal.mapper;

import com.example.jobportal.dto.request.JobTypesRequest;
import com.example.jobportal.dto.response.JobTypesResponse;
import com.example.jobportal.entity.JobTypes;
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
public interface JobTypesMapper {
    JobTypes fromDTO(JobTypesRequest jobTypeRequest);

    JobTypesResponse toDTO(JobTypes jobType);

    List<JobTypesResponse> toDTOs(List<JobTypes> jobTypes);

    void mapUpdateRequestToEntity(@MappingTarget JobTypes jobTypes, JobTypesRequest jobTypesRequest);

}
