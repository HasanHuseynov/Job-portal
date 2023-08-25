package com.example.jobportal.controller;

import com.example.jobportal.dto.request.JobTypesRequest;
import com.example.jobportal.dto.response.JobTypesResponse;
import com.example.jobportal.service.JobTypesService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping({"/job-types"})
@RequiredArgsConstructor
public class JobTypesController {
    private final JobTypesService jobTypesService;

    @GetMapping
    public ResponseEntity<List<JobTypesResponse>> getAllJobTypes() {
        return ResponseEntity.ok(jobTypesService.getAllJobTypes());
    }

    @PostMapping
    public ResponseEntity<JobTypesResponse> createNewJobType(@Valid @RequestBody JobTypesRequest jobTypesRequest) {
        return ResponseEntity.ok(jobTypesService.createNewJobType(jobTypesRequest));
    }

    @PutMapping("/id/{id}")
    public ResponseEntity<String> updateJobType(@PathVariable Integer id, @Valid @RequestBody JobTypesRequest jobTypeRequest) {
        jobTypesService.updateJobType(id, jobTypeRequest);
        return ResponseEntity.ok("Job type updated successfully!");
    }

    @DeleteMapping({"/id/{id}"})
    public ResponseEntity<String> deleteJobType(@PathVariable Integer id) {
        jobTypesService.deleteById(id);
        return ResponseEntity.ok("Job type deleted successfully!");
    }


}
