package com.example.StudentCourseRegistrationSystem.model;

import jakarta.validation.constraints.NotBlank;

import java.util.UUID;

public class Course {
    private UUID id;

    @NotBlank
    private String code;

    @NotBlank
    private String title;

    @NotBlank
    private String instructure;

}
