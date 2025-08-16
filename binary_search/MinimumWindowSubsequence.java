package binary_search;

import java.util.*;

public class MinimumWindowSubsequence {
  public static void main(String[] args) {
    System.out.println(new MinimumWindowSubsequence().minWindow("abcdebdde", "x"));
  }

  public String minWindow(String S, String T) {
    if (T.isEmpty() || S.isEmpty()) return "";
    Map<Character, TreeSet<Integer>> charMap = new HashMap<>();
    for (int i = 0, l = S.length(); i < l; i++) {
      char c = S.charAt(i);
      charMap.putIfAbsent(c, new TreeSet<>());
      charMap.get(c).add(i);
    }
    int min = Integer.MAX_VALUE;
    int start = -1, end;
    int ansStart = -1, ansEnd = -1;
    boolean finished = false;
    while (true) {
      int index = start;
      end = -1;
      for (int i = 0, l = T.length(); i < l; i++) {
        char c = T.charAt(i);
        if (!charMap.containsKey(c)) {
          return "";
        } else {
          TreeSet<Integer> indicies = charMap.get(c);
          Integer found = indicies.higher(index);
          if (found == null) {
            finished = true;
            break;
          } else {
            index = found;
            if (i == 0) {
              start = index;
            }
            if (i == l - 1) {
              end = index;
            }
          }
        }
      }
      if (start != -1 && end != -1) {
        if ((end - start) < min) {
          min = end - start;
          ansStart = start;
          ansEnd = end;
        }
      }
      if (finished) return ansStart == -1 ? "" : S.substring(ansStart, ansEnd + 1);
    }
  }
}