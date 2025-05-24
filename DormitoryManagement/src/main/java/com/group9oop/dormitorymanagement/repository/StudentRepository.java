package com.group9oop.dormitorymanagement.repository;

import com.group9oop.dormitorymanagement.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, String> {
    // Bạn có thể thêm các phương thức tùy chỉnh ở đây nếu cần
}
