package com.example.jobportal.mapper;

import com.example.jobportal.dto.request.SeekerProfileRequest;
import com.example.jobportal.dto.response.SeekerProfileResponse;
import com.example.jobportal.entity.SeekerProfile;
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
public interface SeekerProfileMapper {
    SeekerProfile fromDTO(SeekerProfileRequest seekerProfileRequest);

    SeekerProfileResponse toDTO(SeekerProfile seekerProfile);

    List<SeekerProfileResponse> toDTOs(List<SeekerProfile> seekerProfiles);

    void mapUpdateRequestToEntity(@MappingTarget SeekerProfile seekerProfile, SeekerProfileRequest seekerProfileRequest);

}
