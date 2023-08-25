package com.example.jobportal.mapper;

import com.example.jobportal.dto.request.JobPostRequest;
import com.example.jobportal.dto.response.JobPostResponse;
import com.example.jobportal.entity.JobPost;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.List;

@Mapper(
        componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        builder = @Builder(disableBuilder = true)
)
public interface JobPostMapper {
    JobPost fromDTO(JobPostRequest jobPostRequest);

    JobPostResponse toDTO(JobPost jobPost);

    List<JobPostResponse> toDTOs(List<JobPost> jobPosts);


    default Page<JobPostResponse> toDTOp(Page<JobPost> jobPosts) {
        List<JobPostResponse> jobPostResponses = toDTOs(jobPosts.getContent());
        return new PageImpl<>(jobPostResponses, Pageable.unpaged(), jobPosts.getTotalElements());
    }


    void mapUpdateRequestToEntity(@MappingTarget JobPost jobPost, JobPostRequest jobPostRequest);

}
