package com.example.jobportal.service.serviceimpl;

import com.example.jobportal.dto.request.JobTypesRequest;
import com.example.jobportal.dto.response.JobTypesResponse;
import com.example.jobportal.entity.JobTypes;
import com.example.jobportal.exception.NotDataFound;
import com.example.jobportal.mapper.JobTypesMapper;
import com.example.jobportal.repository.JobTypesRepository;
import com.example.jobportal.service.JobTypesService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class JobTypesServiceImpl implements JobTypesService {
    private final JobTypesRepository jobTypesRepository;
    private final JobTypesMapper jobTypesMapper;

    @Override
    public List<JobTypesResponse> getAllJobTypes() {
        List<JobTypes> jobTypesEntities = jobTypesRepository.findAll();
        return jobTypesMapper.toDTOs(jobTypesEntities);
    }

    @Override
    public JobTypesResponse createNewJobType(JobTypesRequest jobTypesRequest) {
        JobTypes jobTypesEntity = jobTypesMapper.fromDTO(jobTypesRequest);
        jobTypesEntity = jobTypesRepository.save(jobTypesEntity);
        return jobTypesMapper.toDTO(jobTypesEntity);
    }

    @Override
    public void deleteById(Integer id) {
        JobTypes jobTypesEntity = jobTypesRepository.findById(id).orElseThrow(() -> {
            return new NotDataFound("Job type not found with id: " + id);
        });
        jobTypesRepository.delete(jobTypesEntity);
    }

    @Override
    public void updateJobType(Integer id, JobTypesRequest jobTypeRequest) {
        var jobTypeEntity = jobTypesRepository.findById(id)
                .orElseThrow(() -> new NotDataFound("Job type not found"));

        jobTypesMapper.mapUpdateRequestToEntity(jobTypeEntity, jobTypeRequest);
        jobTypesRepository.save(jobTypeEntity);
    }
}
