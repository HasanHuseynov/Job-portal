package com.example.jobportal.service;

import com.example.jobportal.dto.request.CompanyRequest;
import com.example.jobportal.dto.response.CompanyResponse;

import java.util.List;

public interface CompanyService {
    List<CompanyResponse> getALlCompanies();

    CompanyResponse createNewCompany(CompanyRequest CompanyRequest);

    void deleteById(Integer id);

    void updateCompany(Integer id, CompanyRequest companyRequest);

    List<CompanyResponse> getCompanyByEmail(String email);
}
