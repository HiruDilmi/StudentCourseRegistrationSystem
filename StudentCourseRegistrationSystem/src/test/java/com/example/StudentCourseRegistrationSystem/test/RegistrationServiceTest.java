package com.example.StudentCourseRegistrationSystem.test;

import com.example.StudentCourseRegistrationSystem.dto.CourseDTO;
import com.example.StudentCourseRegistrationSystem.dto.StudentDTO;
import com.example.StudentCourseRegistrationSystem.model.Course;
import com.example.StudentCourseRegistrationSystem.model.Registration;
import com.example.StudentCourseRegistrationSystem.model.Student;
import com.example.StudentCourseRegistrationSystem.service.CourseService;
import com.example.StudentCourseRegistrationSystem.service.RegistrationService;
import com.example.StudentCourseRegistrationSystem.service.StudentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.hibernate.validator.internal.util.Contracts.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
public class RegistrationServiceTest {
    private StudentService studentService;
    private CourseService courseService;
    private RegistrationService registrationService;

    @BeforeEach
    void setup() {
        studentService = new StudentService();
        courseService = new CourseService();
        registrationService = new RegistrationService(courseService);
    }

    @Test
    void registerAndDropCourse_shouldSucceed() {
        Student student = studentService.registerStudent(new StudentDTO("Sam", "sam@example.com"));
        Course course = courseService.createCourse(new CourseDTO("CS101", "Intro", "Dr. Silva"));

        Registration reg = registrationService.register(student.getId(), course.getId());
        assertNotNull(reg);

        registrationService.unregister(student.getId(), course.getId());

        assertThrows(Exception.class, () -> {
            registrationService.unregister(student.getId(), course.getId());
        });
    }

    @Test
    void duplicateRegistration_shouldFail() {
        Student student = studentService.registerStudent(new StudentDTO("Kamal", "kamal@example.com"));
        Course course = courseService.createCourse(new CourseDTO("CS102", "DS", "Dr. Nimal"));

        registrationService.register(student.getId(), course.getId());

        IllegalStateException thrown = assertThrows(IllegalStateException.class, () -> {
            registrationService.register(student.getId(), course.getId());
        });

        assertEquals("Student is already registered in this course.", thrown.getMessage());
    }

}
