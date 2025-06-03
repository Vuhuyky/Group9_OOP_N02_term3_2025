package com.example.dormmanagement.repository;

import com.example.dormmanagement.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoomRepository extends JpaRepository<Room, String> {

    List<Room> findByFloor(int floor);

    List<Room> findByCapacity(int capacity);
}
