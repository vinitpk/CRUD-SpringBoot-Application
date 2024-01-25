package com.vinitpk.SpringBootBackend.controller;

import com.vinitpk.SpringBootBackend.model.Student;
import com.vinitpk.SpringBootBackend.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller class for handling HTTP requests related to the Student entity.
 *
 * It defines REST-ful endpoints for performing CRUD operations on students.
 *
 * @author Vinit Kelginmane
 * @project SpringBoot-React-CRUD
 * @Date 05-01-2024
 */

@RestController
@RequestMapping("/students")
public class StudentController {

    // Injecting the IStudentService using constructor injection
    private IStudentService studentService;

    @Autowired
    public StudentController(IStudentService studentService) {
        this.studentService = studentService;
    }

    // Endpoint to retrieve all students
    @GetMapping
    public ResponseEntity<List<Student>> getStudents() {
        // Return a response entity with the list of students and HTTP status FOUND (200)
        return new ResponseEntity<>(studentService.getStudents(), HttpStatus.FOUND);
    }

    // Endpoint to add a new student
    @PostMapping
    public Student addStudent(@RequestBody Student student) {
        // Return the added student
        return studentService.addStudent(student);
    }

    // Endpoint to update an existing student
    @PutMapping("/update/{id}")
    public Student updateStudent(@RequestBody Student student, @PathVariable Long id) {
        // Return the updated student
        return studentService.updateStudent(student, id);
    }

    // Endpoint to delete a student by ID
    @DeleteMapping("/delete/{id}")
    public void deleteStudent(@PathVariable Long id) {
        // Delete the student
        studentService.deleteStudent(id);
    }

    // Endpoint to retrieve a student by ID
    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable Long id) {
        // Return the student with the specified ID
        return studentService.getStudentById(id);
    }
}
