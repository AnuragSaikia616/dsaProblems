import java.util.ArrayList;
import java.util.Stack;

/**
 * leetcode207207. Course Schedule
 * Solved
 * Medium
 * Topics
 * Companies
 * Hint
 * 
 * There are a total of numCourses courses you have to take, labeled from 0 to
 * numCourses - 1. You are given an array prerequisites where prerequisites[i] =
 * [ai, bi] indicates that you must take course bi first if you want to take
 * course ai.
 * 
 * For example, the pair [0, 1], indicates that to take course 0 you have to
 * first take course 1.
 * 
 * Return true if you can finish all courses. Otherwise, return false.
 */
public class leetcode207 {

  static Stack<Integer> topo = new Stack<>();

  public static int[] canFinish(int numCourses, int[][] prerequisites) {
    ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    for (int i = 0; i < numCourses; i++) {
      graph.add(new ArrayList<>());
    }
    for (int[] edge : prerequisites) {
      int source = edge[1];
      int destination = edge[0];
      graph.get(source).add(destination);
    }
    boolean vis[] = new boolean[numCourses];
    boolean inlane[] = new boolean[numCourses];
    for (int i = 0; i < numCourses; i++) {
      if (!dfs(graph, vis, inlane, i))
        return (new int[0]);
    }
    int result[] = new int[numCourses];
    for (int i = 0; i < numCourses; i++) {
      result[numCourses - i - 1] = topo.pop();
    }
    return result;
  }

  public static boolean dfs(ArrayList<ArrayList<Integer>> graph, boolean visited[], boolean inlane[], int source) {
    visited[source] = true;
    inlane[source] = true;
    for (int nei : graph.get(source)) {
      if (inlane[nei])
        return false;
      if (!visited[nei]) {
        if (dfs(graph, visited, inlane, nei) == false)
          return false;
      }
    }
    if (!topo.contains(source))
      topo.push(source);
    inlane[source] = false;
    return true;
  }

  public static void main(String[] args) {
    int numCourses = 4;
    // int prerequisites[][] = { { 0, 1 } };
    // int prerequisites[][] = { { 1, 0 }, { 0, 1 } };
    int prerequisites[][] = { { 3, 0 }, { 0, 1 } };
    // int prerequisites[][] = { { 1, 0 }, { 2, 0 }, { 0, 2 } };
    // int prerequisites[][] = { { 2, 5 }, { 3, 2 }, { 1, 3 }, { 0, 5 }, { 0, 4 }, {
    // 1, 4 } };
    int answer[] = canFinish(numCourses, prerequisites);
    for (int val : answer)
      System.out.println(val);
  }
}
