package com.example.jobportal.Aspect;

import com.example.jobportal.dto.request.AuthenticationRequest;
import com.example.jobportal.entity.User;
import com.example.jobportal.entity.UserLog;
import com.example.jobportal.repository.UserLogRepository;
import com.example.jobportal.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Optional;

@Slf4j
@Aspect
@Component
@RequiredArgsConstructor
public class UserLoggingAspect {
    private final UserLogRepository userLogRepository;

    private final UserRepository userRepository;

    @AfterReturning("execution(* com.example.jobportal.service.serviceimpl.AuthenticationService.authenticate(..))")
    public void logSignIn(JoinPoint joinPoint) {
        UserLog log = new UserLog();
        AuthenticationRequest authenticationRequest = (AuthenticationRequest) joinPoint.getArgs()[0];
        String username = authenticationRequest.getEmail();

        // Fetch user information based on the email (username)
        Optional<User> userOptional = userRepository.findByEmail(username);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            log.setUser(user); // Assuming you have a setUser method in UserLog
            log.setLastLoginDate(LocalDate.now());
            userLogRepository.save(log);
        }
    }
}
