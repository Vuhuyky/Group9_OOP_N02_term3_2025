package Review;

import models.DormRoom;
import models.Student;
import models.RentalContract;
import services.DormRoomService;
import services.StudentService;
import services.RentalContractService;

import java.time.LocalDate;

public class TestSequence {
    public static void main(String[] args) {
        // Tạo các dịch vụ quản lý phòng ký túc xá, sinh viên và hợp đồng thuê phòng
        DormRoomService dormRoomService = new DormRoomService();
        StudentService studentService = new StudentService();
        RentalContractService rentalContractService = new RentalContractService();

        // Tạo phòng ký túc xá mới
        DormRoom dormRoom1 = new DormRoom("D001", 1000, "Building A", "available");
        dormRoomService.createDormRoom(dormRoom1);
        
        // Tạo sinh viên mới
        Student student1 = new Student("S001", "John Doe", "123456789", "D001");
        studentService.createStudent(student1);
        
        // Tạo hợp đồng thuê phòng mới
        RentalContract rentalContract1 = new RentalContract("C001", student1, dormRoom1, LocalDate.now(), LocalDate.now().plusMonths(6));
        rentalContractService.createRentalContract(rentalContract1);

        // Sử dụng Sequence và Selector để duyệt qua các đối tượng
        Sequence<DormRoom> dormRooms = new Sequence<>(10);
        dormRooms.add(dormRoom1);
        
        Sequence<Student> students = new Sequence<>(10);
        students.add(student1);
        
        Sequence<RentalContract> rentalContracts = new Sequence<>(10);
        rentalContracts.add(rentalContract1);

        // Selector để duyệt qua phòng ký túc xá
        Selector dormRoomSelector = dormRooms.getSelector();
        while (!dormRoomSelector.end()) {
            System.out.println(dormRoomSelector.current());
            dormRoomSelector.next();
        }

        // Selector để duyệt qua sinh viên
        Selector studentSelector = students.getSelector();
        while (!studentSelector.end()) {
            System.out.println(studentSelector.current());
            studentSelector.next();
        }

        // Selector để duyệt qua hợp đồng thuê phòng
        Selector rentalContractSelector = rentalContracts.getSelector();
        while (!rentalContractSelector.end()) {
            System.out.println(rentalContractSelector.current());
            rentalContractSelector.next();
        }
    }
}
