//package com.example.StudentCourseRegistrationSystem.service;
//
//import com.example.StudentCourseRegistrationSystem.dto.CourseDTO;
//import com.example.StudentCourseRegistrationSystem.dto.StudentDTO;
//import com.example.StudentCourseRegistrationSystem.model.Course;
//import com.example.StudentCourseRegistrationSystem.model.Student;
//import org.springframework.stereotype.Service;
//
//import java.util.*;
//
//@Service
//public class StudentServiceImpl implements StudentService{
//    private final Map<UUID, Student> studentMap = new HashMap<>();
//    private final Map<UUID, List<UUID>> registrationMap = new HashMap<>();
//    private final Map<UUID, Course> courseMap = new HashMap<>();
//
//
//    // Register a new student
//    @Override
//    public StudentDTO createStudent(StudentDTO studentDTO) {
//        UUID studentId = UUID.randomUUID();
//        Student student = new Student(studentId, studentDTO.getName(), studentDTO.getEmail());
//        studentMap.put(studentId, student);
//        return new StudentDTO(studentId, studentDTO.getName(), studentDTO.getEmail());
//    }
//
//    // Register for a course
//    @Override
//    public void registerForCourse(UUID studentId, UUID courseId) {
//        if (!studentMap.containsKey(studentId)) {
//            throw new IllegalArgumentException("Student not found");
//        }
//        if (!courseMap.containsKey(courseId)) {
//            throw new IllegalArgumentException("Course not found");
//        }
//
//        registrationMap.computeIfAbsent(studentId, new ArrayList<>());
//        List<UUID> registeredCourses = registrationMap.get(studentId);
//
//        if (registeredCourses.contains(courseId)) {
//            throw new IllegalArgumentException("Student already registered for this course");
//        }
//
//        registeredCourses.add(courseId);
//    }
//
//
//    // Drop a course
//    @Override
//    public void dropCourse(UUID studentId, UUID courseId) {
//        if (!courseMap.containsKey(courseId)) {
//            throw new IllegalArgumentException("Course not found");
//        }
//
//        List<UUID> registeredCourses = registrationMap.get(studentId);
//
//        if (registeredCourses == null || !registeredCourses.remove(courseId)) {
//            throw new IllegalArgumentException("Student not registered for this course");
//        }
//    }
//
//    // Get all registered courses for a student
//    @Override
//    public List<CourseDTO> getRegisteredCourses(UUID studentId) {
//        List<UUID> registeredCourses = registrationMap.getOrDefault(studentId, new ArrayList<>());
//        List<CourseDTO> courseDTOs = new ArrayList<>();
//
//        // If the student has no registered courses, return an empty list
//        if (registeredCourses == null) {
//            return Collections.emptyList();
//        }
//
//        for (UUID courseId : registeredCourses) {
//            Course course = courseMap.get(courseId);
//            if (course != null) {
//                courseDTOs.add(new CourseDTO(
//                        courseDTOs.getId(),
//                        courseDTOs.getCourseCode(),
//                        course.getTitle(),
//                        course.getInstructorName()
//                ));
//            }
//        }
//        return courseDTOs;
//    }
//}
