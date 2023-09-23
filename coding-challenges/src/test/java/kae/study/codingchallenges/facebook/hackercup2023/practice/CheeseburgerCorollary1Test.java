package kae.study.codingchallenges.facebook.hackercup2023.practice;

import static com.google.common.truth.Truth.assertThat;
import static kae.study.codingchallenges.facebook.hackercup2023.practice.CheeseburgerCorollary1.solve;

import java.util.Arrays;
import java.util.Collection;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;

/**
 *
 */
@RunWith(value = Parameterized.class)
public class CheeseburgerCorollary1Test {

    @Parameter
    public int s;
    @Parameter(1)
    public int d;
    @Parameter(2)
    public int k;
    @Parameter(3)
    public boolean expected;

    @Parameterized.Parameters(name = "Test {index}")
    public static Collection<Object[]> data() {
        return Arrays.asList(
                new Object[][]{
                        {1, 1, 3, true}, // 1
                        {0, 2, 4, false}, // 2
                        {5, 5, 1, true}, // 3
                        {0, 1, 1, true}, // 4
                        {1, 1, 2, true}, // 5
                        {97, 1, 99, true}, // 6
                        {97, 1, 100, false}, // 7
                }
        );
    }

    @Test
    public void solve_returnsExpected() {
        assertThat(solve(s, d, k)).isEqualTo(expected);
    }
}