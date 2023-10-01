package kae.coding.yandex.cup2020.qualification;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

enum TimePeriod {
  WEEK,
  MONTH,
  QUARTER,
  YEAR,
  FEBRUARY_THE_29TH
}

/**
 * Миша работает в команде Яндекс.Маркета, которая предоставляет производителям товаров аналитику о
 * продажах. Сейчас Миша разбирается с периодизацией: нужно собирать данные по дням, неделям,
 * месяцам, кварталам и годам. От клиентов приходят запросы, в которых указан период детализации и
 * интервал: начальная и конечная даты. Так что первоначально Мише нужно разбить интервал на
 * периоды. Так, если клиент хочет данные с 2020-01-10 по 2020-03-25 с детализацией по месяцам, то
 * ему вернутся данные за три периода: c 2020-01-10 по 2020-01-31, с 2020-02-01 по 2020-02-29 и с
 * 2020-03-01 по 2020-03-25. Помогите Мише, а то ему еще диплом писать надо! Всего нужно поддержать
 * пять видов временных интервалов:
 *
 * <p>WEEK — неделя с понедельника по воскресенье. MONTH — месяц. QUARTER — интервалы в три месяца:
 * январь — март, апрель — июнь, июль — сентябрь, октябрь — декабрь. YEAR — год c 1 января по 31
 * декабря. FEBRUARY_THE_29TH — интервал с пятницы 13-го по ближайший четверг 12-го.
 */
public class TimeIntervals {

  public static void main(String[] args) throws IOException {
    try (Scanner scanner = getScanner(args);
        PrintWriter writer = getWriter(args)) {
      TimePeriod timePeriod = TimePeriod.valueOf(scanner.nextLine());
      String[] dates = scanner.nextLine().split(" ");
      LocalDate start = LocalDate.parse(dates[0]);
      LocalDate end = LocalDate.parse(dates[1]);

      List<LocalDate[]> intervals = getIntervals(timePeriod, start, end);

      writer.println(intervals.size());
      for (LocalDate[] interval : intervals) {
        writer.print(interval[0]);
        writer.print(" ");
        writer.println(interval[1]);
      }
    }
  }

  static List<LocalDate[]> getIntervals(TimePeriod timePeriod, LocalDate start, LocalDate end) {
    List<LocalDate[]> intervals = new ArrayList<>();
    for (LocalDate localDate = start; localDate.isBefore(end) || localDate.isEqual(end); ) {
      LocalDate[] interval = new LocalDate[2];
      intervals.add(interval);

      interval[0] = localDate;
      localDate = min(endOfPeriod(localDate, timePeriod), end);

      interval[1] = localDate;

      localDate = localDate.plusDays(1);
    }
    return intervals;
  }

  private static LocalDate min(LocalDate date1, LocalDate date2) {
    return date1.isBefore(date2) || date1.isEqual(date2) ? date1 : date2;
  }

  private static LocalDate endOfPeriod(LocalDate localDate, TimePeriod timePeriod) {
    switch (timePeriod) {
      case WEEK:
        return localDate.with(DayOfWeek.SUNDAY);
        //        return localDate.with(WeekFields.of(new Locale("ru")).dayOfWeek(), 7L);
      case MONTH:
        return localDate.withDayOfMonth(localDate.lengthOfMonth());
      case QUARTER:
        return localDate
            .withDayOfMonth(localDate.lengthOfMonth())
            .withMonth(endMonthOfQuarter(localDate));
      case YEAR:
        return localDate.withDayOfYear(localDate.lengthOfYear());
      case FEBRUARY_THE_29TH:
        return nextLeapDate(localDate);
    }
    return localDate;
  }

  private static int endMonthOfQuarter(LocalDate localDate) {
    switch (localDate.getMonth()) {
      case JANUARY:
      case FEBRUARY:
      case MARCH:
        return Month.MARCH.getValue();
      case APRIL:
      case MAY:
      case JUNE:
        return Month.JUNE.getValue();
      case JULY:
      case AUGUST:
      case SEPTEMBER:
        return Month.SEPTEMBER.getValue();
      case OCTOBER:
      case NOVEMBER:
      case DECEMBER:
        return Month.DECEMBER.getValue();
    }
    return 0;
  }

  private static LocalDate nextLeapDate(LocalDate localDate) {
    LocalDate leapDate = localDate.withMonth(Month.FEBRUARY.getValue()).withDayOfMonth(28);

    if (localDate.isLeapYear()) {
      if (localDate.isBefore(leapDate) || localDate.isEqual(leapDate)) {
        return leapDate;
      }
      leapDate = leapDate.plusYears(1);
    }

    while (!leapDate.isLeapYear()) {
      leapDate = leapDate.plusYears(1);
    }

    return leapDate;
  }

  private static Scanner getScanner(String[] args) throws IOException {
    return args.length > 0 ? new Scanner(Paths.get(args[0])) : new Scanner(System.in);
  }

  private static PrintWriter getWriter(String[] args) throws FileNotFoundException {
    return args.length > 1
        ? new PrintWriter(new OutputStreamWriter(new FileOutputStream(args[1])))
        : new PrintWriter(System.out);
  }
}
