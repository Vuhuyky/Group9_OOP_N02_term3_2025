package com.example.servingwebcontent;

import com.example.servingwebcontent.model.DormRoom;
import com.example.servingwebcontent.model.Student;
import com.example.servingwebcontent.model.RentalContract;
import com.example.servingwebcontent.service.DormRoomService;
import com.example.servingwebcontent.service.StudentService;
import com.example.servingwebcontent.service.RentalContractService;

import java.time.LocalDate;

public class TestSequence {
    public static void main(String[] args) {
        DormRoomService dormRoomService = new DormRoomService();
        StudentService studentService = new StudentService();
        RentalContractService rentalContractService = new RentalContractService();

        DormRoom dormRoom1 = new DormRoom("D001", 5000, "Building A", "available");
        dormRoomService.createDormRoom(dormRoom1);

        Student student1 = new Student("S001", "John Doe", "123456789", "D001");
        studentService.createStudent(student1);

        RentalContract rentalContract1 = new RentalContract("C001", student1, dormRoom1, LocalDate.now(), LocalDate.now().plusMonths(6));
        rentalContractService.createRentalContract(rentalContract1);

        System.out.println("Danh sách hợp đồng thuê phòng:");
        rentalContractService.listAllRentalContracts();

        rentalContract1 = new RentalContract("C001", student1, dormRoom1, LocalDate.now(), LocalDate.now().plusMonths(12));
        rentalContractService.updateRentalContract(rentalContract1.getID(), rentalContract1);

        rentalContractService.deleteRentalContract(rentalContract1.getID());

        System.out.println("Danh sách hợp đồng thuê phòng sau khi xóa:");
        rentalContractService.listAllRentalContracts();
    }
}
