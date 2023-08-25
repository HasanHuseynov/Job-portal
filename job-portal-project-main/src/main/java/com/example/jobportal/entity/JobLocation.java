package com.example.jobportal.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
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
@Table(name = "job_location", schema = "job_portal_project")
public class JobLocation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "job_location_id")
    private int jobLocationId;
    @Column(name = "street_address")
    @NotNull(message = "street address cannot be null")
    private String streetAddress;
    @Column(name = "city")
    @NotNull(message = "City name cannot be null")
    private String city;
    @Column(name = "state")
    @NotNull(message = "State name  cannot be null")
    private String state;
    @Column(name = "country")
    @NotNull(message = "Country name cannot be null")
    private String country;
    @Column(name = "zip")
    @NotNull(message = "Zip name cannot be null")
    private String zip;

    @OneToMany(mappedBy = "jobLocation",cascade = CascadeType.ALL)
    private List<JobPost> jobPost;
}
