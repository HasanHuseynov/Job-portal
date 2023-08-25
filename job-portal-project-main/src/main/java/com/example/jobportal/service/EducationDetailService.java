package com.example.jobportal.service;

import com.example.jobportal.dto.request.EducationDetailRequest;
import com.example.jobportal.dto.response.EducationDetailResponse;

import java.util.List;

public interface EducationDetailService {
    List<EducationDetailResponse> getAllEducationDetails();

    EducationDetailResponse createNewEducationDetail(EducationDetailRequest educationDetailRequest);

    void deleteById(Integer id);

    void updateEducationDetail(Integer id, EducationDetailRequest educationDetailRequest);
}
