package com.example.dormmanagement.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Đối tượng Phòng (Room) trong ký túc xá.
 */
@Entity
@Table(name = "rooms")
public class Room extends BaseEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Column(name = "room_number", nullable = false, unique = true, length = 50)
    private String roomNumber;   // Mã phòng (ví dụ: "A101")

    @Column(name = "floor")
    private int floor;           // Tầng

    @Column(name = "capacity")
    private int capacity;        // Sức chứa tối đa

    @Column(name = "description", length = 255)
    private String description;  // Mô tả phòng (tuỳ chọn)

    @Column(name = "dorm_id", length = 36)
    private String dormId;       // Id của Dorm (liên kết N-1, lưu String)

    public Room() {
        super();
    }

    public Room(String roomNumber,
                int floor,
                int capacity,
                String description,
                String dormId) {
        super();
        this.roomNumber = roomNumber;
        this.floor = floor;
        this.capacity = capacity;
        this.description = description;
        this.dormId = dormId;
    }

    public Room(String id,
                String roomNumber,
                int floor,
                int capacity,
                String description,
                String dormId) {
        this.roomNumber = roomNumber;
        this.floor = floor;
        this.capacity = capacity;
        this.description = description;
        this.dormId = dormId;
        this.id = (id != null) ? id : this.id;
    }

    // ==== Getters & Setters ====

    @Override
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDormId() {
        return dormId;
    }

    public void setDormId(String dormId) {
        this.dormId = dormId;
    }
}
