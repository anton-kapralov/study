package kae.study.codingchallenges.algorithms.strings;

/**
 *
 */
public class RabinKarpHash {

  private static final int A = 911382323;
  private static final int B = 972663749;

  private final long[] h;
  private final long[] p;

  public RabinKarpHash(String string) {
    char[] s = string.toCharArray();

    h = new long[s.length];
    h[0] = s[0] % B;
    for (int i = 1; i < s.length; ++i) {
      h[i] = (h[i - 1] * A + s[i]) % B;
    }

    p = new long[s.length];
    p[0] = 1;
    for (int i = 1; i < s.length; ++i) {
      p[i] = (p[i - 1] * A) % B;
    }
  }

  public long get(int i) {
    return h[i];
  }

  public long get(int i, int j) {
    long sh = i == 0 ? h[j] : (h[j] - h[i - 1] * p[j - i + 1] % B);
    if (sh < 0) {
      sh += B;
    }
    return sh;
  }

}
