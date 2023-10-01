package kae.coding.yandex.cup2020.qualification;

import java.io.StringReader;
import java.util.Arrays;
import org.junit.Test;

/** */
public class SortNumbersTest {

  @Test
  public void test1() throws Exception {
    int[] a =
        SortNumbers.parse(
            new StringReader(
                "[  \n"
                    + "  8,  \n"
                    + "  6,  \n"
                    + "  -2,  \n"
                    + "  2,  \n"
                    + "  4,  \n"
                    + "  17,  \n"
                    + "  256,  \n"
                    + "  1024,  \n"
                    + "  -17,  \n"
                    + "  -19  \n"
                    + "]"));
    System.out.println(Arrays.toString(a));
    Arrays.sort(a);
    for (int i = a.length - 1; i >= 0; i--) {
      System.out.println(a[i]);
    }
  }
}
