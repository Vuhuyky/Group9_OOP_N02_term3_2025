package ExcersiceClass.review;

public class Recursion {
    public static double calculateRoomFee(int months, double monthlyRate) {
        if (months <= 0) return 0;
        return monthlyRate + calculateRoomFee(months - 1, monthlyRate);
    }

    public static int factorial(int n) {
        if (n == 1) return 1;
        return n * factorial(n - 1);
    }
}
