package dynamic_programming;

public class BurstBalloons {
  private int[][] dp;
  private int[] N;

  public static void main(String[] args) throws Exception {
    int[] A = {3, 1, 5, 8};
    System.out.println(new BurstBalloons().maxCoins(A));
  }

  public int maxCoins(int[] nums) {
    N = new int[nums.length + 2];
    N[0] = N[N.length - 1] = 1; // boundary
    for (int i = 0; i < nums.length; i++) {
      N[i + 1] = nums[i];
    }
    int[][] DP = new int[N.length][N.length];
    for (int r = 2; r < N.length; r++) {
      for (int i = 0; i < N.length; i++) {
        int j = i + r;
        if (j < N.length) {
          int max = Integer.MIN_VALUE;
          for (int t = i + 1; t < j; t++) {
            max = Math.max(max, N[t] * N[i] * N[j] + DP[t][j] + DP[i][t]);
          }
          DP[i][j] = max;
        }
      }
    }
    return DP[0][N.length - 1];
    /*    for (int i = 0; i < nums.length; i++) {
      N[i + 1] = nums[i];
    }
    dp = new int[N.length][N.length];
    for (int[] aDp : dp) {
      Arrays.fill(aDp, -1);
    }*/
    //    return dp(0, N.length - 1);
  }

  private int dp(int l, int r) {
    if (l + 1 == r) return 0;
    if (dp[l][r] != -1) return dp[l][r];
    int result = 0;
    for (int i = l + 1; i < r; i++) {
      result = Math.max(result, N[i] * N[l] * N[r] + dp(l, i) + dp(i, r));
    }
    dp[l][r] = result;
    return dp[l][r];
  }
}