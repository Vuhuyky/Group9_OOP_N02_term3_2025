package com.example.dormmanagement.model;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

/**
 * Đối tượng Sinh viên (Student) trong ký túc xá.
 */
@Entity
@Table(name = "students")
public class Student extends BaseEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Column(name = "name", nullable = false, length = 100)
    private String name;           // Tên sinh viên

    @Column(name = "major", length = 100)
    private String major;          // Chuyên ngành

    @Column(name = "birth_date")
    private LocalDate birthDate;   // Ngày sinh

    @Column(name = "phone_number", length = 20)
    private String phoneNumber;    // Số điện thoại

    @Column(name = "email", length = 100)
    private String email;          // Email

    @Column(name = "room_id", length = 36)
    private String roomId;         // Id của Room (liên kết N-1)

    @Column(name = "check_in_date")
    private LocalDate checkInDate; // Ngày check-in

    @Column(name = "check_out_date")
    private LocalDate checkOutDate;// Ngày check-out

    @Column(name = "is_checked_in")
    private boolean isCheckedIn;   // Trạng thái đã check-in hay chưa

    public Student() {
        super();
    }

    public Student(String id, String name, String major, LocalDate birthDate,
                   String phoneNumber, String email, String roomId,
                   LocalDate checkInDate, LocalDate checkOutDate, boolean isCheckedIn) {
        super();
        this.id = id;  // Gán id thủ công (MSSV)
        this.name = name;
        this.major = major;
        this.birthDate = birthDate;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.roomId = roomId;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.isCheckedIn = isCheckedIn;
    }

    // Getters & Setters

    @Override
    public String getId() {
        return id;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

    public LocalDate getCheckInDate() {
        return checkInDate;
    }

    public void setCheckInDate(LocalDate checkInDate) {
        this.checkInDate = checkInDate;
    }

    public LocalDate getCheckOutDate() {
        return checkOutDate;
    }

    public void setCheckOutDate(LocalDate checkOutDate) {
        this.checkOutDate = checkOutDate;
    }

    public boolean isCheckedIn() {
        return isCheckedIn;
    }

    public void setCheckedIn(boolean checkedIn) {
        isCheckedIn = checkedIn;
    }
}
