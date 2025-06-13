package CRUD;

import models.DormRoom;
import models.Student;
import models.CrudManager;

public class PrintList {

    // Hiển thị thông tin phòng ký túc xá
    public static void hienThiBangPhong(CrudManager<DormRoom> roomManager) {
        System.out.printf("%-10s %-20s %-10s %-15s%n", "Room ID", "Room Address", "Price", "Status");
        System.out.println("---------------------------------------------------------");

        for (DormRoom room : roomManager.getItems()) {
            System.out.printf("%-10s %-20s %-10s %-15s%n", room.getRoomID(), room.getRoomAddress(), room.getPrice(), room.getRoomStatus());
        }
    }

    // Hiển thị danh sách sinh viên
    public static void hienThiDanhSachSinhVien(CrudManager<Student> studentManager) {
        System.out.printf("%-15s %-20s %-15s%n", "Student ID", "Name", "Phone");
        System.out.println("-----------------------------------------");

        for (Student student : studentManager.getItems()) {
            System.out.printf("%-15s %-20s %-15s%n", student.getStudentID(), student.getName(), student.getPhone());
        }
    }
}
