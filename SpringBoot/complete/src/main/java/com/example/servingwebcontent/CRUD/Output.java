package CRUD;

import models.DormRoom;
import models.Student;
import models.RentalContract;
import models.CrudManager;

public class Output {

    // Hiển thị danh sách phòng ký túc xá
    public static void hienThiBangPhong(CrudManager<DormRoom> dormRoomManager) {
        PrintList.hienThiBangPhong(dormRoomManager);
    }

    // Hiển thị danh sách sinh viên
    public static void hienThiDanhSachSinhVien(CrudManager<Student> studentManager) {
        PrintList.hienThiDanhSachSinhVien(studentManager);
    }

    // Hiển thị danh sách hợp đồng
    public static void hienThiDanhSachHopDong(CrudManager<RentalContract> rentalContractManager) {
        PrintList.hienThiDanhSachHopDong(rentalContractManager);
    }
}
