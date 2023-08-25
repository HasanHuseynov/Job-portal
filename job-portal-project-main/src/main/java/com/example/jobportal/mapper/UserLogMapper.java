package com.example.jobportal.mapper;

import com.example.jobportal.dto.request.UserLogRequest;
import com.example.jobportal.dto.response.UserLogResponse;
import com.example.jobportal.entity.UserLog;
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
public interface UserLogMapper {
    UserLog fromDTO(UserLogRequest userLogRequest);

    UserLogResponse toDTO(UserLog userLog);

    List<UserLogResponse> toDTOs(List<UserLog> userLogs);

    void mapUpdateRequestToEntity(@MappingTarget UserLog userLog, UserLogRequest userLogRequest);

}
