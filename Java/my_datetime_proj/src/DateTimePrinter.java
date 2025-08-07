package my_datetime_proj.src;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZonedDateTime;

public class DateTimePrinter {
    public static void main(String[] args) {
        System.out.println("The date is: "+ LocalDate.now());
        System.out.println("The time is: "+ LocalTime.now());
        System.out.println("The datetime is: "+ LocalDateTime.now());
        System.out.println("The zoned datetime is: "+ ZonedDateTime.now());
    }
}
