package com.example.StudentCourseRegistrationSystem.service;

import com.example.StudentCourseRegistrationSystem.dto.CourseDTO;
import com.example.StudentCourseRegistrationSystem.dto.StudentDTO;

import java.util.List;
import java.util.UUID;

public interface StudentService {
    StudentDTO createStudent(StudentDTO studentDTO);
    void registerForCourse(UUID studentId, UUID courseId);
    void dropCourse(UUID studentId, UUID courseId);
    List<CourseDTO> getRegisteredCourses(UUID studentId);
}
