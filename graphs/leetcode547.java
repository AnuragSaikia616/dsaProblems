// 547. Number of Provinces
// Medium
//
// There are n cities. Some of them are connected, while some are not. If city a
// is connected directly with city b, and city b is connected directly with city
// c, then city a is connected indirectly with city c.
//
// A province is a group of directly or indirectly connected cities and no other
// cities outside of the group.
//
// You are given an n x n matrix isConnected where isConnected[i][j] = 1 if the
// ith city and the jth city are directly connected, and isConnected[i][j] = 0
// otherwise.
//
// Return the total number of provinces.

import java.beans.Visibility;
import java.util.Stack;

/**
 * leetcode547
 */
public class leetcode547 {
  public static int numComponents(graph g) {
    int n = g.getNumVertex();
    boolean[] visited = new boolean[n + 1];
    int result = 0;
    for (int i = 1; i <= n; i++) {
      if (!visited[i]) {
        result += 1;
        Stack<Integer> st = new Stack<>();
        st.push(i);
        while (!st.isEmpty()) {
          int node = st.pop();
          if (!visited[node]) {
            visited[node] = true;
            for (int neighbour : g.getNeighbours().get(node)) {
              if (!visited[neighbour]) {
                st.push(neighbour);
              }
            }
          }
        }
      }
    }
    return result;
  }

  public static void dfs(int g[][], boolean vis[], int start) {
    Stack<Integer> st = new Stack<>();
    st.push(start);
    while (!st.isEmpty()) {
      int curr = st.pop();
      if (!vis[curr]) {
        vis[curr] = true;
        for (int i = 0; i < g[curr].length; i++) {
          if (!vis[i] && g[curr][i] == 1) {
            st.push(i);
          }
        }
      }
    }
  }

  public static int numComponents(int[][] g) {
    int n = g.length;
    boolean visited[] = new boolean[n];
    int result = 0;
    for (int i = 0; i < n; i++) {
      if (!visited[i]) {
        result += 1;
        dfs(g, visited, i);
      }
    }
    return result;
  }

  public static void main(String[] args) {
    int graph[][] = { { 1, 0, 0 }, { 0, 1, 0 }, { 0, 0, 1 } };
    System.out.println(numComponents(graph));

  }
}
