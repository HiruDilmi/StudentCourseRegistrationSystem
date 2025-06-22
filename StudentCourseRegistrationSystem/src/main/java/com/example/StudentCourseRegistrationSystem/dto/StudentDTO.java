package com.example.StudentCourseRegistrationSystem.dto;

import jakarta.validation.constraints.NotBlank;

import java.util.UUID;

public class StudentDTO {
    private UUID id;

    @NotBlank(message = "Name cannot be blank")
    private String name;

    @NotBlank(message = "Email cannot be blank")
    @NotBlank(message = "Email must be a valid email address")
    private String email;

    public StudentDTO() {
    }

    public StudentDTO(UUID id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
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
