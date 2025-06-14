package test;

import models.RentalContract;
import models.Student;
import models.DormRoom;
import services.RentalContractService;

import java.time.LocalDate;

public class RentalContractTest {
    public static void main(String[] args) {
        // Khởi tạo dịch vụ quản lý hợp đồng thuê phòng
        RentalContractService rentalContractService = new RentalContractService();

        // Tạo các đối tượng cần thiết
        DormRoom dormRoom1 = new DormRoom("D001", 1000, "Building A", "available");
        Student student1 = new Student("S001", "John Doe", "123456789", "D001");
        
        // Tạo hợp đồng thuê phòng
        RentalContract rentalContract1 = new RentalContract("C001", student1, dormRoom1, LocalDate.now(), LocalDate.now().plusMonths(6));
        rentalContractService.createRentalContract(rentalContract1);

        // Liệt kê tất cả hợp đồng thuê phòng
        System.out.println("Danh sách hợp đồng thuê phòng:");
        rentalContractService.listAllRentalContracts();

        // Cập nhật hợp đồng thuê phòng
        rentalContract1 = new RentalContract("C001", student1, dormRoom1, LocalDate.now(), LocalDate.now().plusMonths(12)); // Mở rộng hợp đồng
        rentalContractService.updateRentalContract(rentalContract1.getID(), rentalContract1);

        // Xóa hợp đồng thuê phòng
        rentalContractService.deleteRentalContract(rentalContract1.getID());

        // Kiểm thử lại sau khi cập nhật và xóa
        System.out.println("Danh sách hợp đồng thuê phòng sau khi xóa:");
        rentalContractService.listAllRentalContracts();
    }
}
