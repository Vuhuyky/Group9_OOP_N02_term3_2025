package models;

import java.time.LocalDate;

public class RentalContract implements Identifiable {
    private String contractID;
    private Student student;
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

    // Getter cho student, dormRoom, startDate, endDate
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
        return dormRoom.getDormRoomID();
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
