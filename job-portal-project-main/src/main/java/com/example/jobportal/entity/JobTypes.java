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
@Table(
        name = "job_type",
        schema = "job_portal_project"
)
public class JobTypes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "job_type_id")
    private Integer jobTypeId;
    @Column(name = "job_type")
    @NotEmpty(message = "Job type cannot be empty or null!")
    private String jobType;

    @OneToMany(mappedBy = "jobType",cascade = CascadeType.ALL)
    private List<JobPost> jobPost;

}
