package com.group9oop.dormitorymanagement.service;

import com.group9oop.dormitorymanagement.model.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class StudentService {
    private List<Student> students = new ArrayList<>();

    // Thêm sinh viên mới
    public void addStudent(Student student) {
        students.add(student);
    }

    // Xóa sinh viên theo ID
    public boolean removeStudentById(String id) {
        return students.removeIf(s -> s.getId().equals(id));
    }

    // Tìm sinh viên theo ID
    public Optional<Student> findStudentById(String id) {
        return students.stream()
                .filter(s -> s.getId().equals(id))
                .findFirst();
    }

    // Lấy danh sách tất cả sinh viên
    public List<Student> getAllStudents() {
        return students;
    }

    // Cập nhật thông tin sinh viên theo ID
    public boolean updateStudent(String id, String newName) {
        Optional<Student> studentOpt = findStudentById(id);
        if (studentOpt.isPresent()) {
            Student student = studentOpt.get();
            student.setFullName(newName);
            return true;
        }
        return false;
    }
}
