package com.example.jobportal.mapper;

import com.example.jobportal.dto.request.EducationDetailRequest;
import com.example.jobportal.dto.response.EducationDetailResponse;
import com.example.jobportal.entity.EducationDetail;
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
public interface EducationDetailMapper {
    EducationDetail fromDTO(EducationDetailRequest educationDetailRequest);

    EducationDetailResponse toDTO(EducationDetail educationDetail);

    List<EducationDetailResponse> toDTOs(List<EducationDetail> educationDetails);

    void mapUpdateRequestToEntity(@MappingTarget EducationDetail educationDetail, EducationDetailRequest educationDetailRequest);

}
