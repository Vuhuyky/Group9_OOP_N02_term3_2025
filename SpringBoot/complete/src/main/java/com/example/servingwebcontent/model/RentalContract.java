package com.example.servingwebcontent.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.time.LocalDate;

@Entity
public class RentalContract implements Identifiable {

    @Id
    private String contractID;

    @ManyToOne
    private Student student;

    @ManyToOne
    private DormRoom dormRoom;

    private LocalDate startDate;
    private LocalDate endDate;

    // Constructor
    public RentalContract(String contractID, Student student, DormRoom dormRoom, LocalDate startDate, LocalDate endDate) {
        this.contractID = contractID;
        this.student = student;
        this.dormRoom = dormRoom;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    @Override
    public String getID() {
        return contractID;
    }

    public Student getStudent() {
        return student;
    }

    public DormRoom getDormRoom() {
        return dormRoom;
    }

    public String getContractID() {
        return contractID;
    }

    public String getStudentID() {
        return student.getStudentID();
    }

    public String getDormRoomID() {
        return dormRoom.getDormRoomID().toString();
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    @Override
    public String toString() {
        return "Contract ID: " + contractID + 
               ", Student: " + student.getName() + 
               ", Dorm Room: " + dormRoom.getDormRoomID() + 
               ", Start Date: " + startDate + 
               ", End Date: " + endDate;
    }
}
