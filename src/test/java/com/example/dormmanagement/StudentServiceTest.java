package com.example.dormmanagement;

import com.example.dormmanagement.model.Room;
import com.example.dormmanagement.model.Student;
import com.example.dormmanagement.repository.RoomRepository;
import com.example.dormmanagement.repository.StudentRepository;
import com.example.dormmanagement.service.RoomService;
import com.example.dormmanagement.service.StudentService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDate;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
public class StudentServiceTest {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private RoomRepository roomRepository;

    private RoomService roomService;
    private StudentService studentService;

    @AfterEach
    public void cleanup() {
        studentRepository.deleteAll();
        roomRepository.deleteAll();
    }

    @Test
    public void testAssignAndCheckoutStudent() {
        roomService = new RoomService(roomRepository);
        studentService = new StudentService(studentRepository, roomRepository);

        // 1) Tạo Room
        Room r1 = new Room("B201", 2, 2, "Phòng đôi", null);
        Room savedRoom = roomService.save(r1);
        assertNotNull(savedRoom.getId());

        // 2) Tạo Student (chưa gán phòng)
        Student s1 = new Student(
            "SV001",                 // id (MSSV)
            "Nguyen Van A",          // name
            "CNTT",                  // major
            LocalDate.of(2000, 1, 1),
            "0912345678",
            "a@example.com",
            null,                    // roomId chưa có
            null, null,
            false                    // chưa check-in
        );
        Student savedStudent = studentService.save(s1);
        assertNotNull(savedStudent.getId());

        // 3) Gán Student vào Room (check-in)
        boolean checkInResult = studentService.assignStudentToRoom(
                savedStudent.getId(),
                savedRoom.getId()
        );
        assertTrue(checkInResult);

        // Lấy lại student, kiểm tra roomId, isCheckedIn, checkInDate
        Optional<Student> opt1 = studentService.findById(savedStudent.getId());
        assertTrue(opt1.isPresent());
        Student fetched = opt1.get();
        assertEquals(savedRoom.getId(), fetched.getRoomId());
        assertTrue(fetched.isCheckedIn());
        assertNotNull(fetched.getCheckInDate());

        // 4) Check-out student
        boolean checkOutResult = studentService.checkoutStudent(savedStudent.getId());
        assertTrue(checkOutResult);

        // Lấy lại student, kiểm tra roomId null, isCheckedIn false, checkOutDate không null
        Optional<Student> opt2 = studentService.findById(savedStudent.getId());
        assertTrue(opt2.isPresent());
        Student afterCheckout = opt2.get();
        assertNull(afterCheckout.getRoomId());
        assertFalse(afterCheckout.isCheckedIn());
        assertNotNull(afterCheckout.getCheckOutDate());
    }
}
