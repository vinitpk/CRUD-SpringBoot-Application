package com.vinitpk.SpringBootBackend.repository;

import com.vinitpk.SpringBootBackend.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Repository interface for handling CRUD operations on the 'students' table.
 *
 * It extends JpaRepository to leverage Spring Data JPA's built-in repository functionality.
 *
 * @author Vinit Kelginmane
 * @project SpringBoot-React-CRUD
 * @Date 05-01-2024
 */
@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    /**
     * Retrieves a student by their email.
     *
     * @param email The unique email identifier of the student.
     * @return An Optional containing the student if found, or an empty Optional otherwise.
     */
    Optional<Student> findByEmail(String email);
}
