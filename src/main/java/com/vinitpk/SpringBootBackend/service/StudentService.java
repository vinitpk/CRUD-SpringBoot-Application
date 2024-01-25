package com.vinitpk.SpringBootBackend.service;

import com.vinitpk.SpringBootBackend.exception.StudentAlreadyExistsException;
import com.vinitpk.SpringBootBackend.exception.StudentNotFoundException;
import com.vinitpk.SpringBootBackend.model.Student;
import com.vinitpk.SpringBootBackend.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Service implementation for handling operations related to the Student entity.
 *
 * It provides logic for adding, retrieving, updating, and deleting students.
 * Includes error handling for cases where a student already exists or cannot be found.
 *
 * @author Vinit Kelginmane
 * @project SpringBoot-React-CRUD
 * @Date 05-01-2024
 */
@Service
public class StudentService implements IStudentService {

    // Injecting the StudentRepository using constructor injection
    private StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public List<Student> getStudents() {
        // Retrieve and return all students from the repository
        return studentRepository.findAll();
    }

    @Override
    public Student addStudent(Student student) {
        // Check if a student with the same email already exists
        if (studentAlreadyExists(student.getEmail())) {
            throw new StudentAlreadyExistsException(student.getEmail() + " already exists!");
        }
        // Save and return the newly added student
        return studentRepository.save(student);
    }

    @Override
    public Student updateStudent(Student student, Long id) {

        // Check if another student with the same email already exists
        String newEmail = student.getEmail();
        Optional<Student> existingStudentByEmail = studentRepository.findByEmail(newEmail);
        if (existingStudentByEmail.isPresent() && !existingStudentByEmail.get().getId().equals(id)) {
            throw new StudentAlreadyExistsException(newEmail + " is already associated with another student!");
        }

        // Update the existing student with the provided information
        return studentRepository.findById(id).map(st -> {
            st.setFirstName(student.getFirstName());
            st.setLastName(student.getLastName());
            st.setEmail(student.getEmail());
            st.setDepartment(student.getDepartment());

            // Save and return the updated student
            return studentRepository.save(st);
        }).orElseThrow(() -> new StudentNotFoundException("Sorry, this student could not be found"));
    }

    @Override
    public Student getStudentById(Long id) {
        // Retrieve and return a student by their ID, or throw an exception if not found
        return studentRepository.findById(id)
                .orElseThrow(() -> new StudentNotFoundException("Sorry, no student found with the Id :" + id));
    }

    @Override
    public void deleteStudent(Long id) {
        // Check if the student exists, if not, throw an exception
        if (!studentRepository.existsById(id)) {
            throw new StudentNotFoundException("Sorry, student not found");
        }
        // Delete the student by ID
        studentRepository.deleteById(id);
    }

    // Helper method to check if a student with the given email already exists
    private boolean studentAlreadyExists(String email) {
        return studentRepository.findByEmail(email).isPresent();
    }
}
