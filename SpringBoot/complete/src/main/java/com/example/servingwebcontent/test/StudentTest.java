package test;

import models.Student;
import services.StudentService;

public class StudentTest {
    public static void main(String[] args) {
        // Khởi tạo dịch vụ quản lý sinh viên
        StudentService studentService = new StudentService();

        // Thêm sinh viên mới
        Student student1 = new Student("S001", "John Doe", "123456789", "D001");
        studentService.createStudent(student1);

        // Liệt kê tất cả sinh viên
        System.out.println("Danh sách sinh viên:");
        studentService.listAllStudents();

        // Cập nhật thông tin sinh viên
        student1.setDormRoomID("D002");
        studentService.updateStudent(student1.getID(), student1);

        // Xóa sinh viên
        studentService.deleteStudent(student1.getID());

        // Kiểm thử lại sau khi cập nhật và xóa
        System.out.println("Danh sách sinh viên sau khi xóa:");
        studentService.listAllStudents();
    }
}
