package com.example.jobportal.repository;

import com.example.jobportal.entity.JobTypes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobTypesRepository extends JpaRepository<JobTypes, Integer> {
}
