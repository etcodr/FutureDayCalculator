package ies.business;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class CalendarCalculations {
    public static long calculateFutureDays(LocalDate startDate, LocalDate endDate) {
        long weekDays = 0;
        while (startDate.isBefore(endDate)) {
            startDate = startDate.plus(1, ChronoUnit.DAYS);
            if (!(startDate.getDayOfWeek() == DayOfWeek.SATURDAY ||
                    startDate.getDayOfWeek() == DayOfWeek.SUNDAY)) {
                ++weekDays;
            }
        }
        return weekDays;
    }

    public static long calculateFutureDays(LocalDate startDate, int daysOut) {
        long weekDays = 0;
        int counter = 0;
        while (counter < daysOut) {
            startDate = startDate.plus(1, ChronoUnit.DAYS);
            if (!(startDate.getDayOfWeek() == DayOfWeek.SATURDAY ||
                    startDate.getDayOfWeek() == DayOfWeek.SUNDAY)) {
                ++weekDays;
            }
            ++counter;
        }
        return weekDays;
    }
}
