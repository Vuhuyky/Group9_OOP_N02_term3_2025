package com.group9oop.dormitorymanagement.service;

import com.group9oop.dormitorymanagement.model.Room;
import com.group9oop.dormitorymanagement.model.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RoomService {

    private final List<Room> rooms = new ArrayList<>();

    // Thêm phòng mới
    public Room addRoom(Room room) {
        rooms.add(room);
        return room;
    }

    // Cập nhật phòng (xóa cũ, thêm bản mới)
    public Room updateRoom(Room room) {
        deleteRoom(room.getRoomNumber());
        rooms.add(room);
        return room;
    }

    // Xóa phòng theo roomNumber
    public void deleteRoom(String roomNumber) {
        rooms.removeIf(r -> r.getRoomNumber().equals(roomNumber));
    }

    // Tìm phòng theo roomNumber
    public Optional<Room> getRoomByNumber(String roomNumber) {
        return rooms.stream()
                .filter(r -> r.getRoomNumber().equals(roomNumber))
                .findFirst();
    }

    // Lấy danh sách tất cả phòng
    public List<Room> getAllRooms() {
        return rooms;
    }

    // Gán sinh viên vào phòng nếu chưa đầy
    public boolean assignStudentToRoom(Student student, String roomNumber) {
        return getRoomByNumber(roomNumber)
                .map(r -> r.addStudent(student))
                .orElse(false);
    }
}
