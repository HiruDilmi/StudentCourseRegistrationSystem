package com.example.StudentCourseRegistrationSystem.service;

import com.example.StudentCourseRegistrationSystem.dto.CourseDTO;
import com.example.StudentCourseRegistrationSystem.model.Course;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CourseService {
    private final Map<UUID, Course> courseMap = new HashMap<>();

    // Create a new course
    public Course createCourse(CourseDTO courseDTO) {
        boolean courseExists = courseMap.values().stream()
                .anyMatch(course -> course.getCode().equalsIgnoreCase(courseDTO.getCourseCode()));
        if (courseExists) {
            throw new IllegalArgumentException("Course already exists");
        }

        UUID courseId = UUID.randomUUID();
        Course course = new Course(courseId, courseDTO.getCourseCode(), courseDTO.getTitle(), courseDTO.getInstructorName());
        courseMap.put(courseId, course);
        return course;
    }

    // Get all courses
    public List<Course> getAllCourses() {
        return new ArrayList<>(courseMap.values());
    }

}
