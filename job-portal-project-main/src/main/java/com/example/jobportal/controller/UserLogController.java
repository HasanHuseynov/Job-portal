package com.example.jobportal.controller;

import com.example.jobportal.dto.request.UserLogRequest;
import com.example.jobportal.dto.response.UserLogResponse;
import com.example.jobportal.service.UserLogService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping({"/user-log"})
@RequiredArgsConstructor
public class UserLogController {
    private final UserLogService userLogService;

    @GetMapping
    public ResponseEntity<List<UserLogResponse>> getAllUserLogs() {
        return ResponseEntity.ok(userLogService.getAllUserLogs());
    }

    @PostMapping
    public ResponseEntity<UserLogResponse> createUserLog(@Valid @RequestBody UserLogRequest userLogRequest) {
        return ResponseEntity.ok(userLogService.createNewUserLog(userLogRequest));
    }

    @PutMapping("/id/{id}")
    public ResponseEntity<String> updateUserLog(@PathVariable Integer id, @Valid @RequestBody UserLogRequest userLogRequest) {
        userLogService.updateUserLog(id, userLogRequest);
        return ResponseEntity.ok("User log updated successfully!");
    }

    @DeleteMapping({"/id/{id}"})
    public ResponseEntity<String> deleteUserLog(@PathVariable Integer id) {
        userLogService.deleteById(id);
        return ResponseEntity.ok("User log deleted successfully!");
    }

}
