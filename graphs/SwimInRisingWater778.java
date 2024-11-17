import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class SwimInRisingWater778 {
  public static int swimInWater(int grid[][]) {
    int n = grid.length;
    int ans = 0;
    Queue<Node> pq = new PriorityQueue<>((x, y) -> Integer.compare(x.val, y.val));
    pq.add(new Node(0, 0, grid[0][0]));
    boolean visited[][] = new boolean[n][n];
    while (!pq.isEmpty()) {
      Node curr = pq.poll();
      ans = Math.max(ans, curr.val);
      int i = curr.i;
      int j = curr.j;
      if (i + 1 == n && j + 1 == n)
        return ans;
      if (!visited[i][j]) {
        visited[i][j] = true;
        if (i + 1 < n)
          pq.add(new Node(i + 1, j, grid[i + 1][j]));
        if (i - 1 >= 0)
          pq.add(new Node(i - 1, j, grid[i - 1][j]));
        if (j + 1 < n)
          pq.add(new Node(i, j + 1, grid[i][j + 1]));
        if (j - 1 >= 0)
          pq.add(new Node(i, j - 1, grid[i][j - 1]));
      }
    }

    return ans;
  }

  static class Node {
    int i, j, val;

    public Node(int i, int j, int val) {
      this.i = i;
      this.j = j;
      this.val = val;
    }

  }

  public static void main(String[] args) {
    // int grid[][] = { { 0, 1, 2, 3, 4 }, { 24, 23, 22, 21, 5 }, { 12, 13, 14, 15,
    // 16 }, { 11, 17, 18, 19, 20 },
    // { 10, 9, 8, 7, 6 } };
    int grid[][] = { { 0, 3 }, { 2, 1 } };
    System.out.println(swimInWater(grid));

  }
}
