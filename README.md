Student Course Registration System

How to Run the Application

Prerequisites:
- Java 17
- Maven

 Steps:
```bash
git clone <>
cd student-course-registration
mvn spring-boot:run
```

Application runs on `http://localhost:8080`

 Sample HTTP Requests to try on Postman

Register a Student
```http
POST /students/register
Content-Type: application/json

{
  "name": "Hiruni Dilmika",
  "email": "hiruni@example.com"
}
```

Add a Course
```http
POST /courses/addCourse
Content-Type: application/json

{
  "courseCode": "CS101",
  "title": "Intro to CS",
  "instructorName": "Dr. Silva"
}
```

View All Students
```http
GET /students/allStudents
```


View All Courses
``` http
GET /courses/all
```


 Register to a Course
```http
POST /students/{studentId}/register/{courseId}
```

Unregister a Course
```http
DELETE /students/{studentId}/drop/{courseId}
```

 Get Registered Courses
```http
GET /students/{studentId}/courses
```

---

Assumptions Made
- Email must be unique for each student.
- Course code must be unique.
- No seat limits on courses.
- INteger ID is used as the identifier.
- In-memory data storage (no DB).

---

Code Structure
```
├── controller        // REST controllers
├── service           // Business logic
├── dto               // Request/Response payloads
├── model             // Data models
├── exception         // Global exception handling
└── Application.java  // Main class
```

---

Future Improvements
- Add Swagger for API documentation
- Add pagination to course listing
- Add Docker support

---

© 2025 ZDATA Innovations – Internship Assessment Project
