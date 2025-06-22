package com.example.StudentCourseRegistrationSystem.controller;

import com.example.StudentCourseRegistrationSystem.dto.CourseDTO;
import com.example.StudentCourseRegistrationSystem.model.Course;
import com.example.StudentCourseRegistrationSystem.service.CourseService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/courses")
public class CourseController {
    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    // add a course
    @PostMapping("/addCourse")
    public ResponseEntity<?> addCourse(@Valid @RequestBody CourseDTO coureDTO) {
        try {
            Course course = courseService.createCourse(coureDTO);
            return new ResponseEntity<>(course, HttpStatus.CREATED);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(500).body("Error adding course: " + e.getMessage());
        }
    }

    // get all courses
    @GetMapping("/all")
    public ResponseEntity<?> getAllCourses() {
        try {
            return new ResponseEntity<>(courseService.getAllCourses(), HttpStatus.OK);
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error retrieving courses: " + e.getMessage());
        }
    }

}
