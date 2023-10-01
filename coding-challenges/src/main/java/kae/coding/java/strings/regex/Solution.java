package kae.coding.java.strings.regex;

import java.util.Scanner;

public class Solution {

  public static void main(String[] argh) {
    Scanner in = new Scanner(System.in);
    while (in.hasNext()) {
      String IP = in.next();
      System.out.println(IP.matches(new myRegex().pattern));
    }
  }
}

class myRegex {
  public final String BYTE = "(0{0,2}[0-9]|0?[0-9]{2}|1[0-9]{2}|2[0-4][0-9]|25[0-5])";
  public final String pattern = BYTE + "\\." + BYTE + "\\." + BYTE + "\\." + BYTE;
}
