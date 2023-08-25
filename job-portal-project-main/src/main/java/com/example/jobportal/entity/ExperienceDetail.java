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
@Table(name = "experience_detail", schema = "job_portal_project")
public class ExperienceDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "experience_id")
    private int experienceId;
    @Column(name = "is_current_job")
    private String isCurrentJob;
    @Column(name = "start_date")
    private LocalDate startDate;
    @Column(name = "end_date")
    private LocalDate endDate;
    @Column(name = "job_title")
    private String jobTitle;
    @Column(name = "company_name")
    private String companyName;
    @Column(name = "job_location_city")
    private String jobLocationCity;
    @Column(name = "job_location_state")
    private String jobLocationState;
    @Column(name = "job_location_country")
    private String jobLocationCountry;
    @Column(name = "description")
    private String description;
    @ManyToOne
    @JoinColumn(name = "seeker_id")
    private SeekerProfile seekerProfile;


}
