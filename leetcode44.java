import java.util.Arrays;

public class leetcode44 {
  public static boolean wildMatch(String s, String p) {
    int l1 = s.length();
    int l2 = p.length();
    int dp[][] = new int[l1][l2];
    for (int row[] : dp) {
      Arrays.fill(row, -1);
    }
    return wildMatchSolve(s, p, l1 - 1, l2 - 1, dp) == 1 ? true : false;
  }

  public static int checkStars(String p, int j) {
    while (j >= 0 && p.charAt(j) == '*')
      j--;
    return (j < 0) ? 1 : 0;
  }

  public static int wildMatchSolve(String s, String p, int i, int j, int dp[][]) {
    if (i < 0 && j < 0)
      return 1;
    if (i < 0)
      return checkStars(p, j);
    if (j < 0)
      return 0;
    if (dp[i][j] != -1)
      return dp[i][j];
    if (p.charAt(j) == '?' || p.charAt(j) == s.charAt(i)) {
      return dp[i][j] = wildMatchSolve(s, p, i - 1, j - 1, dp);
    }
    if (p.charAt(j) == '*') {
      int multi = wildMatchSolve(s, p, i, j - 1, dp);
      int single = wildMatchSolve(s, p, i - 1, j, dp);
      return dp[i][j] = (multi == 1 || single == 1) ? 1 : 0;
    }
    return 0;
  }

  public static void main(String[] args) {
    String strs[][] = { { "adceb", "*a*b" }, { "abcde", "a?e" }, { "a", "****a"
    }, { "xaybWOWd", "?a?b*d" }, { "aa", "a" }, };
    for (String str[] : strs) {
      System.out.println(wildMatch(str[0], str[1]));
    }

  }
}
