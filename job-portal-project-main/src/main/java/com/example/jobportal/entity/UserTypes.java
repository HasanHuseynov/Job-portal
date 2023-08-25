package com.example.jobportal.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
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
@Table(name = "user_type", schema = "job_portal_project")

public class UserTypes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "user_type_name")
    @NotBlank(message = "User type cannot be empty or null")
    private String userTypeName;
    @OneToMany(mappedBy = "userTypes",cascade = CascadeType.ALL)
    private List<User> user;

}
