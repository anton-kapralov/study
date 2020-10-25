package kae.study.codingchallenges.yandex.cup2020.qualification;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/** */
public class SimilarRows {
  public static void main(String[] args) throws IOException {
    try (Scanner scanner = getScanner(args);
        PrintWriter writer = getWriter(args)) {
      int n = scanner.nextInt();
      int k = scanner.nextInt();
      scanner.nextLine();
      int s = scanner.nextInt();
      boolean[] important = new boolean[k];
      for (int i = 0; i < s; i++) {
        important[scanner.nextInt() - 1] = true;
      }
      scanner.nextLine();
      int counter = 0;
      List<String[]> rows = new ArrayList<>(n);
      for (int i = 0; i < n; i++) {
        String[] row = toRow(scanner.nextLine(), k);
        for (String[] another : rows) {
          if (potentiallyEqual(important, row, another)) {
            counter++;
          }
        }
        rows.add(row);
      }
      writer.println(counter);
    }
  }

  private static String[] toRow(String line, int k) {
    String[] row = new String[k];
    String[] strings = line.split("\t");
    System.arraycopy(strings, 0, row, 0, strings.length);
    for (int i = strings.length; i < k; i++) {
      row[i] = "";
    }

    return row;
  }

  /**
   * Назовем две различные строки в базе данных потенциально одинаковыми, если у них есть хотя бы
   * один общий важный столбец, заполненный одинаковым непустым значением. Кроме того, все столбцы,
   * которые непусты в обеих строчках одновременно, должны содержать одинаковые значения.
   */
  private static boolean potentiallyEqual(boolean[] important, String[] row1, String[] row2) {
    boolean found = false;
    for (int i = 0; i < row1.length; i++) {
      String v1 = row1[i];
      String v2 = row2[i];
      if (v1.equals(v2)) {
        if (important[i]) {
          found = true;
        }
        continue;
      }

      if (!v1.isEmpty() && !v2.isEmpty()) {
        return false;
      }
    }

    return found;
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
