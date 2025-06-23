package com.example.StudentCourseRegistrationSystem.service;

import com.example.StudentCourseRegistrationSystem.model.Course;
import com.example.StudentCourseRegistrationSystem.model.Registration;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;
@Service
public class RegistrationService {
    private final List<Registration> registrations = new ArrayList<>();
    private final CourseService courseService;

    public RegistrationService(CourseService courseService) {
        this.courseService = courseService;
    }

    // Register a student for a course
    public Registration register(Integer studentId, Integer courseId) {
        boolean alreadyRegistered = registrations.stream()
                .anyMatch(registration -> registration.getStudentID().equals(studentId) && registration.getCourseID().equals(courseId));
        if (alreadyRegistered) {
            throw new IllegalArgumentException("Student is already registered for this course.");
        }

        Registration registration = new Registration(studentId, courseId, LocalDateTime.now());
        registrations.add(registration);
        return registration;
    }

    // Remove a registration
    public void unregister(Integer studentId, Integer courseId) {
        registrations.removeIf(registration -> registration.getStudentID().equals(studentId) && registration.getCourseID().equals(courseId));
    }

    // Get all registrations for a student
    public List<Course> getRegisteredCourses(Integer studentId) {
        List<Course> registeredCourses = new ArrayList<>();

        for (Registration registration : registrations) {
            if (registration.getStudentID().equals(studentId)) {
                Course course = courseService.getCourseById(registration.getCourseID());
                if (course != null) {
                    registeredCourses.add(course);
                } else {
                    throw new NoSuchElementException("Course with ID " + registration.getCourseID() + " not found.");
                }
            }
        }
        return registeredCourses;
    }
}
