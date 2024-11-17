import java.util.LinkedList;
import java.util.Queue;

/**
 * leetcode542542. 01 Matrix
 * Medium
 * 
 * Given an m x n binary matrix mat, return the distance of the nearest 0 for
 * each cell.
 * 
 * The distance between two adjacent cells is 1.
 */
public class leetcode542 {
  public static class Node {
    public int x;
    public int y;
    public int d;

    public Node(int x, int y, int d) {
      this.x = x;
      this.y = y;
      this.d = d;
    }
  }

  public static void updateMatrix(int mat[][]) {
    int nr = mat.length;
    int nc = mat[0].length;
    Queue<Node> q = new LinkedList<>();
    for (int i = 0; i < nr; i++) {
      for (int j = 0; j < nc; j++) {
        if (mat[i][j] == 0) {
          q.add(new Node(i, j, 0));
        }
      }
    }
    boolean visited[][] = new boolean[nr][nc];
    while (!q.isEmpty()) {
      int l = q.size();
      while (l > 0) {
        Node n = q.poll();
        int x = n.x;
        int y = n.y;
        int d = n.d;
        if (mat[x][y] != 0 && !visited[x][y]) {
          mat[x][y] = d;
        }
        visited[x][y] = true;
        if (x + 1 < nr && !visited[x + 1][y]) {
          q.add(new Node(x + 1, y, d + 1));
        }
        if (x - 1 >= 0 && !visited[x - 1][y]) {
          q.add(new Node(x - 1, y, d + 1));
        }
        if (y + 1 < nc && !visited[x][y + 1]) {
          q.add(new Node(x, y + 1, d + 1));
        }
        if (y - 1 >= 0 && !visited[x][y - 1]) {
          q.add(new Node(x, y - 1, d + 1));
        }
        l--;
      }
    }
  }

  public static void main(String[] args) {
    int mat[][] = { { 0, 0, 0 }, { 0, 1, 0 }, { 1, 1, 1 } };
    updateMatrix(mat);
    for (int row[] : mat) {
      for (int val : row) {
        System.out.print(val);
      }
      System.out.println();
    }

  }
}
