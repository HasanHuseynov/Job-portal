package com.example.jobportal.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "user_log", schema = "job_portal_project")
public class UserLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_log_id")
    private Integer userLogId;
    @Column(name = "last_login_date")
    @NotNull(message = "date cannot be null")
    private LocalDate lastLoginDate;
    @ManyToOne
    @JoinColumn(name = "user_account_id")
    private User user;


}
