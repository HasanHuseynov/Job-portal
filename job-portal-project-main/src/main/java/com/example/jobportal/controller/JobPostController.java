package com.example.jobportal.controller;

import com.example.jobportal.dto.SearchCriteriaDTO;
import com.example.jobportal.dto.request.JobPostRequest;
import com.example.jobportal.dto.response.JobPostResponse;
import com.example.jobportal.entity.JobPost;
import com.example.jobportal.service.JobPostService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/job-post")
@RequiredArgsConstructor

public class JobPostController {
    private final JobPostService jobPostService;

    @GetMapping
    public ResponseEntity<Page<JobPostResponse>> getAllJobPosts(Pageable pageable) {
        return ResponseEntity.ok(jobPostService.getAllJobPosts(pageable));
    }

    @GetMapping("/active")
    public ResponseEntity<Page<JobPostResponse>> getAllActiveJobPosts(Pageable pageable) {
        return ResponseEntity.ok(jobPostService.getAllActiveJobs(pageable));
    }

    @PostMapping
    public ResponseEntity<JobPostResponse> createNewJobPost(@Valid @RequestBody JobPostRequest jobPostRequest) {
        return ResponseEntity.ok(jobPostService.createNewJobPost(jobPostRequest));
    }

    @GetMapping({"/id/{id}"})
    public ResponseEntity<Optional<JobPostResponse>> getJobById(@PathVariable Integer id) {

        return ResponseEntity.ok(jobPostService.getJobById(id));
    }

    @PutMapping("/id/{id}")
    public ResponseEntity<String> updateJobPost(@PathVariable Integer id, @Valid @RequestBody JobPostRequest jobPostRequest) {
        jobPostService.updateJobPost(id, jobPostRequest);
        return ResponseEntity.ok("Job post updated successfully!");
    }


    @DeleteMapping({"/id/{id}"})
    public ResponseEntity<String> deleteJobPost(@PathVariable Integer id) {
        jobPostService.deleteById(id);
        return ResponseEntity.ok("Job post deleted successfully!");
    }


    @GetMapping("/search-job")
    public ResponseEntity<List<JobPost>> searchJobPosts(@ModelAttribute SearchCriteriaDTO searchCriteria) {
        return ResponseEntity.ok(jobPostService.searchJobPosts(searchCriteria));
    }


}
