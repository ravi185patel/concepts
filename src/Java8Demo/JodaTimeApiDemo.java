package Java8Demo;

import java.time.*;

public class JodaTimeApiDemo {
    public static void main(String[] args) {
        LocalDate d = LocalDate.now();
        System.out.println(d);
        // get day month year.
        System.out.println(d.getDayOfMonth());
        System.out.println(d.getDayOfWeek());
        System.out.println(d.getDayOfYear());

        System.out.println(d.getMonthValue());
        System.out.println(d.getMonth());

        System.out.println(d.getYear());
        System.out.println("year is leap year " + Year.isLeap(d.getYear()));
        // get time
        LocalTime l = LocalTime.now();
        System.out.println(l);

        System.out.println(l.getHour());
        System.out.println(l.getMinute());
        System.out.println(l.getSecond());

        LocalDateTime dt = LocalDateTime.now();
        System.out.println(dt);

        // represent Zone
        ZoneId zone = ZoneId.systemDefault();
        System.out.println(zone);

        ZoneId la = ZoneId.of("America/Los_Angeles");
        ZonedDateTime zt = ZonedDateTime.now(la);
        System.out.println(zt);

        // period
        LocalDate today = LocalDate.now();
        LocalDate birthday = LocalDate.of(1990, 03, 14);
        Period p = Period.between(birthday, today);
        System.out.printf("age is %d year %d months %d days", p.getYears(), p.getMonths(), p.getDays());
    }
}
