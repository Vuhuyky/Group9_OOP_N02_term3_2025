package com.example.dormmanagement.service;

import com.example.dormmanagement.model.Room;
import com.example.dormmanagement.repository.RoomRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoomService {

    private final RoomRepository roomRepository;

    public RoomService(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    public List<Room> findAll() {
        return roomRepository.findAll();
    }

    public Optional<Room> findById(String id) {
        return roomRepository.findById(id);
    }

    public Room save(Room room) {
        return roomRepository.save(room);
    }

    public Optional<Room> update(Room roomDetails) {
        return roomRepository.findById(roomDetails.getId()).map(room -> {
            room.setRoomNumber(roomDetails.getRoomNumber());
            room.setFloor(roomDetails.getFloor());
            room.setCapacity(roomDetails.getCapacity());
            room.setDescription(roomDetails.getDescription());
            room.setDormId(roomDetails.getDormId());
            return roomRepository.save(room);
        });
    }

    public boolean delete(String id) {
        if (roomRepository.existsById(id)) {
            roomRepository.deleteById(id);
            return true;
        }
        return false;
    }

    // Thêm các method filter đúng với repository
    public List<Room> filterByFloor(int floor) {
        return roomRepository.findByFloor(floor);
    }

    public List<Room> filterByCapacity(int capacity) {
        return roomRepository.findByCapacity(capacity);
    }
}
