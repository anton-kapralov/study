package kae.study.codingchallenges.facebook.hackercup2020.qualification;

import static com.google.common.truth.Truth.assertThat;
import static kae.study.codingchallenges.facebook.hackercup2020.qualification.TravelRestrictions.solve;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Scanner;
import org.junit.Test;

/** */
public class TravelRestrictionsTest {

  @Test
  public void test_1() {
    String input = "2\nYY\nYY";
    StringWriter output = new StringWriter();

    solve(1, new Scanner(input), new PrintWriter(output));

    assertThat(output.toString()).isEqualTo("Case #1: \nYY\nYY\n");
  }

  @Test
  public void test_2() {
    String input = "2\nNY\nYY";
    StringWriter output = new StringWriter();

    solve(2, new Scanner(input), new PrintWriter(output));

    assertThat(output.toString()).isEqualTo("Case #2: \nYY\nNY\n");
  }

  @Test
  public void test_3() {
    String input = "2\nNN\nYY";
    StringWriter output = new StringWriter();

    solve(3, new Scanner(input), new PrintWriter(output));

    assertThat(output.toString()).isEqualTo("Case #3: \nYN\nNY\n");
  }

  @Test
  public void test_4() {
    String input = "5\nYNNYY\nYYYNY";
    StringWriter output = new StringWriter();

    solve(4, new Scanner(input), new PrintWriter(output));

    assertThat(output.toString()).isEqualTo("Case #4: \nYNNNN\nYYNNN\nNNYYN\nNNNYN\nNNNYY\n");
  }

  @Test
  public void test_5() {
    String input = "10\n" + "NYYYNNYYYY\n" + "YYNYYNYYNY";
    StringWriter output = new StringWriter();

    solve(5, new Scanner(input), new PrintWriter(output));

    assertThat(output.toString())
        .isEqualTo(
            "Case #5: \n"
                + "YYYNNNNNNN\n"
                + "NYYNNNNNNN\n"
                + "NNYNNNNNNN\n"
                + "NNYYNNNNNN\n"
                + "NNYYYNNNNN\n"
                + "NNNNNYNNNN\n"
                + "NNNNNNYYYN\n"
                + "NNNNNNYYYN\n"
                + "NNNNNNNNYN\n"
                + "NNNNNNNNYY\n");
  }
}
