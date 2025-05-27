    package com.group9oop.dormitorymanagement.service;

    import com.group9oop.dormitorymanagement.model.Room;
    import com.group9oop.dormitorymanagement.model.Student;
    import org.springframework.stereotype.Service;

    import java.util.ArrayList;
    import java.util.List;
    import java.util.Optional;

    @Service
    public class RoomService {

        private List<Room> rooms = new ArrayList<>();

        // Thêm phòng mới
        public Room addRoom(Room room) {
            rooms.add(room);
            return room;
        }

        // Xóa phòng theo số phòng
        public void deleteRoom(String roomNumber) {
            rooms.removeIf(r -> r.getRoomNumber().equals(roomNumber));
        }

        // Tìm phòng theo số phòng
        public Optional<Room> getRoomByNumber(String roomNumber) {
            return rooms.stream()
                    .filter(r -> r.getRoomNumber().equals(roomNumber))
                    .findFirst();
        }

        // Gán sinh viên vào phòng (nếu phòng chưa đầy)
        public boolean assignStudentToRoom(Student student, String roomNumber) {
            Optional<Room> roomOpt = getRoomByNumber(roomNumber);
            if (roomOpt.isPresent()) {
                Room room = roomOpt.get();
                return room.addStudent(student);
            }
            return false;
        }

        // Lấy danh sách tất cả phòng
        public List<Room> getAllRooms() {
            return rooms;
        }
        public Room updateRoom(Room updatedRoom) {
        for (int i = 0; i < rooms.size(); i++) {
        if (rooms.get(i).getRoomNumber().equals(updatedRoom.getRoomNumber())) {
            rooms.set(i, updatedRoom);
            return updatedRoom;
                 }
            }
        return null;
        }

    }

