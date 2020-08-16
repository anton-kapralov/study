package kae.study.codingchallenges.facebook.hackercup2020.round1;

import static kae.study.codingchallenges.facebook.hackercup2020.round1.FloorPlan.MODULO;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.util.Scanner;

class FloorPlan {

  public static final int MODULO = 1000000007;

  private final int id;
  private final int roomsCount;
  private final int width;
  private final long[] lefts;
  private final long[] heights;

  public int id() {
    return id;
  }

  public int roomsCount() {
    return roomsCount;
  }

  public int width() {
    return width;
  }

  public long[] lefts() {
    return lefts;
  }

  public long[] heights() {
    return heights;
  }

  private FloorPlan(Builder builder) {
    id = builder.id;
    roomsCount = builder.roomsCount;
    width = builder.width;
    lefts = new long[roomsCount];
    System.arraycopy(builder.lefts, 0, lefts, 0, builder.k);
    for (int i = builder.k; i < roomsCount; ++i) {
      lefts[i] = builder.nextLeft(lefts[i - 2], lefts[i - 1]);
    }
    heights = new long[roomsCount];
    System.arraycopy(builder.heights, 0, heights, 0, builder.k);
    for (int i = builder.k; i < roomsCount; ++i) {
      heights[i] = builder.nextHeight(heights[i - 2], heights[i - 1]);
    }
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public static final class Builder {

    private int id;
    private int roomsCount;
    private int k;
    private int width;
    private long[] lefts;
    private long al;
    private long bl;
    private long cl;
    private long dl;
    private long[] heights;
    private long ah;
    private long bh;
    private long ch;
    private long dh;

    private Builder() {}

    public Builder setId(int val) {
      id = val;
      return this;
    }

    public Builder setRoomsCount(int val) {
      roomsCount = val;
      return this;
    }

    public Builder setK(int val) {
      k = val;
      return this;
    }

    public Builder setWidth(int val) {
      width = val;
      return this;
    }

    public Builder setLefts(long[] val) {
      lefts = val;
      return this;
    }

    public Builder setLeftConstants(long al, long bl, long cl, long dl) {
      this.al = al;
      this.bl = bl;
      this.cl = cl;
      this.dl = dl;
      return this;
    }

    public Builder setHeights(long[] val) {
      heights = val;
      return this;
    }

    public Builder setHeightConstants(long ah, long bh, long ch, long dh) {
      this.ah = ah;
      this.bh = bh;
      this.ch = ch;
      this.dh = dh;
      return this;
    }

    private long nextLeft(long left1, long left2) {
      return (al * left1 % dl + bl * left2 % dl + cl % dl) % dl + 1;
    }

    private long nextHeight(long height1, long height2) {
      return (ah * height1 % dh + bh * height2 % dh + ch % dh) % dh + 1;
    }

    public FloorPlan build() {
      return new FloorPlan(this);
    }
  }
}

class Point implements Comparable<Point> {
  final long x;
  final long y;
  final boolean end; // false means start.

  Point(long x, long y, boolean end) {
    this.x = x;
    this.y = y;
    this.end = end;
  }

  @Override
  public String toString() {
    return "[" + x + ", " + y + "]";
  }

  @Override
  public int compareTo(Point o) {
    return Long.compare(x, o.x);
  }
}

/** */
public class Perimetric1 {

  public static void main(String[] args) throws IOException {
    try (Scanner scanner = new Scanner(Paths.get(args[0]));
        PrintWriter writer = getWriter(args)) {
      int t = scanner.nextInt();

      for (int i = 0; i < t; i++) {
        solve(i + 1, scanner, writer);
      }
    }
  }

  private static PrintWriter getWriter(String[] args) throws FileNotFoundException {
    return args.length > 1
        ? new PrintWriter(new OutputStreamWriter(new FileOutputStream(args[1])))
        : new PrintWriter(System.out);
  }

  static void solve(int caseNumber, Scanner scanner, PrintWriter writer) {
    int n = scanner.nextInt();
    int k = scanner.nextInt();
    int w = scanner.nextInt();
    scanner.nextLine();
    long[] ls = new long[k];
    for (int i = 0; i < k; i++) {
      ls[i] = scanner.nextInt();
    }
    scanner.nextLine();
    int al = scanner.nextInt();
    int bl = scanner.nextInt();
    int cl = scanner.nextInt();
    int dl = scanner.nextInt();
    scanner.nextLine();
    long[] hs = new long[k];
    for (int i = 0; i < k; i++) {
      hs[i] = scanner.nextInt();
    }
    scanner.nextLine();
    int ah = scanner.nextInt();
    int bh = scanner.nextInt();
    int ch = scanner.nextInt();
    int dh = scanner.nextInt();
    scanner.nextLine();

    long result =
        solve(
            FloorPlan.newBuilder()
                .setId(caseNumber)
                .setRoomsCount(n)
                .setK(k)
                .setWidth(w)
                .setLefts(ls)
                .setLeftConstants(al, bl, cl, dl)
                .setHeights(hs)
                .setHeightConstants(ah, bh, ch, dh)
                .build());

    writer.printf("Case #%d: %d\n", caseNumber, result);
  }

  static long solve(FloorPlan floorPlan) {
    long[] lefts = floorPlan.lefts();
    long[] heights = floorPlan.heights();
    int width = floorPlan.width();

    long sum = perimeterOf(width, heights[0]);
    long product = sum;
//    System.out.printf("%d %d %d %d\n", lefts[0], heights[0], sum, product);

    for (int i = 1; i < floorPlan.roomsCount(); ++i) {
      long left1 = lefts[i - 1];
      long right1 = left1 + width;
      long height1 = heights[i - 1];
      long left2 = lefts[i];
      long right2 = left2 + width;
      long height2 = heights[i];

      long nextSum;
      if (left2 <= right1) {
        nextSum = sum + 2 * (right2 - right1);
        int j = i - 1;
        long maxHeight = 0;
        while (j >= 0 && left2 <= lefts[j] + width) {
          maxHeight = Math.max(maxHeight, heights[j]);
          --j;
        }
        if (height2 > maxHeight) {
          nextSum += 2 * (height2 - maxHeight);
        }
      } else {
        nextSum = sum + perimeterOf(width, height2);
      }

      sum = nextSum;
      product = ((product % MODULO) * (sum % MODULO)) % MODULO;

//      System.out.printf("%d %d %d %d\n", left2, height2, sum, product);
    }

    return product;
  }

  private static long perimeterOf(long width, long height) {
    return 2 * width + 2 * height;
  }
}
