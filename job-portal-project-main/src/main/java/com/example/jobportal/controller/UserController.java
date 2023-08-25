package com.example.jobportal.controller;

import com.example.jobportal.dto.request.UserRequest;
import com.example.jobportal.dto.response.UserResponse;
import com.example.jobportal.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping({"/users"})
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping
    public ResponseEntity<List<UserResponse>> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUser());
    }

    @PostMapping
    public ResponseEntity<UserResponse> createUser(@RequestBody UserRequest userRequest) {
        return ResponseEntity.ok(userService.createNewUser(userRequest));
    }

    @PutMapping("/id/{id}")
    public ResponseEntity<String> updateUser(@PathVariable Integer id, @RequestBody UserRequest userRequest) {
        userService.updateUser(id, userRequest);
        return ResponseEntity.ok("User updated successfully!");
    }

    @DeleteMapping({"/id/{id}"})
    public ResponseEntity<String> deleteUser(@PathVariable Integer id) {
        userService.deleteById(id);
        return ResponseEntity.ok("User deleted successfully!");
    }

}
