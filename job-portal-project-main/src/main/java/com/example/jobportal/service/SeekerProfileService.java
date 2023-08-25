package com.example.jobportal.service;

import com.example.jobportal.dto.request.SeekerProfileRequest;
import com.example.jobportal.dto.response.SeekerProfileResponse;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface SeekerProfileService {
    List<SeekerProfileResponse> getAllSeekerProfiles();

    SeekerProfileResponse createNewSeekerProfile(SeekerProfileRequest seekerProfileRequest);

    void updateSeekerProfile(Integer id, SeekerProfileRequest seekerProfileRequest);

    void deleteById(Integer id);

    void uploadCV(Integer id, MultipartFile cvFile) throws IOException;


}
