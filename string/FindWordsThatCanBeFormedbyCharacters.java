package string;

import java.util.*;

public class FindWordsThatCanBeFormedbyCharacters {
  public static void main(String[] args) {
    String[] A = {"cat", "bt", "hat", "problems/src/tree"};
    String chars = "atach";
    new FindWordsThatCanBeFormedbyCharacters().countCharacters(A, chars);
  }

  public int countCharacters(String[] words, String chars) {
    Map<Character, Integer> countMap = new HashMap<>();
    for (char c : chars.toCharArray()) {
      countMap.putIfAbsent(c, 0);
      countMap.put(c, countMap.get(c) + 1);
    }
    int ans = 0;
    for (String s : words) {
      Map<Character, Integer> subMap = new HashMap<>();
      for (char c : s.toCharArray()) {
        subMap.putIfAbsent(c, 0);
        subMap.put(c, subMap.get(c) + 1);
      }
      boolean possible = true;
      for (char k : subMap.keySet()) {
        if (!countMap.containsKey(k) || subMap.get(k) > countMap.get(k)) {
          possible = false;
          break;
        }
      }
      if (possible) {
        ans += s.length();
      }
    }
    return ans;
  }
}