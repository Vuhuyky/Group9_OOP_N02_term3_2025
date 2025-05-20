package com.group9oop.dormitorymanagement.model;

public class Student {
    private String id;
    private String fullName;

    public Student(String id, String fullName) {
        this.id = id;
        this.fullName = fullName;
    }

    public void printInfo() {
        System.out.println("ID: " + id + ", Name: " + fullName);
    }

    public Object getId() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getId'");
    }

    public void setFullName(String newName) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setFullName'");
    }

    public String getFullName() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getFullName'");
    }
}
