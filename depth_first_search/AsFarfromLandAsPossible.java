package depth_first_search;

import java.util.*;

public class AsFarfromLandAsPossible {
  final int[] R = {1, -1, 0, 0};
  final int[] C = {0, 0, -1, 1};

  public static void main(String[] args) {
    int[][] G = {{1, 0, 1}, {0, 0, 0}, {1, 0, 1}};
    System.out.println(new AsFarfromLandAsPossible().maxDistance(G));
  }

  private class Node {
    int r, c, d;

    Node(int r, int c, int d) {
      this.r = r;
      this.c = c;
      this.d = d;
    }
  }

  public int maxDistance(int[][] grid) {
    int[][] D = new int[grid.length][grid[0].length];
    Queue<Node> queue = new ArrayDeque<>();
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[0].length; j++) {
        if (grid[i][j] == 1) {
          queue.offer(new Node(i, j, 0));
        } else {
          D[i][j] = -1;
        }
      }
    }
    if (queue.isEmpty()) return -1;
    while (!queue.isEmpty()) {
      Node current = queue.poll();
      for (int i = 0; i < 4; i++) {
        int newR = current.r + R[i];
        int newC = current.c + C[i];
        if (newR >= 0 && newC >= 0 && newR < grid.length && newC < grid[0].length) {
          if (D[newR][newC] < 0) {
            D[newR][newC] = current.d + 1;
            Node child = new Node(newR, newC, current.d + 1);
            queue.offer(child);
          }
        }
      }
    }
    int max = 0;
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[0].length; j++) {
        if (grid[i][j] == 0) {
          max = Math.max(max, D[i][j]);
        }
      }
    }
    return max == 0 ? -1 : max;
  }
}