package kae.study.codingchallenges.yandex.cup2020.qualification;

import static com.google.common.truth.Truth.assertThat;

import java.time.LocalDate;
import java.util.List;
import org.junit.Test;

/** */
public class TimeIntervalsTest {

  @Test
  public void test1() {
    List<LocalDate[]> intervals =
        TimeIntervals.getIntervals(
            TimePeriod.MONTH, LocalDate.parse("2020-01-10"), LocalDate.parse("2020-03-25"));

    assertThat(intervals.size()).isEqualTo(3);
    assertThat(intervals.get(0))
        .isEqualTo(new LocalDate[] {LocalDate.parse("2020-01-10"), LocalDate.parse("2020-01-31")});
    assertThat(intervals.get(1))
        .isEqualTo(new LocalDate[] {LocalDate.parse("2020-02-01"), LocalDate.parse("2020-02-29")});
    assertThat(intervals.get(2))
        .isEqualTo(new LocalDate[] {LocalDate.parse("2020-03-01"), LocalDate.parse("2020-03-25")});
  }

  @Test
  public void test2() {
    List<LocalDate[]> intervals =
        TimeIntervals.getIntervals(
            TimePeriod.FEBRUARY_THE_29TH,
            LocalDate.parse("2010-01-01"),
            LocalDate.parse("2020-12-31"));

    assertThat(intervals.size()).isEqualTo(4);
    assertThat(intervals.get(0))
        .isEqualTo(new LocalDate[] {LocalDate.parse("2010-01-01"), LocalDate.parse("2012-02-28")});
    assertThat(intervals.get(1))
        .isEqualTo(new LocalDate[] {LocalDate.parse("2012-02-29"), LocalDate.parse("2016-02-28")});
    assertThat(intervals.get(2))
        .isEqualTo(new LocalDate[] {LocalDate.parse("2016-02-29"), LocalDate.parse("2020-02-28")});
    assertThat(intervals.get(3))
        .isEqualTo(new LocalDate[] {LocalDate.parse("2020-02-29"), LocalDate.parse("2020-12-31")});
  }


  @Test
  public void test3() {
    List<LocalDate[]> intervals =
        TimeIntervals.getIntervals(
            TimePeriod.MONTH, LocalDate.parse("2020-01-31"), LocalDate.parse("2020-01-31"));

    assertThat(intervals.size()).isEqualTo(1);
    assertThat(intervals.get(0))
        .isEqualTo(new LocalDate[] {LocalDate.parse("2020-01-31"), LocalDate.parse("2020-01-31")});
  }


  @Test
  public void test4() {
    List<LocalDate[]> intervals =
        TimeIntervals.getIntervals(
            TimePeriod.MONTH, LocalDate.parse("2020-03-31"), LocalDate.parse("2020-04-01"));

    assertThat(intervals.size()).isEqualTo(2);
    assertThat(intervals.get(0))
        .isEqualTo(new LocalDate[] {LocalDate.parse("2020-03-31"), LocalDate.parse("2020-03-31")});
    assertThat(intervals.get(1))
        .isEqualTo(new LocalDate[] {LocalDate.parse("2020-04-01"), LocalDate.parse("2020-04-01")});
  }


  @Test
  public void test5() {
    List<LocalDate[]> intervals =
        TimeIntervals.getIntervals(
            TimePeriod.QUARTER, LocalDate.parse("2020-03-31"), LocalDate.parse("2020-04-01"));

    assertThat(intervals.size()).isEqualTo(2);
    assertThat(intervals.get(0))
        .isEqualTo(new LocalDate[] {LocalDate.parse("2020-03-31"), LocalDate.parse("2020-03-31")});
    assertThat(intervals.get(1))
        .isEqualTo(new LocalDate[] {LocalDate.parse("2020-04-01"), LocalDate.parse("2020-04-01")});
  }


  @Test
  public void test6() {
    List<LocalDate[]> intervals =
        TimeIntervals.getIntervals(
            TimePeriod.FEBRUARY_THE_29TH, LocalDate.parse("2020-02-29"), LocalDate.parse("2020-02-29"));

    assertThat(intervals.size()).isEqualTo(1);
    assertThat(intervals.get(0))
        .isEqualTo(new LocalDate[] {LocalDate.parse("2020-02-29"), LocalDate.parse("2020-02-29")});
  }


  @Test
  public void test7() {
    List<LocalDate[]> intervals =
        TimeIntervals.getIntervals(
            TimePeriod.FEBRUARY_THE_29TH, LocalDate.parse("2020-02-28"), LocalDate.parse("2020-02-29"));
    assertThat(intervals.size()).isEqualTo(2);
    assertThat(intervals.get(0))
        .isEqualTo(new LocalDate[] {LocalDate.parse("2020-02-28"), LocalDate.parse("2020-02-28")});
    assertThat(intervals.get(1))
        .isEqualTo(new LocalDate[] {LocalDate.parse("2020-02-29"), LocalDate.parse("2020-02-29")});
  }

  @Test
  public void test8() {
    List<LocalDate[]> intervals =
        TimeIntervals.getIntervals(
            TimePeriod.WEEK, LocalDate.parse("2020-10-18"), LocalDate.parse("2020-10-25"));
    assertThat(intervals.size()).isEqualTo(2);
    assertThat(intervals.get(0))
        .isEqualTo(new LocalDate[] {LocalDate.parse("2020-10-18"), LocalDate.parse("2020-10-18")});
    assertThat(intervals.get(1))
        .isEqualTo(new LocalDate[] {LocalDate.parse("2020-10-19"), LocalDate.parse("2020-10-25")});
  }

  @Test
  public void test9() {
    List<LocalDate[]> intervals =
        TimeIntervals.getIntervals(
            TimePeriod.WEEK, LocalDate.parse("2020-10-17"), LocalDate.parse("2020-10-25"));
    assertThat(intervals.size()).isEqualTo(2);
    assertThat(intervals.get(0))
        .isEqualTo(new LocalDate[] {LocalDate.parse("2020-10-17"), LocalDate.parse("2020-10-18")});
    assertThat(intervals.get(1))
        .isEqualTo(new LocalDate[] {LocalDate.parse("2020-10-19"), LocalDate.parse("2020-10-25")});
  }

  @Test
  public void test10() {
    List<LocalDate[]> intervals =
        TimeIntervals.getIntervals(
            TimePeriod.WEEK, LocalDate.parse("2020-10-19"), LocalDate.parse("2020-10-25"));
    assertThat(intervals.size()).isEqualTo(1);
    assertThat(intervals.get(0))
        .isEqualTo(new LocalDate[] {LocalDate.parse("2020-10-19"), LocalDate.parse("2020-10-25")});
  }
}
