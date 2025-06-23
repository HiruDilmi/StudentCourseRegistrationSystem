package com.example.StudentCourseRegistrationSystem.test;

import com.example.StudentCourseRegistrationSystem.dto.CourseDTO;
import com.example.StudentCourseRegistrationSystem.model.Course;
import com.example.StudentCourseRegistrationSystem.service.CourseService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CourseServiceTest {
    private CourseService courseService;

    @BeforeEach
    void setup() {
        courseService = new CourseService();
    }

    @Test
    void createCourse_shouldSucceed() {
        CourseDTO dto = new CourseDTO("CS101", "Intro", "Lecturer");
        Course course = courseService.createCourse(dto);

        assertNotNull(course);
        assertEquals("CS101", course.getCode());
    }

    @Test
    void createCourse_duplicateCode_shouldThrow() {
        courseService.createCourse(new CourseDTO("CS101", "Intro", "Lecturer"));

        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
            courseService.createCourse(new CourseDTO("CS101", "Another", "Another"));
        });

        assertEquals("Course code already exists", thrown.getMessage());
    }
}
