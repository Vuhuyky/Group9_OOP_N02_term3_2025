package com.group9oop.dormitorymanagement.service;

import com.group9oop.dormitorymanagement.model.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentList {
    private List<Student> students = new ArrayList<>();

    public void addStudent(Student student) {
        students.add(student);
    }

    public void editStudent(int studentId, String newFullname) {
        for (Student s : students) {
            if (s.getId() == studentId) {
                s.setFullName(newFullname);
                break;
            }
        }
    }

    public void deleteStudent(int studentId) {
        students.removeIf(s -> s.getId() == studentId);
    }

    public void printStudentList() {
        System.out.println("=== Student List ===");
        for (Student s : students) {
            System.out.printf("ID: %d | Name: %s\n", s.getId(), s.getFullName());
        }
    }
}
