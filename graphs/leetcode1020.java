/**
 * leetcode1020
 */
public class leetcode1020 {

  public static int numEnclaves(int grid[][]) {
    int nr = grid.length;
    int nc = grid[0].length;
    boolean visited[][] = new boolean[nr][nc];
    for (int i = 0; i < nr; i++) {
      if (!visited[i][0])
        dfs(grid, i, 0, visited);
      if (!visited[i][nc - 1])
        dfs(grid, i, nc - 1, visited);
    }
    for (int j = 0; j < nc; j++) {
      if (!visited[0][j])
        dfs(grid, 0, j, visited);
      if (!visited[nr - 1][j])
        dfs(grid, nr - 1, j, visited);
    }
    return count(grid, visited);
  }

  public static void dfs(int grid[][], int i, int j, boolean visited[][]) {
    if (i < 0 || j < 0 || i == grid.length || j == grid[0].length || grid[i][j] == 0 || visited[i][j])
      return;
    visited[i][j] = true;
    dfs(grid, i - 1, j, visited);
    dfs(grid, i + 1, j, visited);
    dfs(grid, i, j - 1, visited);
    dfs(grid, i, j + 1, visited);
  }

  public static int count(int grid[][], boolean visited[][]) {
    int count = 0;
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[0].length; j++) {
        if (grid[i][j] == 1 && !visited[i][j])
          count += 1;
      }
    }
    return count;
  }

  public static void main(String[] args) {
    int grid[][] = { { 0, 0, 0, 0 }, { 1, 0, 1, 0, }, { 0, 1, 1, 0 }, { 0, 0, 0, 0 } };
    System.out.println(numEnclaves(grid));
  }
}
