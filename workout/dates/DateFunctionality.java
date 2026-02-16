package dates;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class DateFunctionality {
    public static void main(String[] args) {
        LocalDate today = LocalDate.now();

        System.out.println("Current Date: " + today);
        System.out.println("\nYear + 5 Years =>  " + today.plusYears(5));
        System.out.println("Year - 10 Years =>  " + today.minusYears(10));
        System.out.println("\nDate + 5 days =>  " + today.plusDays(5));
        System.out.println("Date - 10 days =>  " + today.minusDays(10));
        System.out.println("\nMonth + 5 months =>  " + today.plusMonths(5));
        System.out.println("Month - 10 months =>  " + today.minusMonths(10));

        String date = "01-01-2026";

        System.out.println("\nBefore Formatting: " + today);
        DateTimeFormatter df = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        System.out.println("After Formatting: " + today.format(df));
        LocalDate newDate = LocalDate.parse(date , df); 
        System.out.println("New Date after parsing: " + newDate);

        
        LocalDate d1 = LocalDate.of(2004, 6, 23);
        LocalDate d2 = LocalDate.now();

        Period p = Period.between(d1, d2);
        System.out.println("\nPeriod gap between " + d1.getYear() + " and " + d2.getYear() + " is " + p.getYears());
        System.out.println("\nPeriod gap month between " + d1.getYear() + " and " + d2.getYear() + " is " + p.getMonths());
        System.out.println("\nPeriod gap day between " + d1.getYear() + " and " + d2.getYear() + " is " + p.getDays());

        LocalTime time = LocalTime.now();
        LocalTime time1 = LocalTime.of(10, 30, 30);

        System.out.println("\nTime: " + time);
        System.out.println("Time + 2 Hours => " + time.plusHours(2));
        System.out.println("Time + 2 Minutes => " + time.plusMinutes(2));
        System.out.println("Time + 2 Seconds => " + time.plusSeconds(2));
        
        System.out.println("\nIsBefore of " + time + " and " + time1 + " " +  time.isBefore(time1));
        System.out.println("IsAfter " + time + " and " + time1 + " " + time.isAfter(time1));
        
        System.out.println("\nMidnight Time: " + time.MIDNIGHT);
        System.out.println("Maximum Time: " + time.MAX);
        System.out.println("Minimum Time: " + time.MIN);
        System.out.println("Afternoon Time: " + time.NOON);

        
        time1 = time.plusHours(2);
        Duration d = Duration.between(time, time1);
        System.out.print(d.toHours());
        
    }   
}
