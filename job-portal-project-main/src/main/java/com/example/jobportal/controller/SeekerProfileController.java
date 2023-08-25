package com.example.jobportal.controller;

import com.example.jobportal.dto.request.SeekerProfileRequest;
import com.example.jobportal.dto.response.SeekerProfileResponse;
import com.example.jobportal.entity.SeekerProfile;
import com.example.jobportal.exception.NotDataFound;
import com.example.jobportal.service.SeekerProfileService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Tag(name = "Seeker Profile", description = "Seeker Profile APIs")
@Slf4j
@RestController
@RequestMapping({"/seeker-profiles"})
@RequiredArgsConstructor
@SecurityRequirement(name = "bearerAuth")
public class SeekerProfileController {
    private final SeekerProfileService seekerProfileService;

    @Operation(
            summary = "Retrieve all seeker profiles",
            description = "Get a Tutorial object by specifying its id. The response is Tutorial object with id, title, description and published status.",
            tags = {"tutorials", "get"})
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = {@Content(schema = @Schema(implementation = SeekerProfile.class), mediaType = "application/json")}),
            @ApiResponse(responseCode = "404", content = {@Content(schema = @Schema())}),
            @ApiResponse(responseCode = "500", content = {@Content(schema = @Schema())})})
    @GetMapping
    public ResponseEntity<List<SeekerProfileResponse>> getAllSeekerProfiles() {
        return ResponseEntity.ok(seekerProfileService.getAllSeekerProfiles());
    }

    @Operation(
            summary = "Create a new seeker profile",
            description = "Create a new seeker profile with the provided details.",
            tags = {"Seeker Profile", "Create"})
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = {@Content(schema = @Schema(implementation = SeekerProfile.class), mediaType = "application/json")}),
            @ApiResponse(responseCode = "404", content = {@Content(schema = @Schema())}),
            @ApiResponse(responseCode = "500", content = {@Content(schema = @Schema())})})
    @PostMapping
    public ResponseEntity<SeekerProfileResponse> createNewSeekerProfile(@Valid @RequestBody SeekerProfileRequest seekerProfileRequest) {
        return ResponseEntity.ok(seekerProfileService.createNewSeekerProfile(seekerProfileRequest));
    }

    @Operation(
            summary = "Update seeker profile",
            description = "Update the details of an existing seeker profile identified by its ID.",
            tags = {"Seeker Profile", "Update"})
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = {@Content(schema = @Schema(implementation = SeekerProfile.class), mediaType = "application/json")}),
            @ApiResponse(responseCode = "404", content = {@Content(schema = @Schema())}),
            @ApiResponse(responseCode = "500", content = {@Content(schema = @Schema())})})
    @PutMapping("/id/{id}")
    public ResponseEntity<String> updateSeekerProfile(@PathVariable Integer id, @Valid @RequestBody SeekerProfileRequest seekerProfileRequest) {
        seekerProfileService.updateSeekerProfile(id, seekerProfileRequest);
        return ResponseEntity.ok("Seeker profile updated successfully!");
    }

    @Operation(
            summary = "Upload CV",
            description = "Upload a CV file for the specified seeker profile.",
            tags = {"Seeker Profile", "Upload"})
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = {@Content(schema = @Schema(implementation = SeekerProfile.class), mediaType = "application/json")}),
            @ApiResponse(responseCode = "404", content = {@Content(schema = @Schema())}),
            @ApiResponse(responseCode = "500", content = {@Content(schema = @Schema())})})
    @PostMapping("/{id}/uploadCV")
    public ResponseEntity<String> uploadCV(@PathVariable Integer id, @RequestParam("cvFile") MultipartFile cvFile) {
        try {
            seekerProfileService.uploadCV(id, cvFile);
            return ResponseEntity.ok("CV uploaded successfully!");
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("CV upload failed: " + e.getMessage());
        } catch (NotDataFound e) {
            return ResponseEntity.notFound().build();
        }
    }

    @Operation(
            summary = "Delete seeker profile",
            description = "Delete the seeker profile with the specified ID.",
            tags = {"Seeker Profile", "Delete"})

    @ApiResponses({
            @ApiResponse(responseCode = "200", content = {@Content(schema = @Schema(implementation = SeekerProfile.class), mediaType = "application/json")}),
            @ApiResponse(responseCode = "404", content = {@Content(schema = @Schema())}),
            @ApiResponse(responseCode = "500", content = {@Content(schema = @Schema())})})
    @DeleteMapping({"/id/{id}"})
    public ResponseEntity<String> deleteSeekerProfile(@PathVariable Integer id) {
        seekerProfileService.deleteById(id);
        return ResponseEntity.ok("Seeker profile deleted successfully!");
    }


}
