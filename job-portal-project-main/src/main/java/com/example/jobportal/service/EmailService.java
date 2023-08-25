package com.example.jobportal.service;

import com.example.jobportal.entity.JobPost;

public interface EmailService {

    void sendExpirationEmail(JobPost jobPost, String email);

    void sendPromotionEmail(JobPost jobPost, String email);


}
