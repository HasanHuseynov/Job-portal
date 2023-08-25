package com.example.jobportal.controller;

import com.example.jobportal.dto.request.EducationDetailRequest;
import com.example.jobportal.dto.response.EducationDetailResponse;
import com.example.jobportal.service.EducationDetailService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping({"/education-detail"})
@RequiredArgsConstructor
public class EducationDetailController {
    private final EducationDetailService educationDetailService;

    @GetMapping
    public ResponseEntity<List<EducationDetailResponse>> getAllEducationDetails() {
        return ResponseEntity.ok(educationDetailService.getAllEducationDetails());
    }

    @PostMapping
    public ResponseEntity<EducationDetailResponse> createNewEducationDetail(@Valid @RequestBody EducationDetailRequest educationDetailRequest) {
        return ResponseEntity.ok(educationDetailService.createNewEducationDetail(educationDetailRequest));
    }

    @PutMapping("/id/{id}")
    public ResponseEntity<String> updateEducationDetail(@PathVariable Integer id, @RequestBody EducationDetailRequest educationDetailRequest) {
        educationDetailService.updateEducationDetail(id, educationDetailRequest);
        return ResponseEntity.ok("Education detail updated successfully!");
    }

    @DeleteMapping({"/id/{id}"})
    public ResponseEntity<String> deleteEducationDetail(@PathVariable Integer id) {
        educationDetailService.deleteById(id);
        return ResponseEntity.ok("Education detail deleted successfully!");
    }


}
