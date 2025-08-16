package dynamic_programming;

import java.util.Arrays;

public class CherryPickupII {
  private final int[] R = {1, 1, 1};
  private final int[] C = {0, -1, 1};

  public static void main(String[] args) {
    int[][] A = {
      {1, 0, 0, 3},
      {2, 0, 0, 0, 0, 3, 0},
      {2, 0, 9, 0, 0, 0, 0},
      {0, 3, 0, 5, 4, 0, 0},
      {1, 0, 2, 3, 0, 0, 6}
    };
    System.out.println(new CherryPickupII().cherryPickup(A));
  }

  int[][][] DP;

  public int cherryPickup(int[][] grid) {
    DP = new int[grid.length][grid[0].length][grid[0].length];
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[0].length; j++) {
        Arrays.fill(DP[i][j], -1);
      }
    }
    return dp(0, 0, grid[0].length - 1, grid);
  }

  private int dp(int r, int c1, int c2, int[][] grid) {
    if (DP[r][c1][c2] != -1) return DP[r][c1][c2];
    else {
      int count = (c1 == c2) ? grid[r][c1] : (grid[r][c1] + grid[r][c2]);
      int max = count;
      for (int i = 0; i < 3; i++) {
        int newR = r + R[i];
        int newC1 = c1 + C[i];
        if (newR >= 0 && newR < grid.length && newC1 >= 0 && newC1 < grid[0].length) {
          for (int j = 0; j < 3; j++) {
            int newC2 = c2 + C[j];
            if (newC2 >= 0 && newC2 < grid[0].length) {
              max = Math.max(max, count + dp(newR, newC1, newC2, grid));
            }
          }
        }
      }
      DP[r][c1][c2] = max;
      return max;
    }
  }
}