package kae.study.codingchallenges.yandex.cup2020.qualification;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Scanner;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/** */
public class SortNumbers {

  public static void main(String[] args) throws IOException, ParseException {
    try (Scanner scanner = getScanner(args);
        PrintWriter writer = getWriter(args)) {
      String url =
          String.format(
              "%s:%s?a=%s&b=%s",
              scanner.nextLine(), scanner.nextLine(), scanner.nextLine(), scanner.nextLine());
      HttpURLConnection con = (HttpURLConnection) new URL(url).openConnection();
      con.setRequestMethod("POST");

      con.setRequestProperty("Content-Type", "application/json; utf-8");
      con.setRequestProperty("Accept", "application/json");

      con.setDoOutput(true);

      int[] array;
      try (BufferedReader br =
          new BufferedReader(new InputStreamReader(con.getInputStream(), "utf-8"))) {
        array = parse(br);
      }
      Arrays.sort(array);
      for (int i = array.length - 1; i >= 0; i--) {
        writer.println(array[i]);
      }
    }
  }

  static int[] parse(Reader reader) throws IOException, ParseException {
    int[] array;
    JSONArray jsonArray = (JSONArray) new JSONParser().parse(reader);
    array = new int[jsonArray.size()];
    for (int i = 0; i < jsonArray.size(); i++) {
      array[i] = ((Long) jsonArray.get(i)).intValue();
    }
    return array;
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
