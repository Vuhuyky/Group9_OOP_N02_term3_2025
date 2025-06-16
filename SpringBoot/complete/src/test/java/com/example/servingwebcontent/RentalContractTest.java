package com.example.servingwebcontent.test;

import com.example.servingwebcontent.model.DormRoom;
import com.example.servingwebcontent.model.RentalContract;
import com.example.servingwebcontent.model.Student;
import com.example.servingwebcontent.service.RentalContractService;
import com.example.servingwebcontent.service.DormRoomService;
import com.example.servingwebcontent.service.StudentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class RentalContractServiceTest {

    @Autowired
    private RentalContractService rentalContractService;

    @Autowired
    private DormRoomService dormRoomService;

    @Autowired
    private StudentService studentService;

    @Test
    public void testCreateRentalContract() {
        DormRoom dormRoom = new DormRoom("D001", 1000, "Building A", "available");
        dormRoomService.createDormRoom(dormRoom);

        Student student = new Student("S001", "John Doe", "123456789", "D001");
        studentService.createStudent(student);

        RentalContract rentalContract = new RentalContract("C001", student, dormRoom, LocalDate.now(), LocalDate.now().plusMonths(6));
        rentalContractService.createRentalContract(rentalContract);

        // Kiểm tra xem hợp đồng đã được thêm vào hệ thống hay chưa
        assertNotNull(rentalContractService.listAllRentalContracts());
    }

    @Test
    public void testUpdateRentalContract() {
        DormRoom dormRoom = new DormRoom("D001", 1000, "Building A", "available");
        dormRoomService.createDormRoom(dormRoom);

        Student student = new Student("S001", "John Doe", "123456789", "D001");
        studentService.createStudent(student);

        RentalContract rentalContract = new RentalContract("C001", student, dormRoom, LocalDate.now(), LocalDate.now().plusMonths(6));
        rentalContractService.createRentalContract(rentalContract);

        rentalContract.setEndDate(LocalDate.now().plusMonths(12));
        rentalContractService.updateRentalContract(rentalContract.getID(), rentalContract);

        // Kiểm tra xem ngày kết thúc hợp đồng đã được cập nhật chưa
        assertEquals(LocalDate.now().plusMonths(12), rentalContract.getEndDate());
    }

    @Test
    public void testDeleteRentalContract() {
        DormRoom dormRoom = new DormRoom("D001", 1000, "Building A", "available");
        dormRoomService.createDormRoom(dormRoom);

        Student student = new Student("S001", "John Doe", "123456789", "D001");
        studentService.createStudent(student);

        RentalContract rentalContract = new RentalContract("C001", student, dormRoom, LocalDate.now(), LocalDate.now().plusMonths(6));
        rentalContractService.createRentalContract(rentalContract);
        rentalContractService.deleteRentalContract(rentalContract.getID());

        // Kiểm tra xem hợp đồng đã bị xóa chưa
        assertTrue(rentalContractService.listAllRentalContracts().isEmpty());
    }
}
