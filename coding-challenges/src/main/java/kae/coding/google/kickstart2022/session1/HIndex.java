package kae.coding.google.kickstart2022.session1;

import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * Jorge is a physicist who has published many research papers and wants to know how much impact
 * they have had in the academic community. To measure impact, he has developed a metric, H-index,
 * to score each of his papers based on the number of times it has been cited by other papers.
 * Specifically, the H-index score of a researcher is the largest integer H such that the researcher
 * has H papers with at least H citations each.
 *
 * <p>Jorge has written N papers in his lifetime. The i-th paper has Ci citations. Each paper was
 * written sequentially in the order provided, and the number of citations that each paper has will
 * never change. Please help Jorge determine his H-index score after each paper he wrote.
 *
 * <p>https://codingcompetitions.withgoogle.com/kickstart/round/00000000008f4332/0000000000941e56
 */
public class HIndex {
  public static int[] getHIndexScore(int[] citationsPerPaper) {
    int[] hIndex = new int[citationsPerPaper.length];

    PriorityQueue<Integer> pq = new PriorityQueue<>();
    for (int i = 0; i < citationsPerPaper.length; i++) {
      int c = citationsPerPaper[i];

      if (pq.isEmpty()) {
        pq.add(c);
      } else {
        if (c > pq.size()) {
          pq.add(c);
        }
        while (pq.size() > 1 && pq.peek() < pq.size()) {
          pq.remove();
        }
      }

      hIndex[i] = pq.size();
    }

    return hIndex;
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    // Get number of test cases in input
    int testCaseCount = scanner.nextInt();
    // Iterate through test cases
    for (int tc = 1; tc <= testCaseCount; ++tc) {
      // Get number of papers for this test case
      int paperCount = scanner.nextInt();
      // Get number of citations for each paper
      int[] citations = new int[paperCount];
      for (int p = 0; p < paperCount; ++p) {
        citations[p] = scanner.nextInt();
      }
      // Print h-index score after each paper in this test case
      System.out.print("Case #" + tc + ":");
      for (int score : getHIndexScore(citations)) {
        System.out.append(" ").print(score);
      }
      System.out.println();
    }
  }
}
