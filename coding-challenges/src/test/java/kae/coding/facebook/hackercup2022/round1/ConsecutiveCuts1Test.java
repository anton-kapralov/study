package kae.coding.facebook.hackercup2022.round1;

import static com.google.common.truth.Truth.assertThat;

import java.util.Arrays;
import java.util.Collection;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;

@RunWith(value = Parameterized.class)
public class ConsecutiveCuts1Test {

  @Parameter public int[] a;

  @Parameter(1)
  public int[] b;

  @Parameter(2)
  public int k;

  @Parameter(3)
  public boolean expected;

  @Parameterized.Parameters(name = "Test {index}")
  public static Collection<Object[]> data() {
    return Arrays.asList(
        new Object[][] {
          { // 0
            new int[] {5, 1, 2, 4, 3}, new int[] {2, 4, 3, 5, 1}, 1, true
          },
          { // 1
            new int[] {3, 1, 4, 2}, new int[] {1, 2, 3, 4}, 10, false
          },
          { // 2
            new int[] {3, 1, 4, 2}, new int[] {2, 3, 1, 4}, 0, false
          },
          { // 3
            new int[] {3, 1, 4, 2}, new int[] {2, 3, 1, 4}, 1, true
          },
          { // 4
            new int[] {5, 1, 2, 4, 3}, new int[] {1, 2, 4, 3, 5}, 1, true
          },
          { // 5
            new int[] {1, 2}, new int[] {1, 2}, 0, true
          },
          { // 6
            new int[] {1, 2}, new int[] {1, 2}, 1, false
          },
          { // 7
            new int[] {1, 2}, new int[] {2, 1}, 1, true
          },
          { // 8
            new int[] {1, 2}, new int[] {2, 3}, 1, false
          },
          { // 9
            new int[] {1, 2}, new int[] {1, 2}, 2, true
          },
          { // 10
            new int[] {1, 2, 3}, new int[] {2, 3, 1}, 1, true
          },
          { // 11
            new int[] {1, 2, 3}, new int[] {2, 3, 1}, 2, true
          },
          { // 12
            new int[] {1, 2}, new int[] {1, 2}, 3, false
          },
          { // 13
            new int[] {1, 2, 3, 4}, new int[] {1, 2, 3, 4}, 1, false
          },
          { // 14
            new int[] {1, 2}, new int[] {2, 1}, 0, false
          },
          { // 15
            new int[] {1, 2}, new int[] {2, 1}, 2, false
          },
          { // 16
            new int[] {1, 4, 2, 3}, new int[] {3, 2, 1, 4}, 3, false
          },
          { // 17
            new int[] {50, 100, 2000, 40000, 300000},
            new int[] {2000, 40000, 300000, 50, 100},
            1,
            true
          },
        });
  }

  @Test
  public void solve() {
    String as = asString(a);
    String bs = asString(b);

    assertThat(ConsecutiveCuts1.solve(a.length, k, as, bs)).isEqualTo(expected);
  }

  private String[] asStringArray(int[] nums) {
    int n = nums.length;
    String[] ss = new String[n];
    for (int i = 0; i < n; i++) {
      ss[i] = String.valueOf(nums[i]);
    }
    return ss;
  }

  private String asString(int[] nums) {
    int n = nums.length;
    StringBuilder sb = new StringBuilder(n);
    for (int i = 0; i < n; i++) {
      sb.append(nums[i]);
      if (i + 1 < n) {
        sb.append(" ");
      }
    }
    return sb.toString();
  }
}
