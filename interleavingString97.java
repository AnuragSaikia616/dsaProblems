import java.util.Arrays;

public class interleavingString97 {
  public static boolean isInterleave(String s1, String s2, String s3) {
    if (s1.length() + s2.length() != s3.length())
      return false;

    int dp[][] = new int[s1.length() + 1][s2.length() + 1];
    for (int row[] : dp)
      Arrays.fill(row, -1);
    return solve(s1, s2, s3, 0, 0, dp);
  }

  public static boolean solve(String s1, String s2, String s3, int i, int j, int dp[][]) {
    if (i + j == s3.length())
      return true;
    if (dp[i][j] != -1) {
      return dp[i][j] == 1 ? true : false;
    }

    boolean ans = false;
    if (i < s1.length() && s1.charAt(i) == s3.charAt(i + j))
      ans = ans || solve(s1, s2, s3, i + 1, j, dp);
    if (j < s2.length() && s2.charAt(j) == s3.charAt(i + j))
      ans = ans || solve(s1, s2, s3, i, j + 1, dp);

    dp[i][j] = ans ? 1 : 0;
    return ans;
  }

  public static boolean solve(String s1, String s2, String s3) {
    if (s1.length() + s2.length() != s3.length())
      return false;
    int n = s1.length(), m = s2.length();
    boolean dp[][] = new boolean[n + 1][m + 1];
    dp[n][m] = true;
    for (int i = n; i >= 0; i--) {
      for (int j = m; j >= 0; j--) {
        if (i < n && s1.charAt(i) == s3.charAt(i + j))
          dp[i][j] = dp[i][j] || dp[i + 1][j];
        if (j < m && s2.charAt(j) == s3.charAt(i + j))
          dp[i][j] = dp[i][j] || dp[i][j + 1];
      }
    }
    return dp[0][0];
  }

  public static void main(String[] args) {

    System.out.println(solve("aabcc", "dbbca", "aadbbcbcac"));
  }
}
