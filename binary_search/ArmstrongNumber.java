package binary_search;

public class ArmstrongNumber {
  public static void main(String[] args) {
    //
  }

  public boolean isArmstrong(int N) {
    int s = String.valueOf(N).length();
    long sum = 0;
    for (char c : String.valueOf(N).toCharArray()) {
      int i = Integer.parseInt(String.valueOf(c));
      sum += power(i, s);
    }
    return (sum == N);
  }

  private long power(int n, int p) {
    long res = 1L;
    for (int i = 0; i < p; i++) {
      res *= n;
    }
    return res;
  }
}