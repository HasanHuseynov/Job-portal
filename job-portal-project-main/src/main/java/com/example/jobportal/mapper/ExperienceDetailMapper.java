package com.example.jobportal.mapper;

import com.example.jobportal.dto.request.ExperienceDetailRequest;
import com.example.jobportal.dto.response.ExperienceDetailResponse;
import com.example.jobportal.entity.ExperienceDetail;
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
public interface ExperienceDetailMapper {
    ExperienceDetail fromDTO(ExperienceDetailRequest experienceDetailRequest);

    ExperienceDetailResponse toDTO(ExperienceDetail experienceDetail);

    List<ExperienceDetailResponse> toDTOs(List<ExperienceDetail> experienceDetails);

    void mapUpdateRequestToEntity(@MappingTarget ExperienceDetail experienceDetail, ExperienceDetailRequest experienceDetailRequest);

}
