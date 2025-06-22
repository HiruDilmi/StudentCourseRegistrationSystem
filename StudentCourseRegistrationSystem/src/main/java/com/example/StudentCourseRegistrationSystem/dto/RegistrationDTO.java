package com.example.StudentCourseRegistrationSystem.dto;

import java.util.UUID;

public class RegistrationDTO {
    private UUID studentID;
    private UUID courseID;

    public RegistrationDTO() {
    }

    public RegistrationDTO(UUID studentID, UUID courseID) {
        this.studentID = studentID;
        this.courseID = courseID;
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
}
