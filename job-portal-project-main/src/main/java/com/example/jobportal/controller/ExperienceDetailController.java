package com.example.jobportal.controller;

import com.example.jobportal.dto.request.ExperienceDetailRequest;
import com.example.jobportal.dto.response.ExperienceDetailResponse;
import com.example.jobportal.service.ExperienceDetailService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping({"/experience-detail"})
@RequiredArgsConstructor
public class ExperienceDetailController {
    private final ExperienceDetailService experienceDetailService;

    @GetMapping
    public ResponseEntity<List<ExperienceDetailResponse>> getAllExperienceDetails() {
        return ResponseEntity.ok(experienceDetailService.getAllExperienceDetails());
    }

    @PostMapping
    public ResponseEntity<ExperienceDetailResponse> createNewExperienceDetail(@RequestBody ExperienceDetailRequest experienceDetailRequest) {
        return ResponseEntity.ok(experienceDetailService.createNewExperienceDetail(experienceDetailRequest));
    }

    @DeleteMapping({"/id/{id}"})
    public ResponseEntity<String> deleteExperienceDetail(@PathVariable Integer id) {
        experienceDetailService.deleteById(id);
        return ResponseEntity.ok("Experience detail deleted successfully!");

    }

    @PutMapping("/id/{id}")
    public ResponseEntity<String> updateExperienceDetail(@PathVariable Integer id, @RequestBody ExperienceDetailRequest experienceDetailRequest) {
        experienceDetailService.updateExperienceDetail(id, experienceDetailRequest);
        return ResponseEntity.ok("Experience detail updated successfully!");
    }


}
