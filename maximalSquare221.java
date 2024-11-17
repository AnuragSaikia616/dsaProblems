import java.util.Arrays;

public class maximalSquare221 {
  static int answer = 0;

  public static int maximalSquare(char[][] matrix) {
    int dp[][] = new int[matrix.length][matrix[0].length];
    for (int row[] : dp)
      Arrays.fill(row, -1);
    solver(matrix, matrix.length - 1, matrix[0].length - 1, dp);
    return answer * answer;
  }

  public static int solver(char[][] matrix, int i, int j, int dp[][]) {
    if (i < 0 || j < 0)
      return 0;
    if (dp[i][j] != -1)
      return dp[i][j];
    int diag = solver(matrix, i - 1, j - 1, dp);
    int up = solver(matrix, i - 1, j, dp);
    int left = solver(matrix, i, j - 1, dp);
    int curr = matrix[i][j] == '1' ? 1 + Math.min(diag, Math.min(up, left)) : 0;
    answer = Math.max(answer, curr);
    return dp[i][j] = curr;
  }

  public static void main(String[] args) {
    char mat[][] = { { '1', '1', '1', '1' }, { '1', '1', '1', '0' } };
    System.out.println(maximalSquare(mat));
  }
}
