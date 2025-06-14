package com.example.servingwebcontent.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Student implements Identifiable {

    @Id
    private String studentID;
    private String name;
    private String phoneNumber;
    private String dormRoomID; // ID của phòng ký túc xá đã thuê

    // Constructor
    public Student(String studentID, String name, String phoneNumber, String dormRoomID) {
        this.studentID = studentID;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.dormRoomID = dormRoomID;
    }

    @Override
    public String getID() {
        return studentID;
    }

    public String getStudentID() {
        return studentID;
    }

    public String getDormRoomID() {
        return dormRoomID;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setDormRoomID(String dormRoomID) {
        this.dormRoomID = dormRoomID;
    }

    @Override
    public String toString() {
        return "Student ID: " + studentID + ", Name: " + name + ", Phone: " + phoneNumber + ", Dorm Room: " + dormRoomID;
    }
}
