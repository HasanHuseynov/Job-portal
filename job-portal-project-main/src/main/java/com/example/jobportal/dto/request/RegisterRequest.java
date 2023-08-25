package com.example.jobportal.dto.request;

import com.example.jobportal.enums.Role;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDate;

@Slf4j
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {
    @NotBlank(message = "Name cannot be empty!")
    private String firstName;
    @NotBlank(message = "Surname cannot be empty")
    private String lastName;

    private LocalDate dateOfBirth;

    private String gender;

    private String status;

    private Long contactNumber;
    @NotBlank(message = "Email cannot be empty")
    @Email
    private String email;
    private Role role;

    @NotBlank
    @Size(min = 8)
    private String password;
}
