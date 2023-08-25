package com.example.jobportal.service;

import com.example.jobportal.dto.request.UserRequest;
import com.example.jobportal.dto.response.UserResponse;

import java.util.List;

public interface UserService {
    List<UserResponse> getAllUser();

    UserResponse createNewUser(UserRequest userRequest);

    void updateUser(Integer id, UserRequest userRequest);

    void deleteById(Integer id);


}
