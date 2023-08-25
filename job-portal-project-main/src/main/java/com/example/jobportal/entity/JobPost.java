package com.example.jobportal.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "job_post", schema = "job_portal_project")
public class JobPost {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer jobPostId;
    @Column(name = "created_date")
    @NotNull(message = "Created date cannot be null")
    private LocalDate createdDate;
    @Column(name = "job_description")
    @NotNull(message = "Job description cannot be null")
    private String jobDescription;
    @Column(name = "salary")
    @NotNull(message = "Salary cannot be null")
    private Integer salary;

    @Column(name = "priority")
    private String priority;
    @Column(name = "status")
    @NotEmpty(message = "Statis cannot be null or empty")
    private String status;
    @Column(name = "expiration_date")
    @NotNull(message = "Expiration date cannot be null")
    private LocalDate expirationDate;
    @Column(name = "major")
    @NotNull(message = "Major cannot be null")
    private String major;

    @Column(name = "promotion_end_date")
    private LocalDateTime promotionEndDate;

    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;


    @ManyToOne
    @JoinColumn(name = "job_location_id")
    private JobLocation jobLocation;

    @ManyToOne
    @JoinColumn(name = "job_type_id")
    private JobTypes jobType;

    @OneToMany(mappedBy = "jobPost",cascade = CascadeType.ALL)
    private List<JobPostActivity> jobPostActivity;


}
