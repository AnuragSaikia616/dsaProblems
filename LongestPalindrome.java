import java.util.Arrays;

public class LongestPalindrome {
  static public int longestPalindrome(String s, int start, int end, int[][] dp) {
    if (start > end)
      return 0;
    if (start == end) {
      return 1;
    }
    if (dp[start][end] != 0) {
      return dp[start][end];
    }
    if (s.charAt(start) == s.charAt(end)) {
      return 2 + longestPalindrome(s, start + 1, end - 1, dp);
    }
    int movee = longestPalindrome(s, start + 1, end, dp);
    int moveb = longestPalindrome(s, start, end - 1, dp);
    return dp[start][end] = Math.max(movee, moveb);

  }

  static public int bottomUp(String s, int[][] dp) {
    int l = s.length();
    for (int i = 0; i < l; i++) {
      for (int j = 0; j < l; j++) {
        if (i > j)
          dp[i][j] = 0;
        if (i == j)
          dp[i][j] = 1;
      }
    }

    int start = 0;
    int end = l - 1;

  }

  public static void main(String[] args) {
    String[] strs = { "bbbbb", "cbbd", "bbb" };
    for (String str : strs) {
      int l = str.length();
      int[][] dp = new int[l][l];
      for (int i = 0; i < l; i++) {
        Arrays.fill(dp[i], 0);
      }
      System.out.println(longestPalindrome(str, 0, l - 1, dp));
      System.out.println(bottomUp(str, dp));
    }
  }

}
