package dates;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class Main {
    
    public static void main(String[] args) {
        LocalDate today = LocalDate.now();
        System.out.println("Today: " + today);
        System.out.println("Year: " + today.getYear());
        System.out.println("Month: " + today.getMonth());
        System.out.println("DayOfYear: " + today.getDayOfYear());
        System.out.println("DayofMonth: " + today.getDayOfMonth());
        System.out.println("DayofWeek: " + today.getDayOfWeek());
        System.out.println("IsLeapYear? " + today.isLeapYear());

        LocalTime time = LocalTime.now();
        System.out.println("\nTime: " + time);
        System.out.println("Hour: " + time.getHour());
        System.out.println("Minutes: " + time.getMinute());
        System.out.println("Seconds: " + time.getSecond());

        LocalDateTime dateTime = LocalDateTime.now();
        System.out.println("\nDate Time: " + dateTime);
        System.out.println(dateTime.getYear());
        System.out.println(dateTime.getMonth());
        System.out.println(dateTime.getDayOfMonth());
        System.out.println(dateTime.getHour());
        System.out.println(dateTime.getMinute());
    }
}
