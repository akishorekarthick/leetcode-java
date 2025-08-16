package string;

public class ExcelSheetColumnNumber {
  String CONST = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

  public static void main(String[] args) throws Exception {
    System.out.println(new ExcelSheetColumnNumber().titleToNumber("AAB"));
  }

  public int titleToNumber(String s) {
    int total = 0;
    int j = 0;
    for (int i = s.length() - 1; i >= 0; i--) {
      char c = s.charAt(i);
      int pos = CONST.indexOf(c) + 1;
      int pow = (int) Math.pow(26, j++);
      total += (pow * pos);
    }
    return total;
  }
}