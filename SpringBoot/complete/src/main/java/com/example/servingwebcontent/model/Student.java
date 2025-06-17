package com.example.servingwebcontent.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import java.time.LocalDate;

@Entity
public class Student {
    @Id
    @Column(name = "student_id")
    private String studentID;
    private String name;
    private String phoneNumber;
    private String cccd;
    private String address;
    private String className;
    private String faculty;
    private String gender;
    private LocalDate dob;
    private String dormRoomID; // Chỉ lưu roomId, không phải đối tượng DormRoom
    private String status;

    public Student() {}

    public Student(String studentID, String name, String phoneNumber, String dormRoomID) {
        this.studentID = studentID;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.dormRoomID = dormRoomID;
    }

    // Getter & Setter cho tất cả các trường
    public String getStudentID() { return studentID; }
    public void setStudentID(String studentID) { this.studentID = studentID; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getPhoneNumber() { return phoneNumber; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }

    public String getCccd() { return cccd; }
    public void setCccd(String cccd) { this.cccd = cccd; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    public String getClassName() { return className; }
    public void setClassName(String className) { this.className = className; }

    public String getFaculty() { return faculty; }
    public void setFaculty(String faculty) { this.faculty = faculty; }

    public String getGender() { return gender; }
    public void setGender(String gender) { this.gender = gender; }

    public LocalDate getDob() { return dob; }
    public void setDob(LocalDate dob) { this.dob = dob; }

    public String getDormRoomID() { return dormRoomID; }
    public void setDormRoomID(String dormRoomID) { this.dormRoomID = dormRoomID; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}