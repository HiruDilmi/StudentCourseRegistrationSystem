package com.example.StudentCourseRegistrationSystem.controller;

import com.example.StudentCourseRegistrationSystem.dto.StudentDTO;
import com.example.StudentCourseRegistrationSystem.model.Course;
import com.example.StudentCourseRegistrationSystem.model.Student;
import com.example.StudentCourseRegistrationSystem.service.CourseService;
import com.example.StudentCourseRegistrationSystem.service.RegistrationService;
import com.example.StudentCourseRegistrationSystem.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/students")
public class StudentController {
    private final StudentService studentService;
    private final CourseService courseService;
    private final RegistrationService registrationService;

    public StudentController(StudentService studentService, CourseService courseService, RegistrationService registrationService) {
        this.studentService = studentService;
        this.courseService = courseService;
        this.registrationService = registrationService;
    }

    // register student
    @PostMapping("/register")
    public ResponseEntity<?> registerStudent(@Valid @RequestBody StudentDTO studentDTO) {
        try {
            Student student = studentService.registerStudent(studentDTO);
            return new ResponseEntity<>(student, HttpStatus.CREATED);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>("An error occurred while registering the student.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Get all students
    @GetMapping("/allStudents")
    public ResponseEntity<?> getAllStudents() {
        List<Student> students = studentService.getAllStudents();

        if (students.isEmpty()) {
            return ResponseEntity.ok("No students to show");
        }
        return ResponseEntity.ok(students);
    }

    // Register a student for a course
    @PostMapping("/{studentId}/register/{courseId}")
    public ResponseEntity<?> registerToCourse(@PathVariable Integer studentId, @PathVariable Integer courseId) {
        if(!studentService.existsById(studentId)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Student not found");
        }
        if(!courseService.existsById(courseId)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Course not found");
        }

        try {
            return new ResponseEntity<>(registrationService.register(studentId, courseId), HttpStatus.CREATED);
        } catch (IllegalStateException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    // Drop a course for a student
    @DeleteMapping("/{studentId}/drop/{courseId}")
    public ResponseEntity<?> dropCourse(@PathVariable Integer studentId, @PathVariable Integer courseId) {
        if(!studentService.existsById(studentId)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Student not found");
        }
        if(!courseService.existsById(courseId)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Course not found");
        }

        try {
            registrationService.unregister(studentId, courseId);
            return ResponseEntity.ok("Course dropped successfully");
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }


    //List registered courses for a student
    @GetMapping("/{studentId}/courses")
    public ResponseEntity<?> getRegisteredCourses(@PathVariable Integer studentId) {
        if(!studentService.existsById(studentId)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Student not found");
        }

        try {
            List<Course> registeredCourses = registrationService.getRegisteredCourses(studentId);
            if (registeredCourses.isEmpty()) {
                return ResponseEntity.ok("No courses registered for this student.");
            }
            return ResponseEntity.ok(registeredCourses);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>("An error occurred while retrieving registered courses.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
