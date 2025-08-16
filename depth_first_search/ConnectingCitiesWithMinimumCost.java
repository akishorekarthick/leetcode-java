package depth_first_search;

import java.util.*;

public class ConnectingCitiesWithMinimumCost {

  /** @author gouthamvidyapradhan Class to represent UnionFind Disjoint Set */
  private class UnionFind {
    private int[] p;
    private int[] rank;
    private int numOfDisjoinSet;

    UnionFind(int s) {
      this.p = new int[s];
      this.rank = new int[s];
      this.numOfDisjoinSet = s - 1;
      init();
    }

    /** Initialize with its same index as its parent */
    public void init() {
      for (int i = 0; i < p.length; i++) p[i] = i;
    }

    private int findSet(int i) {
      if (p[i] != i) p[i] = findSet(p[i]);
      return p[i];
    }

    public boolean union(int i, int j) {
      int x = findSet(i);
      int y = findSet(j);
      if (x != y) {
        if (rank[x] > rank[y]) p[y] = p[x];
        else {
          p[x] = p[y];
          if (rank[x] == rank[y]) rank[y]++; // increment the rank
        }
        numOfDisjoinSet--;
        return true;
      }
      return false;
    }
  }

  private class Edge {
    int v1;
    int v2;
    int distance;

    Edge(int v1, int v2, int distance) {
      this.v1 = v1;
      this.v2 = v2;
      this.distance = distance;
    }
  }

  private List<Edge> edges = new ArrayList<>();
  int min = 0;

  public static void main(String[] args) {
    int[][] A = {{1, 2, 3}, {3, 4, 4}};
    System.out.println(new ConnectingCitiesWithMinimumCost().minimumCost(4, A));
  }

  public int minimumCost(int N, int[][] connections) {
    UnionFind uF = new UnionFind(N + 1);
    for (int i = 0; i < connections.length; i++) {
      edges.add(new Edge(connections[i][0], connections[i][1], connections[i][2]));
    }
    edges.sort(Comparator.comparingInt(o -> o.distance));
    for (Edge e : edges) {
      if (uF.union(e.v1, e.v2)) {
        min += e.distance;
      }
      if (uF.numOfDisjoinSet == 1) {
        return min;
      }
    }
    return -1;
  }
}