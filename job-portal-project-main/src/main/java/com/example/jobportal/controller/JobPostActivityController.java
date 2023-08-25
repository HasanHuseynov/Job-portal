package com.example.jobportal.controller;

import com.example.jobportal.dto.request.JobPostActivityRequest;
import com.example.jobportal.dto.response.JobPostActivityResponse;
import com.example.jobportal.service.JobPostActivityService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping({"/job-post-activity"})
@RequiredArgsConstructor
public class JobPostActivityController {
    private final JobPostActivityService jobPostActivityService;

    @GetMapping
    public ResponseEntity<List<JobPostActivityResponse>> getAllJobPostActivities() {
        return ResponseEntity.ok(jobPostActivityService.getAllJobPostActivities());
    }

    @PostMapping
    public ResponseEntity<JobPostActivityResponse> createNewJobPostActivity(@Valid @RequestBody JobPostActivityRequest jobPostActivityRequest) {
        return ResponseEntity.ok(jobPostActivityService.createNewJobPostActivity(jobPostActivityRequest));
    }

    @PutMapping("/id/{id}")
    public ResponseEntity<String> updateJobPostActivity(@PathVariable Integer id, @Valid @RequestBody JobPostActivityRequest jobPostActivityRequest) {
        jobPostActivityService.updateJobPostActivity(id, jobPostActivityRequest);
        return ResponseEntity.ok("Job post activity updated successfully!");
    }

    @PostMapping("/apply-to-job")
    public ResponseEntity<JobPostActivityResponse> applyToJob(@RequestParam Integer userId, @RequestParam Integer jobPostId) {
        return ResponseEntity.ok(jobPostActivityService.applyToJob(userId, jobPostId));
    }

    @DeleteMapping({"/id/{id}"})
    public ResponseEntity<String> deleteJobPostActivity(@PathVariable Integer id) {
        jobPostActivityService.deleteById(id);
        return ResponseEntity.ok("Job post activity deleted successfully!");
    }



}
