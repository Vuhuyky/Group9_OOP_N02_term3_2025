package com.example.dormmanagement.service;

import com.example.dormmanagement.model.Room;
import com.example.dormmanagement.model.Student;
import com.example.dormmanagement.repository.RoomRepository;
import com.example.dormmanagement.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepository studentRepository;
    private final RoomRepository roomRepository;

    public StudentService(StudentRepository studentRepository,
                          RoomRepository roomRepository) {
        this.studentRepository = studentRepository;
        this.roomRepository = roomRepository;
    }

    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    public Optional<Student> findById(String id) {
        return studentRepository.findById(id);
    }

    public Student save(Student student) {
        return studentRepository.save(student);
    }

    public Optional<Student> update(Student studentDetails) {
        Optional<Student> opt = studentRepository.findById(studentDetails.getId());
        if (opt.isPresent()) {
            Student student = opt.get();
            // Cập nhật các trường cần thiết
            student.setName(studentDetails.getName());
            student.setMajor(studentDetails.getMajor());
            student.setBirthDate(studentDetails.getBirthDate());
            student.setPhoneNumber(studentDetails.getPhoneNumber());
            student.setEmail(studentDetails.getEmail());
            // Các trường liên quan phòng, trạng thái không update trực tiếp ở đây
            return Optional.of(studentRepository.save(student));
        }
        return Optional.empty();
    }

    public boolean delete(String id) {
        Optional<Student> opt = studentRepository.findById(id);
        if (opt.isPresent()) {
            studentRepository.delete(opt.get());
            return true;
        }
        return false;
    }

    // **Sửa method gán sinh viên vào phòng chỉ nhận 2 tham số**
    public boolean assignStudentToRoom(String studentId, String roomId) {
        Optional<Room> optRoom = roomRepository.findById(roomId);
        if (optRoom.isEmpty()) {
            return false; // phòng không tồn tại
        }
        Room room = optRoom.get();

        // Đếm số sinh viên đã check-in trong phòng này
        int currentCount = studentRepository.countByRoomIdAndIsCheckedInTrue(roomId);
        if (currentCount >= room.getCapacity()) {
            return false; // phòng đã đầy
        }

        Optional<Student> optStudent = studentRepository.findById(studentId);
        if (optStudent.isEmpty()) {
            return false; // sinh viên không tồn tại
        }

        Student student = optStudent.get();
        student.setRoomId(roomId);
        student.setCheckedIn(true);
        student.setCheckInDate(LocalDate.now());
        student.setCheckOutDate(null); // reset ngày check-out nếu có

        studentRepository.save(student);
        return true;
    }

    public List<Student> getStudentsByRoom(String roomId) {
        return studentRepository.findByRoomId(roomId);
    }

    public List<Student> filterByMajor(String major) {
        return studentRepository.findByMajorContainingIgnoreCase(major);
    }

    public List<Student> filterByName(String name) {
        return studentRepository.findByNameContainingIgnoreCase(name);
    }

    public boolean checkoutStudent(String studentId) {
        Optional<Student> opt = studentRepository.findById(studentId);
        if (opt.isEmpty()) return false;

        Student student = opt.get();
        student.setCheckedIn(false);
        student.setRoomId(null);
        student.setCheckOutDate(LocalDate.now());

        studentRepository.save(student);
        return true;
    }
}
