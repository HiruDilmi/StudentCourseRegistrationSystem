package com.example.StudentCourseRegistrationSystem.dto;

public class RegistrationDTO {
    private Integer studentID;
    private Integer courseID;

    public RegistrationDTO() {
    }

    public RegistrationDTO(Integer studentID, Integer courseID) {
        this.studentID = studentID;
        this.courseID = courseID;
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
}
