package com.example.StudentCourseRegistrationSystem.model;

import java.time.LocalDateTime;

public class Registration {
    private Integer studentID;
    private Integer courseID;
    private LocalDateTime registeredAt;

    public Registration() {
    }

    public Registration(Integer studentID, Integer courseID, LocalDateTime registeredAt) {
        this.studentID = studentID;
        this.courseID = courseID;
        this.registeredAt = registeredAt;
    }

    public Integer getStudentID() {
        return studentID;
    }

    public void setStudentID(Integer studentID) {
        this.studentID = studentID;
    }

    public Integer getCourseID() {
        return courseID;
    }

    public void setCourseID(Integer courseID) {
        this.courseID = courseID;
    }

    public LocalDateTime getRegisteredAt() {
        return registeredAt;
    }

    public void setRegisteredAt(LocalDateTime registeredAt) {
        this.registeredAt = registeredAt;
    }
}
