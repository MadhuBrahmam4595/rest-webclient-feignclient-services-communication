package com.user_service_provider.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRequestDTO {

    @NotNull(message = "Id is mandatory")
    @Min(value = 1, message = "Id must be greater than or equal to 1")
    private Long id;

    @NotBlank(message = "Name should not be empty")
    @Size(min = 3, max = 30, message = "Name must be between 3 to 30 characters")
    private String name;

    @NotNull(message = "Email is required")
    @Email(message = "Invalid email format")
    private String email;

    @Min(value = 18, message = "Age must be at least 18")
    @Max(value = 30, message = "age must be less than 30")
    private int age;

    @NotBlank(message = "Phone number is mandatory")
    @Pattern(regexp = "^[6-9]\\d{9}$", message = "Invalid phone number")
    private String phone;

    @Future(message = "Date of joining must be future")
    private LocalDate joinDate;

    @Past(message = "Date of birth should be in the past")
    private LocalDate dob;
}
