package com.example.jobportal.repository;

import com.example.jobportal.entity.JobLocation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobLocationRepository extends JpaRepository<JobLocation, Integer> {
}
