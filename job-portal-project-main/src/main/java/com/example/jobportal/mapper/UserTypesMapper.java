package com.example.jobportal.mapper;

import com.example.jobportal.dto.request.UserTypesRequest;
import com.example.jobportal.dto.response.UserTypesResponse;
import com.example.jobportal.entity.UserTypes;
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
public interface UserTypesMapper {
    UserTypes fromDTO(UserTypesRequest userTypeRequest);

    UserTypesResponse toDTO(UserTypes userType);

    List<UserTypesResponse> toDTOs(List<UserTypes> userTypes);

    void mapUpdateRequestToEntity(@MappingTarget UserTypes userTypes, UserTypesRequest userTypesRequest);

}
