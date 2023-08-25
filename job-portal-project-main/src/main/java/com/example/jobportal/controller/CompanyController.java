package com.example.jobportal.controller;

import com.example.jobportal.dto.request.CompanyRequest;
import com.example.jobportal.dto.response.CompanyResponse;
import com.example.jobportal.service.CompanyService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping({"/company"})
@RequiredArgsConstructor
public class CompanyController {
    private final CompanyService companyService;

    //testing
    @GetMapping
    public ResponseEntity<List<CompanyResponse>> getALlCompanies() {

        return ResponseEntity.ok(companyService.getALlCompanies());
    }
    @PostMapping
    public ResponseEntity<CompanyResponse> createNewCompany(@Valid @RequestBody CompanyRequest companyRequest) {
        return ResponseEntity.ok(companyService.createNewCompany(companyRequest));
    }

    @DeleteMapping({"/id/{id}"})
    public ResponseEntity<String> deleteCompany(@Valid @PathVariable Integer id) {
        companyService.deleteById(id);
        return ResponseEntity.ok("Company deleted successfully");
    }

    @PutMapping("/id/{id}")
    public ResponseEntity<String> updateCompany(@Valid @PathVariable Integer id, @Valid @RequestBody CompanyRequest companyRequest) {
        companyService.updateCompany(id, companyRequest);
        return ResponseEntity.ok("Company updated successfully!");
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<List<CompanyResponse>> getCompanyByEmail(@Valid @PathVariable String email) {
        return ResponseEntity.ok(companyService.getCompanyByEmail(email));
    }
}
