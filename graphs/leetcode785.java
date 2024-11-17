// Bipartite graph question
// link: https://leetcode.com/problems/is-graph-bipartite/description/

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class leetcode785 {

  public static boolean isBipartite(int[][] graph) {
    int n = graph.length;

    int setid[] = new int[n];
    Arrays.fill(setid, -1);
    for (int ind = 0; ind < n; ind++) {
      if (setid[ind] != -1)
        continue;
      Queue<Integer> q = new LinkedList<>();
      q.add(ind);
      while (!q.isEmpty()) {
        int node = q.poll();
        if (setid[ind] == -1) {
          setid[ind] = 0;
        }
        for (int neighbor : graph[node]) {
          if (setid[neighbor] == -1) {
            setid[neighbor] = (setid[node] + 1) % 2;
            q.add(neighbor);
          }
          if (setid[neighbor] != -1 && setid[neighbor] == setid[node]) {
            return false;
          }
        }
      }
    }
    return true;
  }

  public static void main(String[] args) {
    int graph[][] = { { 1, 2, 3 }, { 0 }, { 0 }, { 0 }, {} };

    System.out.println(isBipartite(graph));

  }
}
