package com.group9oop.dormitorymanagement;

import com.group9oop.dormitorymanagement.model.Student;
import com.group9oop.dormitorymanagement.model.Room;
import com.group9oop.dormitorymanagement.service.StudentService;
import com.group9oop.dormitorymanagement.service.RoomService;

public class App {
    public static void main(String[] args) {
        StudentService studentService = new StudentService();
        RoomService roomService = new RoomService();

        // Tạo sinh viên
        Student s1 = new Student("SV001", "Nguyen Van A");
        Student s2 = new Student("SV002", "Tran Thi B");

        studentService.addStudent(s1);
        studentService.addStudent(s2);

        // Tạo phòng
        Room room101 = new Room("101", 2);
        roomService.addRoom(room101);

        // Gán sinh viên vào phòng và in kết quả để tránh cảnh báo
        boolean added1 = roomService.assignStudentToRoom(s1, "101");
        System.out.println("Gán sinh viên 1 vào phòng 101: " + added1);
        boolean added2 = roomService.assignStudentToRoom(s2, "101");
        System.out.println("Gán sinh viên 2 vào phòng 101: " + added2);

        // In thông tin sinh viên trong phòng
        roomService.findRoomByNumber("101").ifPresent(room -> {
            System.out.println("Phòng: " + room.getRoomNumber());
            room.getStudents().forEach(student -> {
                System.out.println(" - " + student.getFullName());
            });
        });

        // Thử cập nhật tên sinh viên
        boolean updated = studentService.updateStudent("SV001", "Nguyen Van Anh");
        System.out.println("Cập nhật tên sinh viên SV001: " + updated);

        // In lại sau cập nhật
        System.out.println("Danh sách sinh viên hiện có:");
        studentService.getAllStudents().forEach(student -> {
            System.out.println("Sinh viên: " + student.getId() + " - " + student.getFullName());
        });
    }
}
