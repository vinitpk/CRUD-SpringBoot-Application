package com.vinitpk.SpringBootBackend.model;

import jakarta.persistence.*;
import org.hibernate.annotations.NaturalId;

/**
 * This class represents the 'students' table in the database.
 *
 * It defines the structure of the Student entity with JPA annotations.
 *
 * @author Vinit Kelginmane
 * @project SpringBoot-React-CRUD
 * @Date 05-01-2024
 */
@Entity
@Table(name = "students")
public class Student {

    // Primary key for the 'students' table
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    // First name of the student
    @Column(name = "first_name")
    private String firstName;

    // Last name of the student
    @Column(name = "last_name")
    private String lastName;

    // Unique email identifier for the student (NaturalId indicates it's a business key)
    @NaturalId(mutable = true)
    @Column(name = "email")
    private String email;

    // Department in which the student is enrolled
    @Column(name = "department")
    private String department;

    // Default constructor required by JPA
    public Student() {
    }

    /**
     * Parameterized constructor to create a new Student with specified attributes.
     *
     * @param firstName   First name of the student
     * @param lastName    Last name of the student
     * @param email       Unique email identifier for the student
     * @param department  Department in which the student is enrolled
     */
    public Student(String firstName, String lastName, String email, String department) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.department = department;
    }

    // Getter for the student's ID
    public Long getId() {
        return id;
    }

    // Getter and Setter for the student's first name
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    // Getter and Setter for the student's last name
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    // Getter and Setter for the student's email (NaturalId)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // Getter and Setter for the student's department
    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }



    /**
     * Provides a string representation of the Student object.
     *
     * @return A string containing the student's ID, first name, last name, email, and department.
     */
    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", department='" + department + '\'' +
                '}';
    }
}
