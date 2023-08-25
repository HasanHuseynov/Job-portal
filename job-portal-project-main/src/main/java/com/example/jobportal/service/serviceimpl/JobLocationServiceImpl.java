package com.example.jobportal.service.serviceimpl;

import com.example.jobportal.dto.request.JobLocationRequest;
import com.example.jobportal.dto.response.JobLocationResponse;
import com.example.jobportal.entity.JobLocation;
import com.example.jobportal.exception.NotDataFound;
import com.example.jobportal.mapper.JobLocationMapper;
import com.example.jobportal.repository.JobLocationRepository;
import com.example.jobportal.service.JobLocationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class JobLocationServiceImpl implements JobLocationService {
    private final JobLocationRepository jobLocationRepository;
    private final JobLocationMapper jobLocationMapper;

    @Override
    public List<JobLocationResponse> getAllJobLocations() {
        List<JobLocation> jobLocationEntities = jobLocationRepository.findAll();
        return jobLocationMapper.toDTOs(jobLocationEntities);
    }

    @Override
    public JobLocationResponse createNewJobLocation(JobLocationRequest jobLocationRequest) {
        JobLocation jobLocationEntity = jobLocationMapper.fromDTO(jobLocationRequest);
        jobLocationEntity = jobLocationRepository.save(jobLocationEntity);
        return jobLocationMapper.toDTO(jobLocationEntity);
    }

    @Override
    public void deleteById(Integer id) {
        JobLocation jobLocationEntity = jobLocationRepository.findById(id).orElseThrow(() -> {
            return new NotDataFound("Job location not found with id: " + id);
        });
        jobLocationRepository.delete(jobLocationEntity);
    }

    @Override
    public void updateJobLocation(Integer id, JobLocationRequest jobLocationRequest) {
        var jobLocationEntity = jobLocationRepository.findById(id)
                .orElseThrow(() -> new NotDataFound("Job location not found"));

        jobLocationMapper.mapUpdateRequestToEntity(jobLocationEntity, jobLocationRequest);
        jobLocationRepository.save(jobLocationEntity);
    }
}
