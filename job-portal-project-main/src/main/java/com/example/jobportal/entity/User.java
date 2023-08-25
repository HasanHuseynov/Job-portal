package com.example.jobportal.entity;

import com.example.jobportal.enums.Role;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

@Slf4j
@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "user_account", schema = "job_portal_project")
public class User implements UserDetails {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "email")
    @Email
    @NotEmpty(message = "Email cannot be null or empty")
    private String email;
    @Column(name = "password")
    @Size(min = 8)
    @NotEmpty(message = "Name cannot be null or empty")
    private String password;
    @Column(name = "date_of_birth")
    @NotNull(message = "Date of birth cannot be null")
    private LocalDate dateOfBirth;
    @Column(name = "gender")
    @NotBlank(message = "Gender cannot be null!")
    private String gender;
    @Column(name = "status")
    @NotBlank(message = "status cannot be null")
    private String status;
    @Column(name = "contact_number")
    private Long contactNumber;
    @Column(name = "registration_date")
    @CreationTimestamp
    @NotNull(message = "Date cannot be null!")
    private LocalDate registrationDate;
    @ManyToOne
    @JoinColumn(name = "user_type_id")
    private UserTypes userTypes;
    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    private List<UserLog> userLogs;
    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    private List<JobPostActivity> jobPostActivities;
    @OneToOne(mappedBy = "user")
    private SeekerProfile seekerProfile;
    @Enumerated(EnumType.STRING)
    private Role role;
    @OneToMany(mappedBy = "user")
    private List<Token> tokens;
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role.name()));
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
