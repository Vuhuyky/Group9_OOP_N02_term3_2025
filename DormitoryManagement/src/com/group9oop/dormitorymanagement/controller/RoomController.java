package com.group9oop.dormitorymanagement.controller;

import com.group9oop.dormitorymanagement.model.Room;
import com.group9oop.dormitorymanagement.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rooms")
public class RoomController {

    @Autowired
    private RoomService roomService;

    @GetMapping
    public List<Room> getAllRooms() {
        return roomService.getAllRooms();
    }

    @GetMapping("/{roomNumber}")
    public ResponseEntity<Room> getRoomByNumber(@PathVariable String roomNumber) {
        return roomService.getRoomByNumber(roomNumber)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Room createRoom(@RequestBody Room room) {
        return roomService.addRoom(room);
    }

    @PutMapping("/{roomNumber}")
    public ResponseEntity<Room> updateRoom(@PathVariable String roomNumber, @RequestBody Room room) {
        return roomService.getRoomByNumber(roomNumber)
                .map(existing -> {
                    room.setRoomNumber(roomNumber);
                    return ResponseEntity.ok(roomService.updateRoom(room));
                }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{roomNumber}")
    public ResponseEntity<Void> deleteRoom(@PathVariable String roomNumber) {
        roomService.deleteRoom(roomNumber);
        return ResponseEntity.noContent().build();
    }
}
