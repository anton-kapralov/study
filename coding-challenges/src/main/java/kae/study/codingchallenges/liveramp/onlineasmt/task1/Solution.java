package kae.study.codingchallenges.liveramp.onlineasmt.task1;

import java.util.HashMap;
import java.util.Map;

public class Solution {

  private final Map<String, Integer> map = new HashMap<>(7);
  private final String[] days = {"Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"};


  public Solution() {
    for (int i = 0; i < days.length; i++) {
      map.put(days[i], i);
    }
  }

  public String solution(String s, int k) {
    Integer dayNumber = map.get(s);
    if (dayNumber == null) {
      return "";
    }

    int next = (dayNumber + k) % 7;

    return days[next];
  }

}
