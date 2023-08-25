package com.example.jobportal.service.serviceimpl;

import com.example.jobportal.dto.request.JobPostActivityRequest;
import com.example.jobportal.dto.response.JobPostActivityResponse;
import com.example.jobportal.entity.JobPostActivity;
import com.example.jobportal.exception.NotDataFound;
import com.example.jobportal.mapper.JobPostActivityMapper;
import com.example.jobportal.repository.JobPostActivityRepository;
import com.example.jobportal.repository.JobPostRepository;
import com.example.jobportal.repository.UserRepository;
import com.example.jobportal.service.JobPostActivityService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class JobPostActivityServiceImpl implements JobPostActivityService {
    private final JobPostActivityRepository jobPostActivityRepository;
    private final JobPostRepository jobPostRepository;
    private final UserRepository userRepository;
    private final JobPostActivityMapper jobPostActivityMapper;

    @Override
    public List<JobPostActivityResponse> getAllJobPostActivities() {
        List<JobPostActivity> jobPostActivityEntities = jobPostActivityRepository.findAll();
        return jobPostActivityMapper.toDTOs(jobPostActivityEntities);
    }

    @Override
    public JobPostActivityResponse createNewJobPostActivity(JobPostActivityRequest jobPostActivityRequest) {
        JobPostActivity jobPostActivityEntity = jobPostActivityMapper.fromDTO(jobPostActivityRequest);
        jobPostActivityEntity = jobPostActivityRepository.save(jobPostActivityEntity);
        return jobPostActivityMapper.toDTO(jobPostActivityEntity);
    }

    @Override
    public void deleteById(Integer id) {
        JobPostActivity jobPostActivityEntity = jobPostActivityRepository.findById(id).orElseThrow(() -> {
            return new NotDataFound("Job post activity not found with id: " + id);
        });
        jobPostActivityRepository.delete(jobPostActivityEntity);
    }

    @Override
    public JobPostActivityResponse applyToJob(Integer seekerId, Integer jobPostId) {
        var jobPostActivityEntity = new JobPostActivity();
        var userEntity = userRepository.findById(seekerId).orElseThrow(() -> new NotDataFound("Not seeker profile found"));
        var jobPostEntity = jobPostRepository.findById(jobPostId).orElseThrow(() -> new NotDataFound("Not job post found"));
        if (userEntity != null || jobPostEntity != null) {
            jobPostActivityEntity.setApplyDate(LocalDate.now());
            jobPostActivityEntity.setJobPost(jobPostEntity);
            jobPostActivityEntity.setUser(userEntity);

        }
        jobPostActivityRepository.save(jobPostActivityEntity);
        return jobPostActivityMapper.toDTO(jobPostActivityEntity);
    }

    @Override
    public void updateJobPostActivity(Integer id, JobPostActivityRequest jobPostActivityRequest) {
        var jobPostActivityEntity = jobPostActivityRepository.findById(id)
                .orElseThrow(() -> new NotDataFound("Job post activity not found"));

        jobPostActivityMapper.mapUpdateRequestToEntity(jobPostActivityEntity, jobPostActivityRequest);
        jobPostActivityRepository.save(jobPostActivityEntity);
    }
}
