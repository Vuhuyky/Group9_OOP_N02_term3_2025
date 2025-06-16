package CRUD;

import models.DormRoom;
import models.Student;
import models.RentalContract;
import models.CrudManager;
import java.util.Scanner;

public class Search {

    // Tìm kiếm phòng theo trạng thái
    public static void timKiemTheoTinhTrangPhong(CrudManager<DormRoom> dormRoomManager) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập trạng thái phòng (available/occupied) để tìm kiếm: ");
        String status = scanner.nextLine();

        boolean found = false;
        for (DormRoom room : dormRoomManager.getItems()) {
            if (room.getRoomStatus().equalsIgnoreCase(status)) {
                System.out.println("Phòng " + room.getDormRoomID() + " có trạng thái " + room.getRoomStatus());
                found = true;
            }
        }

        if (!found) {
            System.out.println("Không tìm thấy phòng với trạng thái này.");
        }
    }

    // Tìm kiếm sinh viên theo tên
    public static void timKiemSinhVienTheoTen(CrudManager<Student> studentManager) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập tên sinh viên để tìm kiếm: ");
        String keyword = scanner.nextLine();

        boolean found = false;
        for (Student student : studentManager.getItems()) {
            if (student.getName().contains(keyword)) {
                System.out.println("Sinh viên " + student.getName() + " có mã sinh viên " + student.getStudentID());
                found = true;
            }
        }

        if (!found) {
            System.out.println("Không tìm thấy sinh viên với tên này.");
        }
    }

    // Tìm kiếm hợp đồng theo ngày bắt đầu
    public static void timKiemHopDongTheoNgayBatDau(CrudManager<RentalContract> rentalContractManager) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập ngày bắt đầu hợp đồng (yyyy-mm-dd): ");
        String startDateStr = scanner.nextLine();

        boolean found = false;
        for (RentalContract contract : rentalContractManager.getItems()) {
            if (contract.getStartDate().toString().equals(startDateStr)) {
                System.out.println("Hợp đồng " + contract.getContractID() + " bắt đầu vào " + contract.getStartDate());
                found = true;
            }
        }

        if (!found) {
            System.out.println("Không tìm thấy hợp đồng với ngày bắt đầu này.");
        }
    }
}
