package com.example.StudentCourseRegistrationSystem.model;

import java.time.LocalDateTime;
import java.util.UUID;

public class Registration {
    private UUID studentID;
    private UUID courseID;
    private LocalDateTime registeredAt;

    public Registration() {
    }

    public Registration(UUID studentID, UUID courseID, LocalDateTime registeredAt) {
        this.studentID = studentID;
        this.courseID = courseID;
        this.registeredAt = registeredAt;
    }

    public UUID getStudentID() {
        return studentID;
    }

    public void setStudentID(UUID studentID) {
        this.studentID = studentID;
    }

    public UUID getCourseID() {
        return courseID;
    }

    public void setCourseID(UUID courseID) {
        this.courseID = courseID;
    }

    public LocalDateTime getRegisteredAt() {
        return registeredAt;
    }

    public void setRegisteredAt(LocalDateTime registeredAt) {
        this.registeredAt = registeredAt;
    }
}
