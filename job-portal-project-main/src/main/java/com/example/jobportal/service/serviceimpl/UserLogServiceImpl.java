package com.example.jobportal.service.serviceimpl;

import com.example.jobportal.dto.request.UserLogRequest;
import com.example.jobportal.dto.response.UserLogResponse;
import com.example.jobportal.entity.UserLog;
import com.example.jobportal.exception.NotDataFound;
import com.example.jobportal.mapper.UserLogMapper;
import com.example.jobportal.repository.UserLogRepository;
import com.example.jobportal.service.UserLogService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserLogServiceImpl implements UserLogService {
    private final UserLogRepository userLogRepository;
    private final UserLogMapper userLogMapper;

    @Override
    public List<UserLogResponse> getAllUserLogs() {
        List<UserLog> userLogEntities = userLogRepository.findAll();
        return userLogMapper.toDTOs(userLogEntities);
    }

    @Override
    public UserLogResponse createNewUserLog(UserLogRequest userLogRequest) {
        UserLog userLogEntity = userLogMapper.fromDTO(userLogRequest);
        userLogEntity = userLogRepository.save(userLogEntity);
        return userLogMapper.toDTO(userLogEntity);
    }

    @Override
    public void deleteById(Integer id) {
        UserLog userLogEntity = userLogRepository.findById(id).orElseThrow(() -> {
            return new NotDataFound("User log not found with id: " + id);
        });
        userLogRepository.delete(userLogEntity);
    }

    @Override
    public void updateUserLog(Integer id, UserLogRequest userLogRequest) {
        var userLogEntity = userLogRepository.findById(id)
                .orElseThrow(() -> new NotDataFound("User log not found"));

        userLogMapper.mapUpdateRequestToEntity(userLogEntity, userLogRequest);
        userLogRepository.save(userLogEntity);
    }
}
