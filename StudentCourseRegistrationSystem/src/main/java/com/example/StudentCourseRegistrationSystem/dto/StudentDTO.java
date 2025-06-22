package com.example.StudentCourseRegistrationSystem.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

import java.util.UUID;

public class StudentDTO {
    @NotBlank
    private String name;

    @Email
    @NotBlank
    private String email;

    public StudentDTO() {
    }

    public StudentDTO(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
