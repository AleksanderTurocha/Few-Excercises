package DateAndTime;

import java.time.LocalDate;
import java.time.Period;
import java.util.Scanner;

public class DateComparer {
    public static void main(String[] args) {
        LocalDate firstDate = createDate();
        LocalDate secondDate = createDate();

        showPeriodBetween(firstDate, secondDate);
        showLaterDate(firstDate, secondDate);
    }

    private static LocalDate createDate() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input day of the month: ");
        int day = scanner.nextInt();
        System.out.println("Input month: ");
        int month = scanner.nextInt();
        System.out.println("Input year: ");
        int year = scanner.nextInt();
        return LocalDate.of(year, month, day);
    }

    private static void showPeriodBetween(LocalDate date1, LocalDate date2) {
        Period between = Period.between(date1, date2);
        int days = Math.abs(between.getDays());
        int months = Math.abs(between.getMonths());
        int years = Math.abs(between.getYears());
        System.out.printf("Those dates differ with %d days, %d months and %d years", days, months, years);
    }

    private static void showLaterDate(LocalDate date1, LocalDate date2) {
        LocalDate laterDate = date1.isAfter(date2) ? date1 : date2;
        System.out.println(laterDate);
    }
}
