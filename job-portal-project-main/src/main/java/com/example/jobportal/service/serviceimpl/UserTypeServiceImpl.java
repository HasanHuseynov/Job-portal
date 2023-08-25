package com.example.jobportal.service.serviceimpl;

import com.example.jobportal.dto.request.UserTypesRequest;
import com.example.jobportal.dto.response.UserTypesResponse;
import com.example.jobportal.entity.UserTypes;
import com.example.jobportal.exception.NotDataFound;
import com.example.jobportal.mapper.UserTypesMapper;
import com.example.jobportal.repository.UserTypesRepository;
import com.example.jobportal.service.UserTypeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserTypeServiceImpl implements UserTypeService {
    private final UserTypesRepository userTypeRepository;
    private final UserTypesMapper userTypeMapper;

    @Override
    public List<UserTypesResponse> getAllUserTypes() {
        List<UserTypes> userTypeEntities = userTypeRepository.findAll();
        return userTypeMapper.toDTOs(userTypeEntities);
    }

    @Override
    public UserTypesResponse createUserType(UserTypesRequest userTypeRequest) {
        UserTypes userTypeEntity = userTypeMapper.fromDTO(userTypeRequest);
        userTypeEntity = userTypeRepository.save(userTypeEntity);
        return userTypeMapper.toDTO(userTypeEntity);
    }

    @Override
    public void deleteById(Integer id) {
        UserTypes userTypeEntity = userTypeRepository.findById(id).orElseThrow(() -> {
            return new NotDataFound("User type not found with id: " + id);
        });
        userTypeRepository.delete(userTypeEntity);
    }

    @Override
    public void updateUserType(Integer id, UserTypesRequest userTypeRequest) {
        var userTypeEntity = userTypeRepository.findById(id)
                .orElseThrow(() -> new NotDataFound("User type not found"));

        userTypeMapper.mapUpdateRequestToEntity(userTypeEntity, userTypeRequest);
        userTypeRepository.save(userTypeEntity);
    }
}
