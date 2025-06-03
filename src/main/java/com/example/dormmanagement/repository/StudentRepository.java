package com.example.dormmanagement.repository;

import com.example.dormmanagement.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface StudentRepository extends JpaRepository<Student, String> {
    int countByRoomIdAndIsCheckedInTrue(String roomId);
    List<Student> findByRoomId(String roomId);
    List<Student> findByMajorContainingIgnoreCase(String major);
    List<Student> findByNameContainingIgnoreCase(String name);
}
