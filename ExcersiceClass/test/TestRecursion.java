package ExcersiceClass.test;

import ExcersiceClass.review.Recursion;

public class TestRecursion {
    public static void main(String[] args) {
        double total = Recursion.calculateRoomFee(3, 500000);
        System.out.println("Total room fee for 3 months: " + total);

        int result = Recursion.factorial(5);
        System.out.println("Factorial(5): " + result);
    }
}
