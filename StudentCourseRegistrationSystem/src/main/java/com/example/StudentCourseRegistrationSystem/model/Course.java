package com.example.StudentCourseRegistrationSystem.model;

import jakarta.validation.constraints.NotBlank;

public class Course {
    private Integer id;

    @NotBlank
    private String code;

    @NotBlank
    private String title;

    @NotBlank
    private String instructor;

    public Course(Integer courseID, String courseTitle, String instructorName) {
    }

    public Course(Integer id, String code, String title, String instructor) {
        this.id = id;
        this.code = code;
        this.title = title;
        this.instructor = instructor;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getInstructor() {
        return instructor;
    }

    public void setInstructor(String instructor) {
        this.instructor = instructor;
    }
}
