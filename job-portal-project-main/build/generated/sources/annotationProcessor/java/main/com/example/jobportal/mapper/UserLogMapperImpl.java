package com.example.jobportal.mapper;

import com.example.jobportal.dto.request.UserLogRequest;
import com.example.jobportal.dto.response.UserLogResponse;
import com.example.jobportal.entity.UserLog;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-08-25T02:24:51+0400",
    comments = "version: 1.5.3.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.6.1.jar, environment: Java 17.0.6 (Oracle Corporation)"
)
@Component
public class UserLogMapperImpl implements UserLogMapper {

    @Override
    public UserLog fromDTO(UserLogRequest userLogRequest) {
        if ( userLogRequest == null ) {
            return null;
        }

        UserLog userLog = new UserLog();

        userLog.setUserLogId( userLogRequest.getUserLogId() );
        userLog.setLastLoginDate( userLogRequest.getLastLoginDate() );

        return userLog;
    }

    @Override
    public UserLogResponse toDTO(UserLog userLog) {
        if ( userLog == null ) {
            return null;
        }

        UserLogResponse userLogResponse = new UserLogResponse();

        userLogResponse.setUserLogId( userLog.getUserLogId() );
        userLogResponse.setLastLoginDate( userLog.getLastLoginDate() );

        return userLogResponse;
    }

    @Override
    public List<UserLogResponse> toDTOs(List<UserLog> userLogs) {
        if ( userLogs == null ) {
            return null;
        }

        List<UserLogResponse> list = new ArrayList<UserLogResponse>( userLogs.size() );
        for ( UserLog userLog : userLogs ) {
            list.add( toDTO( userLog ) );
        }

        return list;
    }

    @Override
    public void mapUpdateRequestToEntity(UserLog userLog, UserLogRequest userLogRequest) {
        if ( userLogRequest == null ) {
            return;
        }

        userLog.setUserLogId( userLogRequest.getUserLogId() );
        userLog.setLastLoginDate( userLogRequest.getLastLoginDate() );
    }
}
