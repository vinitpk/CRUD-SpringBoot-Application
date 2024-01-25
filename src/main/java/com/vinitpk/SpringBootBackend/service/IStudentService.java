package com.vinitpk.SpringBootBackend.service;

import com.vinitpk.SpringBootBackend.model.Student;

import java.util.List;

/**
 * Service interface defining operations related to the Student entity.
 *
 * It declares methods for adding, retrieving, updating, and deleting students.
 * Implementations of this interface will provide the actual logic for these operations.
 *
 * @author Vinit Kelginmane
 * @project SpringBoot-React-CRUD
 * @Date 05-01-2024
 */
public interface IStudentService {

    /**
     * Adds a new student to the system.
     *
     * @param student The student object to be added.
     * @return The added student object.
     */
    Student addStudent(Student student);

    /**
     * Retrieves a list of all students in the system.
     *
     * @return A list of Student objects.
     */
    List<Student> getStudents();

    /**
     * Updates the information of an existing student.
     *
     * @param student The updated student object.
     * @param id      The ID of the student to be updated.
     * @return The updated student object.
     */
    Student updateStudent(Student student, Long id);

    /**
     * Retrieves a student by their ID.
     *
     * @param id The ID of the student to be retrieved.
     * @return The student object if found, otherwise null.
     */
    Student getStudentById(Long id);

    /**
     * Deletes a student from the system by their ID.
     *
     * @param id The ID of the student to be deleted.
     */
    void deleteStudent(Long id);
}
