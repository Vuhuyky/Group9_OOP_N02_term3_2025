package com.yourpackage.app;

public class MainTest {
    public static void main(String[] args) {
        DormRoomService dormRoomService = new DormRoomService();
        StudentService studentService = new StudentService();

        DormRoom room1 = new DormRoom("R001", "Phòng 1", 4);
        dormRoomService.create(room1);

        Student sv1 = new Student("SV01", "Nguyen Van A", "CNTT");
        studentService.create(sv1);

        System.out.println("Danh sách phòng:");
        dormRoomService.getAll().forEach(System.out::println);

        System.out.println("Danh sách sinh viên:");
        studentService.getAll().forEach(System.out::println);
    }
}
