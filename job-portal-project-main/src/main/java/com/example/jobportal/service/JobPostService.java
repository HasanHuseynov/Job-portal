package com.example.jobportal.service;

import com.example.jobportal.dto.SearchCriteriaDTO;
import com.example.jobportal.dto.request.JobPostRequest;
import com.example.jobportal.dto.response.JobPostResponse;
import com.example.jobportal.entity.JobPost;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface JobPostService {
    Page<JobPostResponse> getAllJobPosts(Pageable pageable);

    Optional<JobPostResponse> getJobById(Integer id);

    List<JobPost> findJobPostsExpiringWithinThreeDays();

    JobPostResponse createNewJobPost(JobPostRequest jobPostRequest);

    void deleteById(Integer id);

    void deactivateExpiredJobPosts();

    void findMatchingUsers(LocalDate startDate, LocalDate endDate);

    void updateJobPost(Integer id, JobPostRequest jobPostRequest);

    List<JobPost> searchJobPosts(SearchCriteriaDTO searchCriteria);

    void promoteJobPost(Integer id);


    Page<JobPostResponse> getAllActiveJobs(Pageable pageable);

}
