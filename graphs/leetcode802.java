import java.util.*;

/**
 * leetcode802
 */
public class leetcode802 {

  public static List<Integer> eventualSafeNodes(int graph[][]) {

    int n = graph.length;
    boolean visited[] = new boolean[n];
    boolean inlane[] = new boolean[n];
    boolean isterminal[] = new boolean[n];
    Arrays.fill(isterminal, true);
    List<Integer> terminals = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      if (!dfs(graph, visited, inlane, isterminal, i)) {
        isterminal[i] = false;
      }
    }

    for (int i = 0; i < isterminal.length; i++) {
      if (isterminal[i])
        terminals.add(i);
    }
    return terminals;
  }

  public static boolean dfs(int graph[][], boolean vis[], boolean inlane[], boolean isterm[], int source) {
    vis[source] = true;
    inlane[source] = true;
    for (int nei : graph[source]) {
      if (inlane[nei]) {
        isterm[nei] = false;
        return false;
      }
      if (!vis[nei]) {
        if (dfs(graph, vis, inlane, isterm, nei) == false) {
          isterm[nei] = false;
          return false;
        }
      }
    }
    inlane[source] = false;
    return true;
  }

  public static void main(String[] args) {
    // int graph[][] = { { 1, 2 }, { 2, 3 }, { 5 }, { 0 }, { 5 }, {}, {} };
    // int graph[][] = { {}, {}, { 3 }, { 1 }, { 0, 1 }, { 0, 2 } };
    int graph[][] = { { 1, 2, 3, 4 }, { 1, 2 }, { 3, 4 }, { 0, 4 }, {} };
    var answer = eventualSafeNodes(graph);
    for (int val : answer)
      System.out.println(val);
  }
}
