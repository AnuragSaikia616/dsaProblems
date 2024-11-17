// 200. Number of Islands
// Medium
//
// Given an m x n 2D binary grid grid which represents a map of '1's (land) and
// '0's (water), return the number of islands.
//
// An island is surrounded by water and is formed by connecting adjacent lands
// horizontally or vertically. You may assume all four edges of the grid are all
// surrounded by water.

import java.util.Stack;

/**
 * leetcode200
 */
public class leetcode200 {

  // Not a very good solution
  public static void dfs(char grid[][], int i, int j, boolean visited[][]) {
    Stack<int[]> st = new Stack<>();
    st.push(new int[] { i, j });
    while (!st.isEmpty()) {
      int curr[] = st.pop();
      int r = curr[0];
      int c = curr[1];
      if (r < 0 || r >= grid.length || c < 0 || c >= grid[0].length || grid[r][c] == '0') {
        continue;
      }
      if (!visited[r][c]) {
        visited[r][c] = true;
        st.push(new int[] { r - 1, c });
        st.push(new int[] { r + 1, c });
        st.push(new int[] { r, c + 1 });
        st.push(new int[] { r, c - 1 });
      }
    }
  }

  public static int numIsIsland(char[][] grid) {
    int nr = grid.length;
    int nc = grid[0].length;

    boolean visited[][] = new boolean[nr][nc];
    int result = 0;
    for (int i = 0; i < nr; i++) {
      for (int j = 0; j < nc; j++) {
        if (grid[i][j] == '1' && !visited[i][j]) {
          result += 1;
          dfs(grid, i, j, visited);
        }
      }
    }
    return result;
  }

  // probably a better solution
  public static int numIslands(char[][] grid) {
    int nr = grid.length;
    int nc = grid[0].length;
    int count = 0;
    for (int i = 0; i < nr; i++) {
      for (int j = 0; j < nc; j++) {
        if (grid[i][j] == '1') {
          count++;
          newDfs(grid, i, j);
        }
      }
    }
    return count;
  }

  public static void newDfs(char grid[][], int i, int j) {
    if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == '0')
      return;
    grid[i][j] = '0';
    newDfs(grid, i + 1, j);
    newDfs(grid, i - 1, j);
    newDfs(grid, i, j + 1);
    newDfs(grid, i, j - 1);
  }

  public static void main(String[] args) {
    char[][] grid = {
        { '1', '1', '1', '1', '0' },
        { '1', '1', '0', '1', '0' },
        { '1', '1', '0', '0', '0' },
        { '0', '0', '0', '1', '0' }, };
    System.out.println(numIslands(grid));
  }
}
