package com.example.servingwebcontent.service;

import com.example.servingwebcontent.model.RentalContract;
import com.example.servingwebcontent.repository.RentalContractRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RentalContractService {
    @Autowired
    private RentalContractRepository rentalContractRepository;

    public List<RentalContract> getAllContracts() {
        return rentalContractRepository.findAll();
    }

    public Optional<RentalContract> getContractById(Integer id) {
        return rentalContractRepository.findById(id);
    }

    public void saveContract(RentalContract contract) {
        rentalContractRepository.save(contract);
    }

    public void deleteContract(Integer id) {
        rentalContractRepository.deleteById(id);
    }

    public int countActiveContractsByRoom(String roomId) {
        return rentalContractRepository.findByDormRoom_RoomIdAndStatus(roomId, "Còn hiệu lực").size();
    }

    public List<RentalContract> findByDormRoom_RoomId(String roomId) {
        return rentalContractRepository.findByDormRoom_RoomId(roomId);
    }

    public List<RentalContract> findByStudent_StudentID(String studentId) {
        return rentalContractRepository.findByStudent_StudentID(studentId);
    }

    // Thêm phương thức này để controller sử dụng
    public List<RentalContract> findByStudent_StudentIDAndStatus(String studentId, String status) {
        return rentalContractRepository.findByStudent_StudentIDAndStatus(studentId, status);
    }
} // <-- Thêm dấu ngoặc nhọn này ở cuối file