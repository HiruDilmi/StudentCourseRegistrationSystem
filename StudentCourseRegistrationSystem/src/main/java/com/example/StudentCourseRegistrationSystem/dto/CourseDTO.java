package com.example.StudentCourseRegistrationSystem.dto;

import jakarta.validation.constraints.NotBlank;

public class CourseDTO {
    @NotBlank(message = "Course code cannot be blank")
    private String courseCode;

    @NotBlank(message = "Course name cannot be blank")
    private String title;

    @NotBlank(message = "Instructor name cannot be blank")
    private String instructorName;

    public CourseDTO() {
    }

    public CourseDTO(String courseCode, String title, String instructorName) {
        this.courseCode = courseCode;
        this.title = title;
        this.instructorName = instructorName;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getInstructorName() {
        return instructorName;
    }

    public void setInstructorName(String instructorName) {
        this.instructorName = instructorName;
    }
}
