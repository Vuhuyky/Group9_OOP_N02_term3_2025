package CRUD;

import models.DormRoom;
import models.Student;
import models.RentalContract;
import models.CrudManager;

public class PrintList {

    // Hiển thị thông tin phòng ký túc xá
    public static void hienThiBangPhong(CrudManager<DormRoom> dormRoomManager) {
        if (dormRoomManager.getItems().isEmpty()) {
            System.out.println("Danh sách phòng trống.");
            return;
        }
        System.out.printf("%-12s %-20s %-10s %-15s%n", "Room ID", "Room Address", "Price", "Status");
        System.out.println("----------------------------------------------------");
        for (DormRoom room : dormRoomManager.getItems()) {
            System.out.printf("%-12s %-20s %-10s %-15s%n", room.getRoomID(), room.getRoomAddress(), room.getPrice(), room.getRoomStatus());
        }
    }

    // Hiển thị danh sách sinh viên
    public static void hienThiDanhSachSinhVien(CrudManager<Student> studentManager) {
        if (studentManager.getItems().isEmpty()) {
            System.out.println("Danh sách sinh viên trống.");
            return;
        }
        System.out.printf("%-15s %-20s %-15s %-20s%n", "Student ID", "Name", "Phone", "Dorm Room ID");
        System.out.println("--------------------------------------------------------------");
        for (Student student : studentManager.getItems()) {
            System.out.printf("%-15s %-20s %-15s %-20s%n", student.getStudentID(), student.getName(), student.getPhone(), student.getDormRoomID());
        }
    }

    // Hiển thị danh sách hợp đồng
    public static void hienThiDanhSachHopDong(CrudManager<RentalContract> rentalContractManager) {
        if (rentalContractManager.getItems().isEmpty()) {
            System.out.println("Danh sách hợp đồng trống.");
            return;
        }
        System.out.printf("%-15s %-15s %-15s %-20s %-20s%n", "Contract ID", "Student ID", "Room ID", "Start Date", "End Date");
        System.out.println("-------------------------------------------------------------");
        for (RentalContract contract : rentalContractManager.getItems()) {
            System.out.printf("%-15s %-15s %-15s %-20s %-20s%n", contract.getContractID(), contract.getStudentID(), contract.getRoomID(), contract.getStartDate(), contract.getEndDate());
        }
    }
}
