package com.group9oop.dormitorymanagement.controller;

import com.group9oop.dormitorymanagement.model.Room;
import com.group9oop.dormitorymanagement.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
        Optional<Room> opt = roomService.getRoomByNumber(roomNumber);
        return opt
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Room createRoom(@RequestBody Room room) {
        return roomService.addRoom(room);
    }

    @PutMapping("/{roomNumber}")
    public ResponseEntity<Room> updateRoom(@PathVariable String roomNumber,
                                           @RequestBody Room room) {
        Optional<Room> opt = roomService.getRoomByNumber(roomNumber);
        if (opt.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        // gán lại key
        room.setRoomNumber(roomNumber);
        Room updated = roomService.updateRoom(room);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{roomNumber}")
    public ResponseEntity<Void> deleteRoom(@PathVariable String roomNumber) {
        roomService.deleteRoom(roomNumber);
        return ResponseEntity.noContent().build();
    }
}
