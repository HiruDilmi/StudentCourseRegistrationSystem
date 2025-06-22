//package com.example.StudentCourseRegistrationSystem.service;
//
//import com.example.StudentCourseRegistrationSystem.dto.CourseDTO;
//import com.example.StudentCourseRegistrationSystem.model.Course;
//import org.springframework.stereotype.Service;
//
//import java.util.*;
//
//@Service
//public class CourseServiceImpl implements CourseService {
//
//    private final Map<UUID, Course> courseMap = new HashMap<>();
//
//    public Map<UUID, Course> getCourseMap() {
//        return courseMap;
//    }
//
//    // Create a new course
//    @Override
//    public CourseDTO createCourse(CourseDTO courseDTO) {
//        UUID courseId = UUID.randomUUID();
//
//        // Create a Course object and save it
//        Course course = new Course(courseId, courseDTO.getCourseCode(), courseDTO.getTitle(), courseDTO.getInstructorName());
//        courseMap.put(courseId, course);
//
//        // Return the DTO as a response
//        return new CourseDTO(course.getId(), course.getCode(), course.getTitle(), course.getInstructor());
//    }
//
//    // Get all courses
//    @Override
//    public List<CourseDTO> getAllCourses() {
//        List<CourseDTO> courseList = new ArrayList<>();
//
//        for (Course course : courseMap.values()) {
//            courseList.add(new CourseDTO(
//                    course.getId(),
//                    course.getCode(),
//                    course.getTitle(),
//                    course.getInstructor()
//            ));
//        }
//        return courseList;
//    }
//}
