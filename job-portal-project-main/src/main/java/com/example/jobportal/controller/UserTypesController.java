package com.example.jobportal.controller;

import com.example.jobportal.dto.request.UserTypesRequest;
import com.example.jobportal.dto.response.UserTypesResponse;
import com.example.jobportal.service.UserTypeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping({"/user-types"})
@RequiredArgsConstructor
public class UserTypesController {
    private final UserTypeService userTypeService;

    @GetMapping
    public ResponseEntity<List<UserTypesResponse>> getAllUserTypes() {

        return ResponseEntity.ok(userTypeService.getAllUserTypes());
    }

    @PostMapping
    public ResponseEntity<UserTypesResponse> createUserType(@Valid @RequestBody UserTypesRequest userTypeRequest) {
        return ResponseEntity.ok(userTypeService.createUserType(userTypeRequest));
    }

    @PutMapping("/id/{id}")
    public ResponseEntity<String> updateUserType(@PathVariable Integer id, @Valid @RequestBody UserTypesRequest userTypeRequest) {
        userTypeService.updateUserType(id, userTypeRequest);
        return ResponseEntity.ok("User type updated successfully!");
    }

    @DeleteMapping({"id/{id}"})
    public ResponseEntity<String> deleteUserType(@PathVariable Integer id) {
        userTypeService.deleteById(id);
        return ResponseEntity.ok("User type deleted successfully!");
    }

}
