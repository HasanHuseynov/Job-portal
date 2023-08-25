package com.example.jobportal.scheduler;

import com.example.jobportal.entity.Company;
import com.example.jobportal.entity.JobPost;
import com.example.jobportal.repository.JobPostRepository;
import com.example.jobportal.service.EmailService;
import com.example.jobportal.service.JobPostService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Slf4j
@Component
@RequiredArgsConstructor
public class JobPostScheduler {
    private final JobPostService jobPostService;
    private final JobPostRepository jobPostRepository;

    private final EmailService emailService;

    @Scheduled(cron = "0 17 20 * * *")
    public void deactivateExpiredJobPosts() {
        log.info("Job status deactivated!");
        jobPostService.deactivateExpiredJobPosts();
    }

    @Scheduled(cron = "0 13 14 * * *")
    public void checkExpirationAndSendEmail() {
        log.info("Email sent!");
        jobPostService.findJobPostsExpiringWithinThreeDays().forEach((jobPost) -> {
            Company company = jobPost.getCompany();
            if (company != null) {
                String companyEmail = company.getCompanyEmail();
                emailService.sendExpirationEmail(jobPost, companyEmail);
            }
        });
    }

    @Scheduled(cron = "0 32 14 * * *")
    public void checkMatchedMajorsAndSendEmail() {

        LocalDate currentDate = LocalDate.now();
        LocalDate threeDaysFromNow = currentDate.plusDays(3L);
        jobPostService.findMatchingUsers(currentDate, threeDaysFromNow);
    }


    @Scheduled(cron = "0 10 17 * * *")
    public void schedulePromoteJobPosts() {
        log.info("Job promoted");
        List<JobPost> jobPostsToPromote = jobPostRepository.findAll();
        for (JobPost jobPost : jobPostsToPromote) {
            jobPostService.promoteJobPost(jobPost.getJobPostId());
        }
    }


}
