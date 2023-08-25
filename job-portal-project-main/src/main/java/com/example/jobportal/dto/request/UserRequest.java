package com.example.jobportal.dto.request;



import jakarta.validation.constraints.*;
import lombok.*;
import lombok.extern.slf4j.Slf4j;


import java.time.LocalDate;

@Slf4j
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserRequest {
    private Integer id;
    @Email
    @NotEmpty(message = "Email cannot be null or empty")
    private String email;
    @Size(min = 8)
    @NotEmpty(message = "Name cannot be null or empty")
    private String password;
    @NotNull(message = "Date of birth cannot be null")
    private LocalDate dateOfBirth;
    @NotBlank(message = "Gender cannot be null!")
    private String gender;
    @NotBlank(message = "status cannot be null")
    private String status;
    private Long contactNumber;
    @NotNull(message = "Date cannot be null!")
    private LocalDate registrationDate;

}
