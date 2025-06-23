package com.example.StudentCourseRegistrationSystem.test;
import com.example.StudentCourseRegistrationSystem.dto.StudentDTO;
import com.example.StudentCourseRegistrationSystem.model.Student;
import com.example.StudentCourseRegistrationSystem.service.StudentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
public class StudentServiceTest {

    @Autowired
    private StudentService studentService;

    @Test
    void createStudent_shouldSucceed() {
        StudentDTO dto = new StudentDTO("Hiruni", "hiruni@example.com");
        Student student = studentService.registerStudent(dto);

        assertNotNull(student);
        assertEquals("Hiruni", student.getName());
        assertEquals("hiruni@example.com", student.getEmail());
    }

    @Test
    void createStudent_duplicateEmail_shouldThrow() {
        studentService.registerStudent(new StudentDTO("Test", "test@example.com"));

        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
            studentService.registerStudent(new StudentDTO("Another", "test@example.com"));
        });

        assertEquals("Email already exists", thrown.getMessage());
    }
    }
