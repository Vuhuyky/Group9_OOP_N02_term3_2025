package ExcersiceClass.review;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Time {
    public static long daysBetween(LocalDate start, LocalDate end) {
        return ChronoUnit.DAYS.between(start, end);
    }

    public static boolean isExpired(LocalDate dueDate) {
        return LocalDate.now().isAfter(dueDate);
    }

    public static long daysUntilNow(LocalDate past) {
        return ChronoUnit.DAYS.between(past, LocalDate.now());
    }
}
