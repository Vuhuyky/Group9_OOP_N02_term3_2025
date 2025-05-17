package ExcersiceClass.test;

import ExcersiceClass.review.User;

public class TestUser {
     public static void main(String[] args) {
        User u = new User("Nguyen Van A", "a@example.com", "0123456789", "student");
        System.out.println(u);
        u.setPhoneNumber("0987654321");
        System.out.println("Updated phone: " + u.getPhoneNumber());
    }
}
