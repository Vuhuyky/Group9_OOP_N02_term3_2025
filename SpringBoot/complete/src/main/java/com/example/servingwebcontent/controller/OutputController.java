package com.example.servingwebcontent.controller;

import com.example.servingwebcontent.model.DormRoom;
import com.example.servingwebcontent.model.Student;
import com.example.servingwebcontent.model.RentalContract;
import com.example.servingwebcontent.service.DormRoomService;
import com.example.servingwebcontent.service.StudentService;
import com.example.servingwebcontent.service.RentalContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OutputController {

    @Autowired
    private DormRoomService dormRoomService;

    @Autowired
    private StudentService studentService;

    @Autowired
    private RentalContractService rentalContractService;

    // Hiển thị danh sách phòng ký túc xá
    @GetMapping("/dormrooms")
    public List<DormRoom> hienThiBangPhong() {
        return dormRoomService.getAllDormRooms();
    }

    // Hiển thị danh sách sinh viên
    @GetMapping("/students")
    public List<Student> hienThiDanhSachSinhVien() {
        return studentService.getAllStudents();
    }

    // Hiển thị danh sách hợp đồng
    @GetMapping("/rentalcontracts")
    public List<RentalContract> hienThiDanhSachHopDong() {
        return rentalContractService.getAllRentalContracts();
    }
}
