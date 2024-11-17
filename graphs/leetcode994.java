import java.util.LinkedList;
import java.util.Queue;

/**
 * leetcode994
 * 994. Rotting Oranges
 * Medium
 * 
 * You are given an m x n grid where each cell can have one of three values:
 * 
 * 0 representing an empty cell,
 * 1 representing a fresh orange, or
 * 2 representing a rotten orange.
 * 
 * Every minute, any fresh orange that is 4-directionally adjacent to a rotten
 * orange becomes rotten.
 * 
 * Return the minimum number of minutes that must elapse until no cell has a
 * fresh orange. If this is impossible, return -1.
 */
public class leetcode994 {
  public static class Orange {
    private int x;
    private int y;

    public Orange(int x, int y) {
      this.x = x;
      this.y = y;
    }

    public int getx() {
      return x;
    }

    public int gety() {
      return y;
    }
  }

  public static int orangesRotting(int grid[][]) {
    int nr = grid.length;
    int nc = grid[0].length;
    int freshCount = 0;
    Queue<Orange> q = new LinkedList<>();
    for (int i = 0; i < nr; i++) {
      for (int j = 0; j < nc; j++) {
        if (grid[i][j] == 2) {
          q.add(new Orange(i, j));
        }
        if (grid[i][j] == 1) {
          freshCount += 1;
        }
      }
    }
    if (freshCount == 0)
      return 0;
    if (q.isEmpty())
      return -1;

    int count = 0;
    int fresh = 0;
    while (!q.isEmpty()) {
      int n = q.size();
      while (n > 0) {
        Orange o = q.poll();
        int x = o.getx();
        int y = o.gety();
        if (x - 1 >= 0 && grid[x - 1][y] == 1) {
          grid[x - 1][y] = 2;
          q.add(new Orange(x - 1, y));
          fresh++;
        }
        if (y - 1 >= 0 && grid[x][y - 1] == 1) {
          grid[x][y - 1] = 2;
          q.add(new Orange(x, y - 1));
          fresh++;
        }
        if (x + 1 < grid.length && grid[x + 1][y] == 1) {
          grid[x + 1][y] = 2;
          q.add(new Orange(x + 1, y));
          fresh++;
        }
        if (y + 1 < grid[0].length && grid[x][y + 1] == 1) {
          grid[x][y + 1] = 2;
          q.add(new Orange(x, y + 1));
          fresh++;
        }
        n -= 1;
      }
      count += 1;
    }
    if (fresh < freshCount)
      return -1;
    return count - 1;
  }

  public static void main(String[] args) {
    // int grid[][] = { { 0, 2 } };
    // int[][] grid = { { 2, 1, 1 }, { 1, 1, 0 }, { 0, 1, 1 } };
    // System.out.println(orangesRotting(grid));
  }
}
