package com.example.StudentCourseRegistrationSystem.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class Student {
    private Integer id;

    @NotBlank
    private String name;

    @Email
    @NotBlank
    private String email;

    public Student() {
    }

    public Student(Integer id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public void setId(int id) {
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
