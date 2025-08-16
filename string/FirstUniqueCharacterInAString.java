package string;

public class FirstUniqueCharacterInAString {
  int[] CHAR = new int[256];

  public static void main(String[] args) throws Exception {
    System.out.println(new FirstUniqueCharacterInAString().firstUniqChar("loveleetcode"));
  }

  public int firstUniqChar(String s) {
    if (s == null || s.isEmpty()) return -1;

    for (int i = 0, l = s.length(); i < l; i++) CHAR[s.charAt(i)]++;

    for (int i = 0, l = s.length(); i < l; i++) {
      if (CHAR[s.charAt(i)] == 1) return i;
    }

    return -1;
  }
}