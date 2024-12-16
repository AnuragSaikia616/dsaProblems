import java.util.Arrays;

public class LongestIncreasingPathInMatrix329 {

  public static int longestIncreasingPath(int mat[][]) {
    int m = mat.length;
    int n = mat[0].length;

    int dp[][] = new int[m][n];
    for (int row[] : dp)
      Arrays.fill(row, -1);

    int ans = 0;
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        ans = Math.max(ans, f(mat, i, j, dp));
      }
    }

    return ans + 1;
  }

  public static int f(int mat[][], int i, int j, int dp[][]) {
    if (i < 0 || j < 0 || i >= mat.length || j >= mat[0].length) {
      return 0;
    }
    if (dp[i][j] != -1)
      return dp[i][j];

    int ans = 0;
    if (i + 1 < mat.length && mat[i][j] < mat[i + 1][j]) {
      ans = Math.max(ans, f(mat, i + 1, j, dp) + 1);
    }
    if (i - 1 >= 0 && mat[i][j] < mat[i - 1][j]) {
      ans = Math.max(ans, f(mat, i - 1, j, dp) + 1);
    }
    if (j + 1 < mat[0].length && mat[i][j] < mat[i][j + 1]) {
      ans = Math.max(ans, f(mat, i, j + 1, dp) + 1);
    }
    if (j - 1 >= 0 && mat[i][j] < mat[i][j - 1]) {
      ans = Math.max(ans, f(mat, i, j - 1, dp) + 1);
    }
    return dp[i][j] = ans;
  }

  public static void main(String[] args) {
    // int mat[][] = { { 9, 9, 4 }, { 6, 6, 8 }, { 2, 1, 1 } };
    int mat[][] = { { 0, 1, 2 } };
    System.out.println(longestIncreasingPath(mat));

  }
}
