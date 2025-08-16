package string;

import java.util.HashMap;
import java.util.Map;

public class IsomorphicStrings {

  public static void main(String[] args) throws Exception {
    System.out.println(new IsomorphicStrings().isIsomorphic("abc", "dea"));
  }

  public boolean isIsomorphic(String s, String t) {
    if (s.length() != t.length()) return false;
    Map<Character, Character> first = new HashMap<>();
    Map<Character, Character> second = new HashMap<>();
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      if (first.containsKey(c)) {
        char secondC = first.get(c);
        if (t.charAt(i) != secondC) return false;
      } else {
        first.put(c, t.charAt(i));
        if (second.containsKey(t.charAt(i))) return false;
        second.put(t.charAt(i), c);
      }
    }
    return true;
  }
}