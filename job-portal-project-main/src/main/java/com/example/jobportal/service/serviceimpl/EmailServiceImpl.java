package com.example.jobportal.service.serviceimpl;

import com.example.jobportal.entity.JobPost;
import com.example.jobportal.service.EmailService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class EmailServiceImpl implements EmailService {
    private final JavaMailSender mailSender;

    @Override
    public void sendExpirationEmail(JobPost jobPost, String email) {
        String subject = "Job Post Expiration Reminder";
        String message = "Your job post with ID " + jobPost.getJobPostId() + " is expiring in 3 days";
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(email);
        mailMessage.setSubject(subject);
        mailMessage.setText(message);
        mailSender.send(mailMessage);
    }

    @Override
    public void sendPromotionEmail(JobPost jobPost, String email) {

        String subject = "Jon Promotion";
        String message = "You can apply for the following job:\n"
                + "Job Title: " + jobPost.getMajor() + "\n"
                + "Posted Date: " + jobPost.getCreatedDate() + "\n"
                + "Salary: " + jobPost.getSalary() + "\n"
                + "To apply or learn more, please visit our job portal.";
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(email);
        mailMessage.setSubject(subject);
        mailMessage.setText(message);
        mailSender.send(mailMessage);
    }

}
