package com.example.jobportal.controller;

import com.example.jobportal.dto.request.JobLocationRequest;
import com.example.jobportal.dto.response.JobLocationResponse;
import com.example.jobportal.service.JobLocationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping({"/job-location"})
@RequiredArgsConstructor
public class JobLocationController {
    private final JobLocationService jobLocationService;

    @GetMapping
    public ResponseEntity<List<JobLocationResponse>> getAllJobLocations() {

        return ResponseEntity.ok(jobLocationService.getAllJobLocations());
    }

    @PostMapping
    public ResponseEntity<JobLocationResponse> createNewJobLocation(@Valid @RequestBody JobLocationRequest jobLocationRequest) {
        return ResponseEntity.ok(jobLocationService.createNewJobLocation(jobLocationRequest));
    }

    @PutMapping("/id/{id}")
    public ResponseEntity<String> updateJobLocation(@PathVariable Integer id, @Valid @RequestBody JobLocationRequest jobLocationRequest) {
        jobLocationService.updateJobLocation(id, jobLocationRequest);
        return ResponseEntity.ok("Job Location updated successfully!");
    }

    @DeleteMapping({"/id/{id}"})
    public ResponseEntity<String> deleteJobLocation(@PathVariable Integer id) {
        jobLocationService.deleteById(id);
        return ResponseEntity.ok("Job location deleted successfully!");
    }


}
