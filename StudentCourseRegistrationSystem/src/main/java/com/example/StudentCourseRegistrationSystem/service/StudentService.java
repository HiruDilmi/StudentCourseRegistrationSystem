package com.example.StudentCourseRegistrationSystem.service;

import com.example.StudentCourseRegistrationSystem.dto.StudentDTO;
import com.example.StudentCourseRegistrationSystem.model.Student;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class StudentService {
    private final Map<Integer, Student> studentMap = new HashMap<>();

    // Register a new student
    public Student registerStudent(StudentDTO studentDTO) {
        boolean emqailExists = studentMap.values().stream()
                .anyMatch(student -> student.getEmail().equalsIgnoreCase(studentDTO.getEmail()));
        if (emqailExists) {
            throw new IllegalArgumentException("Email already exists");
        }

        UUID uuid = UUID.randomUUID();
        int studentId = uuid.hashCode(); // Using hashCode to generate a unique ID
        Student student = new Student(studentId, studentDTO.getName(), studentDTO.getEmail());
        studentMap.put(studentId, student);
        return student;
    }

    // Get student by ID
    public Student getStudentById(UUID studentId) {
        Student student = studentMap.get(studentId);
        if (student == null) {
            throw new IllegalArgumentException("Student not found");
        }
        return student;
    }

    // Get all students
    public List<Student> getAllStudents() {
        return new ArrayList<>(studentMap.values());
    }

    public boolean existsById(Integer studentId) {
        return studentMap.containsKey(studentId);
    }
}
