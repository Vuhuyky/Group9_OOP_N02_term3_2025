package com.example.servingwebcontent.utils;

import com.example.servingwebcontent.model.DormRoom;
import com.example.servingwebcontent.model.Student;
import com.example.servingwebcontent.model.RentalContract;

import java.util.List;

public class PrintList {

    // Hiển thị thông tin phòng ký túc xá
    public static void hienThiBangPhong(List<DormRoom> dormRooms) {
        if (dormRooms.isEmpty()) {
            System.out.println("Danh sách phòng trống.");
            return;
        }
        dormRooms.forEach(room -> System.out.printf("%-12s %-20s %-10s %-15s%n", room.getDormRoomID(), room.getBuilding(), room.getPrice(), room.getRoomStatus()));
    }

    // Hiển thị danh sách sinh viên
    public static void hienThiDanhSachSinhVien(List<Student> students) {
        if (students.isEmpty()) {
            System.out.println("Danh sách sinh viên trống.");
            return;
        }
        students.forEach(student -> System.out.printf("%-15s %-20s %-15s %-20s%n", student.getStudentID(), student.getName(), student.getPhoneNumber(), student.getDormRoomID()));
    }

    // Hiển thị danh sách hợp đồng
    public static void hienThiDanhSachHopDong(List<RentalContract> rentalContracts) {
        if (rentalContracts.isEmpty()) {
            System.out.println("Danh sách hợp đồng trống.");
            return;
        }
        rentalContracts.forEach(contract -> System.out.printf("%-15s %-15s %-15s %-20s %-20s%n", contract.getContractID(), contract.getStudentID(), contract.getDormRoomID(), contract.getStartDate(), contract.getEndDate()));
    }
}
