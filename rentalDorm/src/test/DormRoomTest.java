package test;

import models.DormRoom;
import services.DormRoomService;

public class DormRoomTest {
    public static void main(String[] args) {
        // Khởi tạo dịch vụ quản lý phòng ký túc xá
        DormRoomService dormRoomService = new DormRoomService();

        // Thêm phòng ký túc xá
        DormRoom dormRoom1 = new DormRoom("D001", 1000, "Building A", "available");
        dormRoomService.createDormRoom(dormRoom1);

        // Liệt kê tất cả phòng ký túc xá
        System.out.println("Danh sách phòng:");
        dormRoomService.listAllDormRooms();

        // Cập nhật phòng ký túc xá
        dormRoom1.setRoomStatus("occupied");
        dormRoomService.updateDormRoom(dormRoom1.getID(), dormRoom1);

        // Xóa phòng ký túc xá
        dormRoomService.deleteDormRoom(dormRoom1.getID());

        // Kiểm thử lại sau khi cập nhật và xóa
        System.out.println("Danh sách phòng sau khi xóa:");
        dormRoomService.listAllDormRooms();
    }
}
