package com.example.jobportal.service.serviceimpl;

import com.example.jobportal.dto.request.UserRequest;
import com.example.jobportal.dto.response.UserResponse;
import com.example.jobportal.entity.User;
import com.example.jobportal.exception.NotDataFound;
import com.example.jobportal.mapper.UserMapper;
import com.example.jobportal.repository.UserRepository;
import com.example.jobportal.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public List<UserResponse> getAllUser() {
        List<User> userEntities = userRepository.findAll();
        return userMapper.toDTOs(userEntities);
    }

    @Override
    public UserResponse createNewUser(UserRequest userRequest) {
        User userEntity = userMapper.fromDTO(userRequest);
        userEntity = userRepository.save(userEntity);
        return userMapper.toDTO(userEntity);
    }

    @Override
    public void deleteById(Integer id) {
        User userEntity = userRepository.findById(id).orElseThrow(() -> {
            return new NotDataFound("User not found with id: " + id);
        });
        userRepository.delete(userEntity);
    }

    @Override
    public void updateUser(Integer id, UserRequest userRequest) {
        var userEntity = userRepository.findById(id)
                .orElseThrow(() -> new NotDataFound("User not found"));

        userMapper.mapUpdateRequestToEntity(userEntity, userRequest);
        userRepository.save(userEntity);
    }
}
