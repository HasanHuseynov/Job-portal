package com.example.jobportal.mapper;

import com.example.jobportal.dto.request.UserRequest;
import com.example.jobportal.dto.response.UserResponse;
import com.example.jobportal.entity.User;
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
public interface UserMapper {
    User fromDTO(UserRequest userRequest);

    UserResponse toDTO(User user);

    List<UserResponse> toDTOs(List<User> users);

    void mapUpdateRequestToEntity(@MappingTarget User user, UserRequest userRequest);


}
