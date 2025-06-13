package CRUD;

import models.DormRoom;
import models.Student;
import models.CrudManager;
import java.util.Scanner;

public class Search {

    // Tìm kiếm phòng theo ID hoặc tên người thuê
    public static void timKiemNguoiThue(CrudManager<DormRoom> roomManager) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập tên hoặc ID người thuê để tìm kiếm: ");
        String keyword = scanner.nextLine();

        boolean found = false;
        for (DormRoom room : roomManager.getItems()) {
            if (room.getTenantName().contains(keyword) || room.getTenantID().contains(keyword)) {
                System.out.println("Phòng " + room.getRoomID() + " được thuê bởi " + room.getTenantName());
                found = true;
            }
        }

        if (!found) {
            System.out.println("Không tìm thấy người thuê với thông tin này.");
        }
    }

    // Tìm kiếm phòng theo giá
    public static void timKiemTheoGiaPhong(CrudManager<DormRoom> roomManager) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập mức giá tối đa để tìm kiếm phòng: ");
        double maxPrice = scanner.nextDouble();

        boolean found = false;
        for (DormRoom room : roomManager.getItems()) {
            if (room.getPrice() <= maxPrice) {
                System.out.println("Phòng " + room.getRoomID() + " có giá " + room.getPrice());
                found = true;
            }
        }

        if (!found) {
            System.out.println("Không tìm thấy phòng với mức giá này.");
        }
    }
}
