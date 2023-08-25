package com.example.jobportal.service;

import com.example.jobportal.dto.request.ExperienceDetailRequest;
import com.example.jobportal.dto.response.ExperienceDetailResponse;

import java.util.List;

public interface ExperienceDetailService {
    List<ExperienceDetailResponse> getAllExperienceDetails();

    ExperienceDetailResponse createNewExperienceDetail(ExperienceDetailRequest experienceDetailRequest);

    void updateExperienceDetail(Integer id, ExperienceDetailRequest experienceRequest);

    void deleteById(Integer id);
}
