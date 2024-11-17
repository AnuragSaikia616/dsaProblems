import java.util.Arrays;

public class regularExpressionMatching10 {
  public static boolean isMatch(String s, String p) {
    int dp[][] = new int[s.length() + 1][p.length() + 1];
    for (int row[] : dp) {
      Arrays.fill(row, -1);
    }
    return matcher(s, p, 0, 0, dp);
  }

  public static boolean matcher(String s, String p, int i, int j, int dp[][]) {
    if (i >= s.length() && j >= p.length())
      return true;
    if (j >= p.length())
      return false;
    if (dp[i][j] != -1)
      return dp[i][j] == 0 ? false : true;
    boolean match = i < s.length() && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.');
    if (j + 1 < p.length() && p.charAt(j + 1) == '*') {
      boolean m = matcher(s, p, i, j + 2, dp) || (match && matcher(s, p, i + 1, j, dp));
      dp[i][j] = m == true ? 1 : 0;
      return m;
    }
    boolean m = match && matcher(s, p, i + 1, j + 1, dp);
    dp[i][j] = m == true ? 1 : 0;
    return m;
  }

  public static void main(String[] args) {
    System.out.println(isMatch("aab", "a*"));
  }
}
