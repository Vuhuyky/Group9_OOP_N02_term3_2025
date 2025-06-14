package com.example.servingwebcontent.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
public class DormRoom implements Identifiable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long dormRoomID;  // ID tự động tăng

    private double price;
    private String building;
    private String roomStatus;  // "available" or "occupied"
    private String studentID;  // Sinh viên hiện tại nếu có

    // Constructor
    public DormRoom(String dormRoomID, double price, String building, String roomStatus) {
        this.dormRoomID = dormRoomID;
        this.price = price;
        this.building = building;
        this.roomStatus = roomStatus;
        this.studentID = null;  // Chưa có sinh viên
    }

    @Override
    public String getID() {
        return dormRoomID.toString();
    }

    public String getRoomStatus() {
        return roomStatus;
    }

    public void setRoomStatus(String roomStatus) {
        this.roomStatus = roomStatus;
    }

    public String getStudentID() {
        return studentID;
    }

    public void assignStudent(String studentID) {
        if (this.roomStatus.equals("available")) {
            this.studentID = studentID;
            this.roomStatus = "occupied";  // Cập nhật trạng thái phòng
        } else {
            System.out.println("Phòng đã có người thuê.");
        }
    }

    public void removeStudent() {
        this.studentID = null;
        this.roomStatus = "available";  // Cập nhật lại trạng thái phòng
    }

    @Override
    public String toString() {
        return "Room ID: " + dormRoomID + ", Price: " + price + ", Building: " + building + ", Status: " + roomStatus;
    }

    // Thêm phương thức getDormRoomID để tương thích với lớp RentalContract
    public Long getDormRoomID() {
        return dormRoomID;
    }
}
