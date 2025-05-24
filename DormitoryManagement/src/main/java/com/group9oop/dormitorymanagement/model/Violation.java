package com.group9oop.dormitorymanagement.model;

import java.time.LocalDate;

public class Violation {
    private Student student;
    private String description;
    private LocalDate violationDate;

    public Violation(Student student, String description, LocalDate violationDate) {
        this.student = student;
        this.description = description;
        this.violationDate = violationDate;
    }

    public Student getStudent() {
        return student;
    }

    public String getDescription() {
        return description;
    }

    public LocalDate getViolationDate() {
        return violationDate;
    }
}
