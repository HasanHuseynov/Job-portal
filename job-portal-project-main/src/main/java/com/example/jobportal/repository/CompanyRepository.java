package com.example.jobportal.repository;

import com.example.jobportal.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CompanyRepository extends JpaRepository<Company, Integer> {
    @Query("SELECT c FROM Company c WHERE c.companyEmail = :email")
    List<Company> findByCompanyEmail(String email);
}
