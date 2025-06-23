package com.example.StudentCourseRegistrationSystem.service;

import com.example.StudentCourseRegistrationSystem.dto.CourseDTO;
import com.example.StudentCourseRegistrationSystem.model.Course;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CourseService {
    private final Map<Integer, Course> courseMap = new HashMap<>();
    private int nextId = 1; // To make auto incrementing IDs easier

    // Create a new course
    public Course createCourse(CourseDTO courseDTO) {
        boolean courseExists = courseMap.values().stream()
                .anyMatch(course -> course.getCode().equalsIgnoreCase(courseDTO.getCourseCode()));
        if (courseExists) {
            throw new IllegalArgumentException("Course already exists");
        }

        int courseId = nextId++;
        Course course = new Course(courseId, courseDTO.getCourseCode(), courseDTO.getTitle(), courseDTO.getInstructorName());
        courseMap.put(courseId, course);
        return course;
    }

    // Get all courses
    public List<Course> getAllCourses() {
        return new ArrayList<>(courseMap.values());
    }

    public boolean existsById(Integer courseId) {
        return courseMap.containsKey(courseId);
    }

    public Course getCourseById(Integer courseID) {
        Course course = courseMap.get(courseID);
        if (course == null) {
            throw new NoSuchElementException("Course with ID " + courseID + " not found.");
        }
        return course;
    }
}
