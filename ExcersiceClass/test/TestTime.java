package ExcersiceClass.test;

import ExcersiceClass.review.Time;

import java.time.LocalDate;

public class TestTime {
    public static void main(String[] args) {
        LocalDate from = LocalDate.of(2024, 12, 1);
        LocalDate to = LocalDate.now();

        System.out.println("Days between: " + Time.daysBetween(from, to));
        System.out.println("Is expired: " + Time.isExpired(from));
    }
}
