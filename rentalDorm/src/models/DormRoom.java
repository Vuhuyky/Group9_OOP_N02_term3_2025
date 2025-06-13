package models;

public class DormRoom implements Identifiable {
    private String dormRoomID;
    private double price;
    private String building;
    private String roomStatus; // "available" or "occupied"
    private String studentID; // Sinh viên hiện tại nếu có

    // Constructor
    public DormRoom(String dormRoomID, double price, String building, String roomStatus) {
        this.dormRoomID = dormRoomID;
        this.price = price;
        this.building = building;
        this.roomStatus = roomStatus;
        this.studentID = null; // Chưa có sinh viên
    }

    @Override
    public String getID() {
        return dormRoomID;
    }

    // Getter cho dormRoomID
    public String getDormRoomID() {
        return dormRoomID;
    }

    // Getter cho các thuộc tính khác
    public double getPrice() {
        return price;
    }

    public String getBuilding() {
        return building;
    }

    public String getRoomStatus() {
        return roomStatus;
    }

    public String getStudentID() {
        return studentID;
    }

    public void setRoomStatus(String roomStatus) {
        this.roomStatus = roomStatus;
    }

    public void assignStudent(String studentID) {
        if (this.roomStatus.equals("available")) {
            this.studentID = studentID;
            this.roomStatus = "occupied"; // Cập nhật trạng thái phòng
        } else {
            System.out.println("Phòng đã có người thuê.");
        }
    }

    public void removeStudent() {
        this.studentID = null;
        this.roomStatus = "available"; // Cập nhật lại trạng thái phòng
    }

    @Override
    public String toString() {
        return "Room ID: " + dormRoomID + ", Price: " + price + ", Building: " + building + ", Status: " + roomStatus;
    }
}
