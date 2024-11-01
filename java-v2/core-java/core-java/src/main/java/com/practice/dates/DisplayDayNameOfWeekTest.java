package com.practice.dates;

import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;

import java.text.DateFormat;
import java.text.DateFormatSymbols;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.stream.IntStream;

public class DisplayDayNameOfWeekTest {

    @Test
    void displayDayNameOfWeek() {
        DayOfWeek[] days = DayOfWeek.values();

        // [MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY]
        System.out.println(Arrays.deepToString(days));

        /*
         * Day: 0 -> MONDAY
         * Day: 1 -> TUESDAY
         * Day: 2 -> WEDNESDAY
         * Day: 3 -> THURSDAY
         * Day: 4 -> FRIDAY
         * Day: 5 -> SATURDAY
         * Day: 6 -> SUNDAY
         */
        IntStream.range(0, days.length)
                .mapToObj(index -> String.format("Day: %d -> %s", index, days[index]))
                .forEach(System.out::println);

        //returns a Calendar object whose calendar fields have been initialized with the current date and time
        Calendar cal = Calendar.getInstance();
        //creating a constructor of the SimpleDateFormat class
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        //getting current date
        // Today's date: 01-11-2024
        System.out.println("Today's date: " + sdf.format(cal.getTime()));
        //creating a constructor of the Format class
        //displaying full-day name
        Format f = new SimpleDateFormat("EEEE");
        String str = f.format(new Date());
        // Day Name: Friday
        System.out.println("Day Name: " + str);
    }

    /**
     * Before Java 1.8
     * int values are assigned from 1 to 7, whereas 1 is Sunday and 7 is Saturday
     */
    @Test
    void displayDayNameOfWeek_UsingDateFormatSymbols() {
        DateFormatSymbols dateFormatSymbolsDefault = DateFormatSymbols.getInstance();
        DateFormatSymbols dateFormatSymbolsFrench = DateFormatSymbols.getInstance(Locale.FRENCH);
        String[] weekdays = dateFormatSymbolsDefault.getWeekdays();
        String[] weekdaysFrench = dateFormatSymbolsFrench.getWeekdays();

        /*
         * Day: 1 -> Sunday
         * Day: 2 -> Monday
         * Day: 3 -> Tuesday
         * Day: 4 -> Wednesday
         * Day: 5 -> Thursday
         * Day: 6 -> Friday
         * Day: 7 -> Saturday
         */
        IntStream.range(1, weekdays.length)
                .filter(index -> !weekdays[index].isBlank())
                .mapToObj(index -> String.format("Day: %d -> %s", index, weekdays[index]))
                .forEach(System.out::println);

        /*
         * Day: 1 -> dimanche
            Day: 2 -> lundi
            Day: 3 -> mardi
            Day: 4 -> mercredi
            Day: 5 -> jeudi
            Day: 6 -> vendredi
            Day: 7 -> samedi
         */
        IntStream.range(1, weekdaysFrench.length)
                .filter(index -> !weekdaysFrench[index].isBlank())
                .mapToObj(index -> String.format("Day: %d -> %s", index, weekdaysFrench[index]))
                .forEach(System.out::println);

        // get name of specific day
        Calendar calendar = Calendar.getInstance();
        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
        // Friday
        System.out.println(weekdays[dayOfWeek]);
    }

    @Test
    void findNameOfGivenDate() {
        LocalDate localDate = LocalDate.now();
        DayOfWeek dayOfWeek = DayOfWeek.from(localDate);

        // 5
        System.out.println(dayOfWeek.getValue());

        // Friday
        System.out.println(dayOfWeek.getDisplayName(TextStyle.FULL, Locale.ENGLISH));

        // 星期五
        System.out.println(dayOfWeek.getDisplayName(TextStyle.FULL, Locale.CHINESE));

        // vendredi
        System.out.println(dayOfWeek.getDisplayName(TextStyle.FULL, Locale.FRENCH));
    }

    @Test
    void usingGregorianCalendar() {
        Date date = (new GregorianCalendar(2005, Calendar.OCTOBER, 20)).getTime();
        //EEEE represents full day name
        DateFormat dateFormat = new SimpleDateFormat("EEEE");
        String dayName = dateFormat.format(date);
        // Thursday
        System.out.println(dayName);
    }

    @SneakyThrows
    @Test
    void usingSimpleDateFormat() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy", java.util.Locale.ENGLISH);
        Date date= sdf.parse("12/06/2024");
        //specifies the pattern to print
        sdf.applyPattern("EEE, d MMM yyyy");
        String str = sdf.format(date);
        //prints day name with date
        // Wed, 12 Jun 2024
        System.out.println(str);
    }

}
