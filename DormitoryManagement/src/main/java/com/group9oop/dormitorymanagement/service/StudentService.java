package com.group9oop.dormitorymanagement.service;

import com.group9oop.dormitorymanagement.model.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private List<Student> students = new ArrayList<>();

    public List<Student> getAllStudents() {
        return students;
    }

    public Optional<Student> getStudentById(String id) {
        return students.stream()
                .filter(s -> String.valueOf(s.getId()).equals(id))
                .findFirst();
    }

    public Student addStudent(Student student) {
        students.add(student);
        return student;
    }

    public Student updateStudent(Student student) {
        deleteStudent(student.getId());
        students.add(student);
        return student;
    }

    public void deleteStudent(int id) {
        students.removeIf(s -> s.getId() == id);
    }
}
