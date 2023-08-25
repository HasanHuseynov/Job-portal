package com.example.jobportal.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDate;
import java.util.List;

@Slf4j
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "company", schema = "job_portal_project")
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Email
    @NotNull(message = "Email cannot be empty or null")
    @Column(name = "company_email")
    private String companyEmail;
    @Column(name = "company_name")
    @NotNull(message = "Company name cannot be empty or null")
    private String companyName;

    @Column(name = "profile_description")
    private String profileDescription;

    @Column(name = "establishment_date")
    private LocalDate establishmentDate;
    @NotNull(message = "Balance cannot be empty or null")
    @Column(name = "balance")
    private Integer balance;

    @OneToMany(mappedBy = "company",cascade = CascadeType.ALL)
    private List<JobPost> jobPosts;


}
