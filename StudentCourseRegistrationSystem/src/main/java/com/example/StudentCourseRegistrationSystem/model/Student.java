package com.example.StudentCourseRegistrationSystem.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

import java.util.UUID;

public class Student {
    private UUID id;

    @NotBlank
    private String name;

    @Email
    @NotBlank
    private String email;

}
