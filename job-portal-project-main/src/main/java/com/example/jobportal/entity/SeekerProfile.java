package com.example.jobportal.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "seeker_profile", schema = "job_portal_project")
public class SeekerProfile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "seeker_id")
    private Integer seekerId;
    @Column(name = "first_name")
    @NotEmpty(message = "Name cannot be null or empty")
    private String firstName;
    @Column(name = "last_name")
    @NotEmpty(message = "last name cannot be null or empty")
    private String lastName;
    @Column(name = "major")
    @NotEmpty(message = "Major cannot be null or empty")
    private String major;
    @Column(name = "cv")
    private byte[] cv;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;
    @OneToMany(mappedBy = "seekerProfile",cascade = CascadeType.ALL)
    private List<EducationDetail> educationDetails;
    @OneToMany(mappedBy = "seekerProfile",cascade = CascadeType.ALL)
    private List<ExperienceDetail> experienceDetails;


}
