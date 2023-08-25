package com.example.jobportal.service;

import com.example.jobportal.dto.request.UserLogRequest;
import com.example.jobportal.dto.response.UserLogResponse;

import java.util.List;

public interface UserLogService {
    List<UserLogResponse> getAllUserLogs();

    UserLogResponse createNewUserLog(UserLogRequest userLogRequest);

    void updateUserLog(Integer id, UserLogRequest userLogRequest);

    void deleteById(Integer Id);
}
