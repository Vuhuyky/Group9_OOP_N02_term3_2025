package com.group9oop.dormitorymanagement.model;


import java.util.ArrayList;
import java.util.List;

public class Room {
    private String roomNumber;
    private int capacity;
    private List<Student> students; // Danh sách sinh viên trong phòng

    public Room(String roomNumber, int capacity) {
        this.roomNumber = roomNumber;
        this.capacity = capacity;
        this.students = new ArrayList<>();
    }

    public boolean addStudent(Student student) {
        if (students.size() < capacity) {
            students.add(student);
            return true;
        }
        return false;
    }

    public boolean removeStudent(Student student) {
        return students.remove(student);
    }

    public boolean isFull() {
        return students.size() >= capacity;
    }

    public String getRoomNumber() {
        return roomNumber;
    }
    public void setRoomNumber(String roomNumber) {
    this.roomNumber = roomNumber;
    }

    public int getCapacity() {
        return capacity;
    }

    public List<Student> getStudents() {
        return students;
    }
}
