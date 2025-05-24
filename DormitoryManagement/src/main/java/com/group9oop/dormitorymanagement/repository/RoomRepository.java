package com.group9oop.dormitorymanagement.repository;

import com.group9oop.dormitorymanagement.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepository extends JpaRepository<Room, String> {
    // Bạn có thể thêm các phương thức tìm phòng theo điều kiện nếu cần
}
