package kae.study.codingchallenges.facebook.hackercup2023.practice;

import java.io.*;
import java.util.*;

/**
 *
 */
public class TwoApplesDay {

    @SuppressWarnings("DuplicatedCode")
    public static void main(String[] args) throws IOException {
        long start = System.currentTimeMillis();
        try (BufferedReader reader = new BufferedReader(new FileReader(args[0]));
             PrintWriter writer = getWriter(args)) {
            int t = Integer.parseInt(reader.readLine());

            for (int i = 1; i <= t; i++) {
                long testCaseStart = System.currentTimeMillis();
                solve(i, reader, writer);
                System.out.printf("Case #%02d: %d ms%n", i, System.currentTimeMillis() - testCaseStart);
            }
        }
        System.out.printf("%nTotal: %d ms%n", System.currentTimeMillis() - start);
    }

    private static PrintWriter getWriter(String[] args) throws FileNotFoundException {
        return new PrintWriter(new OutputStreamWriter(new FileOutputStream(args[0].replace("input", "output"))));
    }

    private static void solve(int caseNumber, BufferedReader reader, PrintWriter writer) throws IOException {
        int n = Integer.parseInt(reader.readLine());
        String[] ss = reader.readLine().split(" ");
        int[] ws = new int[ss.length];
        for (int i = 0; i < ss.length; i++) {
            ws[i] = Integer.parseInt(ss[i]);
        }
        long a = solve(n, ws);
        writer.printf("Case #%d: %d\n", caseNumber, a);
    }

    static long solve(int n, int[] ws) {
        int k = ws.length;
        if (k == 1) {
            return 1;
        }
        Arrays.sort(ws);

        // To the left of min.
        int l = 0, r = k - 2;
        int daySum = ws[l] + ws[r];
        while (l < r) {
            int sum = ws[l] + ws[r];
            if (sum != daySum) {
                break;
            }
            l++;
            r--;
        }
        if (l > r) {
            int a = daySum - ws[k - 1];
            if (a > 0) {
                return a;
            }
        }

        // Somewhere in-between.
        daySum = ws[0] + ws[k - 1];
        Map<Integer, Integer> map = new HashMap<>();
        for (int w : ws) {
            int another = daySum - w;
            int counter = map.getOrDefault(another, 0);
            if (counter > 0) {
                counter--;
                if (counter == 0) {
                    map.remove(another);
                    continue;
                }
                map.put(another, counter);
                continue;
            }
            map.merge(w, 1, Integer::sum);
        }
        if (map.size() == 1) {
            Map.Entry<Integer, Integer> e = map.entrySet().iterator().next();
            if (e.getValue() == 1) {
                return daySum - e.getKey();
            }
        }

        // To the right of max.
        l = 1;
        r = k - 1;
        daySum = ws[l] + ws[r];
        while (l < r) {
            int sum = ws[l] + ws[r];
            if (sum != daySum) {
                break;
            }
            l++;
            r--;
        }
        if (l > r) {
            int a = daySum - ws[0];
            if (a > 0) {
                return a;
            }
        }
        return -1;
    }

}
