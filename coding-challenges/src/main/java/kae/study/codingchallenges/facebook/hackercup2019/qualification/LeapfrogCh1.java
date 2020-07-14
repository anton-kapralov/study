package kae.study.codingchallenges.facebook.hackercup2019.qualification;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

/** */
public class LeapfrogCh1 {

  public static void main(String[] args) throws IOException {
    try (BufferedReader reader =
            new BufferedReader(new InputStreamReader(new FileInputStream(args[0])));
        PrintWriter writer =
            new PrintWriter(new OutputStreamWriter(new FileOutputStream(args[1] + "/output.txt")))) {
      reader.readLine();
      String s;
      int i = 0;
      while (null != (s = reader.readLine())) {
        boolean result = solve(s);
        writer.printf("Case #%d: %s\n", ++i, result ? "Y" : "N");
      }
    }
  }

  private static boolean solve(String s) {
    int bc = 0;
    int lc = 0;
    for (char c : s.toCharArray()) {
        switch (c) {
          case 'B':
            bc++;
            break;
          case '.':
            lc++;
            break;
        }
    }

    return lc > 0 && bc >= lc;
  }
}
