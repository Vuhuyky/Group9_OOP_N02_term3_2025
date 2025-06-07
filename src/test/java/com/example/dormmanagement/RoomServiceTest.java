package com.example.dormmanagement;

import com.example.dormmanagement.model.Room;
import com.example.dormmanagement.repository.RoomRepository;
import com.example.dormmanagement.service.RoomService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
public class RoomServiceTest {

    @Autowired
    private RoomRepository roomRepository;

    @AfterEach
    public void cleanup() {
        roomRepository.deleteAll();
    }

    @Test
    public void testSaveAndFindAll() {
        RoomService roomService = new RoomService(roomRepository);

        // Tạo Room
        Room r1 = new Room("A101", 1, 2, "Phòng 2 giường", null);
        Room saved = roomService.save(r1);

        assertNotNull(saved.getId());

        List<Room> all = roomService.findAll();
        assertEquals(1, all.size());
        assertEquals("A101", all.get(0).getRoomNumber());
    }
}

