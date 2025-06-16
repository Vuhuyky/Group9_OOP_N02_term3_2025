package com.example.servingwebcontent.test;

import com.example.servingwebcontent.model.Student;
import com.example.servingwebcontent.service.StudentService;

public class StudentTest {
    public static void main(String[] args) {
        StudentService studentService = new StudentService();

        Student student1 = new Student("S001", "John Doe", "123456789", "D001");
        studentService.createStudent(student1);

        System.out.println("Danh sách sinh viên:");
        studentService.listAllStudents();

        student1.setDormRoomID("D002");
        studentService.updateStudent(student1.getID(), student1);

        studentService.deleteStudent(student1.getID());

        System.out.println("Danh sách sinh viên sau khi xóa:");
        studentService.listAllStudents();
    }
}
