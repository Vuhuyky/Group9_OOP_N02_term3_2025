package com.example.dormmanagement.controller;

import com.example.dormmanagement.exception.ResourceNotFoundException;
import com.example.dormmanagement.model.Room;
import com.example.dormmanagement.service.RoomService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rooms")
public class RoomController {

    private final RoomService roomService;

    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    @GetMapping
    public ResponseEntity<List<Room>> getAllRooms() {
        return ResponseEntity.ok(roomService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Room> getRoomById(@PathVariable String id) {
        Room room = roomService.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Room id " + id + " không tồn tại"));
        return ResponseEntity.ok(room);
    }

    @PostMapping
    public ResponseEntity<Room> createRoom(@RequestBody Room room) {
        Room saved = roomService.save(room);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Room> updateRoom(
            @PathVariable String id,
            @RequestBody Room roomDetails
    ) {
        roomDetails.setId(id);
        Room updated = roomService.update(roomDetails)
            .orElseThrow(() -> new ResourceNotFoundException("Room id " + id + " không tồn tại"));
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRoom(@PathVariable String id) {
        boolean deleted = roomService.delete(id);
        if (deleted) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/filter")
    public ResponseEntity<List<Room>> filterRooms(
            @RequestParam(required = false) Integer floor,
            @RequestParam(required = false) Integer capacity
    ) {
        if (floor != null) {
            return ResponseEntity.ok(roomService.filterByFloor(floor));
        } else if (capacity != null) {
            return ResponseEntity.ok(roomService.filterByCapacity(capacity));
        }
        return ResponseEntity.ok(roomService.findAll());
    }
}
