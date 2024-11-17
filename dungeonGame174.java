import java.util.Arrays;

public class dungeonGame174 {

  public static int calculateMinimumHP(int D[][]) {
    int m = D.length;
    int n = D[0].length;
    int dp[][] = new int[m][n];
    for (int row[] : dp)
      Arrays.fill(row, Integer.MAX_VALUE);
    return helper(D, 0, 0, dp);
  }

  public static int helper(int grid[][], int i, int j, int dp[][]) {
    if (i == grid.length - 1 && j == grid[0].length - 1) {
      return grid[i][j] >= 0 ? 1 : 1 - grid[i][j];
    }
    if (i == grid.length || j == grid[0].length) {
      return Integer.MAX_VALUE;
    }
    if (dp[i][j] != Integer.MAX_VALUE)
      return dp[i][j];
    int right = helper(grid, i, j + 1, dp);
    int down = helper(grid, i + 1, j, dp);
    int minHealth = Math.min(right, down) - grid[i][j];
    return dp[i][j] = minHealth <= 0 ? 1 : minHealth;
  }

  public static void main(String[] args) {
    // int D[][] = { { 1, -3, 3 }, { 0, -2, 0 }, { -3, -3, -3 } };
    int D[][] = { { -2, -3, 3 }, { -5, -10, 1 }, { 10, 30, -5 } };
    System.out.println(calculateMinimumHP(D));
  }
}
