package breadth_first_search;

import java.util.*;

public class RottingOranges {
  final int[] R = {1, -1, 0, 0};
  final int[] C = {0, 0, 1, -1};

  public static void main(String[] args) {
    int[][] A = {{2, 1, 1}, {1, 1, 0}, {0, 1, 1}};
    System.out.println(new RottingOranges().orangesRotting(A));
  }

  private class Node {
    int r, c, v;

    Node(int r, int c, int v) {
      this.r = r;
      this.c = c;
      this.v = v;
    }
  }

  public int orangesRotting(int[][] grid) {
    Queue<Node> queue = new ArrayDeque<>();
    boolean[][] done = new boolean[grid.length][grid[0].length];
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[0].length; j++) {
        if (grid[i][j] == 2) {
          queue.offer(new Node(i, j, 0));
          done[i][j] = true;
        }
      }
    }
    int max = 0;
    while (!queue.isEmpty()) {
      Node curr = queue.poll();
      for (int i = 0; i < 4; i++) {
        int newR = curr.r + R[i];
        int newC = curr.c + C[i];
        if (newR >= 0 && newR < grid.length && newC >= 0 && newC < grid[0].length) {
          if (!done[newR][newC] && grid[newR][newC] != 0) {
            done[newR][newC] = true;
            max = Math.max(max, curr.v + 1);
            queue.offer(new Node(newR, newC, curr.v + 1));
          }
        }
      }
    }
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[0].length; j++) {
        if (grid[i][j] == 1 && !done[i][j]) {
          return -1;
        }
      }
    }
    return max;
  }
}