package com.example.servingwebcontent.service;

import com.example.servingwebcontent.model.DormRoom;
import com.example.servingwebcontent.repository.DormRoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DormRoomService {
    @Autowired
    private DormRoomRepository dormRoomRepository;

    public List<DormRoom> getAllDormRooms() {
        return dormRoomRepository.findAll();
    }

    public Optional<DormRoom> getDormRoomById(String id) {
        return dormRoomRepository.findById(id);
    }

    public void saveDormRoom(DormRoom dormRoom) {
        dormRoomRepository.save(dormRoom);
    }

    public void deleteDormRoom(String id) {
        dormRoomRepository.deleteById(id);
    }

    public List<DormRoom> getDormRoomsByStatus(String status) {
        return dormRoomRepository.findByStatus(status);
    }
}