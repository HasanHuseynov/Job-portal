package com.example.jobportal.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDate;

@Slf4j
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "job_post_activity", schema = "job_portal_project")
public class JobPostActivity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_activity_id")
    private Integer jobPostActivityId;
    @Column(name = "apply_date")
    private LocalDate applyDate;
    @ManyToOne
    @JoinColumn(name = "job_post_id")
    private JobPost jobPost;
    @ManyToOne
    @JoinColumn(name = "user_account_id")
    private User user;

}
