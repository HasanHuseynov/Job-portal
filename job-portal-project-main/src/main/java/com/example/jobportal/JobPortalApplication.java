package com.example.jobportal;

import com.example.jobportal.config.MailProperties;
import net.javacrumbs.shedlock.spring.annotation.EnableSchedulerLock;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.time.LocalDate;

@SpringBootApplication
@EnableScheduling
@EnableSchedulerLock(defaultLockAtMostFor = "PT30S")
@EnableConfigurationProperties({MailProperties.class})
@EnableAspectJAutoProxy
public class JobPortalApplication {


    public static void main(String[] args) {
        LocalDate currentDate = LocalDate.now();
        System.out.println("Current local date: " + currentDate);
        SpringApplication.run(JobPortalApplication.class, args);
    }
}
