package com.example.jobportal.service;

import com.example.jobportal.dto.request.UserTypesRequest;
import com.example.jobportal.dto.response.UserTypesResponse;

import java.util.List;

public interface UserTypeService {
    List<UserTypesResponse> getAllUserTypes();

    UserTypesResponse createUserType(UserTypesRequest userTypesRequest);

    void updateUserType(Integer id, UserTypesRequest userTypeRequest);

    void deleteById(Integer Id);
}
