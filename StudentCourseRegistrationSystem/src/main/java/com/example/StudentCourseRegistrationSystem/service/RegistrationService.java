package com.example.StudentCourseRegistrationSystem.service;

import com.example.StudentCourseRegistrationSystem.model.Registration;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;
@Service
public class RegistrationService {
    private final List<Registration> registrations = new ArrayList<>();

    // Register a student for a course
    public Registration register(UUID studentId, UUID courseId) {
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
    public void unregister(UUID studentId, UUID courseId) {
        registrations.removeIf(registration -> registration.getStudentID().equals(studentId) && registration.getCourseID().equals(courseId));
    }


}
