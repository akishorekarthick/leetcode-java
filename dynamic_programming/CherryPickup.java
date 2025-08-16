package dynamic_programming;

import java.util.Arrays;

public class CherryPickup {

  public static void main(String[] args) throws Exception {
    int[][] A = {{0, 1, -1}, {1, 0, -1}, {1, 1, 1}};
    System.out.println(new CherryPickup().cherryPickup(A));
  }

  public int cherryPickup(int[][] grid) {
    int[][][] DP = new int[grid.length][grid.length][grid.length];
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid.length; j++) {
        Arrays.fill(DP[i][j], -1);
      }
    }
    int result = dp(grid.length, 0, 0, 0, DP, grid);
    if (result < 0) return 0;
    else return result;
  }

  private int dp(int N, int r1, int c1, int c2, int[][][] DP, int[][] grid) {
    int r2 = r1 + (c1 - c2);
    if (r1 >= N || c1 >= N || c2 >= N || r2 >= N || grid[r1][c1] == -1 || grid[r2][c2] == -1)
      return Integer.MIN_VALUE;
    else if (DP[r1][c1][c2] != -1) return DP[r1][c1][c2];
    else if (r1 == N - 1 && c1 == N - 1) return grid[N - 1][N - 1];
    else {
      int max = (c1 == c2) ? grid[r1][c1] : (grid[r1][c1] + grid[r2][c2]);
      // verify all the 4 possibilities. (P1 down + P2 right), (P1 right, P2 right), (P1 right + P2
      // down),
      // (P1 down, P2 down)
      max +=
          Math.max(
              Math.max(
                  Math.max(dp(N, r1 + 1, c1, c2, DP, grid), dp(N, r1 + 1, c1, c2 + 1, DP, grid)),
                  dp(N, r1, c1 + 1, c2, DP, grid)),
              dp(N, r1, c1 + 1, c2 + 1, DP, grid));
      DP[r1][c1][c2] = max;
      return max;
    }
  }
}