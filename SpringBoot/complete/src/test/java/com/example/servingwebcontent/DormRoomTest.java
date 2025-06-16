package com.example.servingwebcontent.test;

import com.example.servingwebcontent.model.DormRoom;
import com.example.servingwebcontent.service.DormRoomService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class DormRoomServiceTest {

    @Autowired
    private DormRoomService dormRoomService;

    @Test
    public void testCreateDormRoom() {
        DormRoom dormRoom = new DormRoom("D001", 1000, "Building A", "available");
        dormRoomService.createDormRoom(dormRoom);

        // Kiểm tra xem phòng đã được thêm vào hệ thống hay chưa
        assertNotNull(dormRoomService.listAllDormRooms());
    }

    @Test
    public void testUpdateDormRoom() {
        DormRoom dormRoom = new DormRoom("D001", 1000, "Building A", "available");
        dormRoomService.createDormRoom(dormRoom);

        dormRoom.setRoomStatus("occupied");
        dormRoomService.updateDormRoom(dormRoom.getID(), dormRoom);

        // Kiểm tra xem trạng thái phòng đã được cập nhật chưa
        assertEquals("occupied", dormRoom.getRoomStatus());
    }

    @Test
    public void testDeleteDormRoom() {
        DormRoom dormRoom = new DormRoom("D001", 1000, "Building A", "available");
        dormRoomService.createDormRoom(dormRoom);
        dormRoomService.deleteDormRoom(dormRoom.getID());

        // Kiểm tra xem phòng đã bị xóa chưa
        assertTrue(dormRoomService.listAllDormRooms().isEmpty());
    }
}
