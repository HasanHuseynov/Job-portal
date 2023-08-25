package com.example.jobportal.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
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
@Table(name = "education_detail", schema = "job_portal_project")
public class EducationDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "education_detail_id")
    private Integer educationDetailId;
    @NotEmpty(message = "Major cannot be null or empty")
    @Column(name = "major")
    private String major;
    @Column(name = "certificate_degree_name")
    @NotNull(message = "Certificate name cannot be null")
    private String certificateDegreeName;
    @NotNull(message = "University name cannot be null")
    @Column(name = "university_name")
    private String universityName;
    @Column(name = "starting_date")
    @NotNull(message = "Staring date name cannot be null")
    private LocalDate startingDate;
    @Column(name = "completion_date")
    @NotNull(message = "Completion date name cannot be null")
    private LocalDate completionDate;
    @Column(name = "degree")
    @NotEmpty(message = "Degree name name cannot be null or empty")
    private String degree;
    @Size(max = 3, min = 1)
    @Column(name = "gpa")
    private Integer gpa;
    @ManyToOne
    @JoinColumn(name = "seeker_id")
    private SeekerProfile seekerProfile;


}
