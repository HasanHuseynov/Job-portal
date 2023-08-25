package com.example.jobportal.repository;

import com.example.jobportal.entity.UserLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserLogRepository extends JpaRepository<UserLog, Integer> {
}
