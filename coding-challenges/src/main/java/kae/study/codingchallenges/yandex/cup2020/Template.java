package kae.study.codingchallenges.yandex.cup2020;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.util.Scanner;

/** */
public class Template {

  public static void main(String[] args) throws IOException {
    try (Scanner scanner = getScanner(args);
        PrintWriter writer = getWriter(args)) {}
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
