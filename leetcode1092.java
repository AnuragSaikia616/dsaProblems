// ------------------------------------------------------------------------------------------------------------------------
// leetcode1092: Shortest Common Supersequence
// Given two strings str1 and str2, return the shortest string that has both str1 and str2 as subsequences. 
// If there are multiple valid strings, return any of them.
// -------------------------------------------------------------------------------------------------------------------------

import java.util.Arrays;

public class leetcode1092 {
  public static String LCS(String X, String Y) {
    int n = X.length();
    int m = Y.length();
    String memo[][] = new String[n][m];
    for (String row[] : memo)
      Arrays.fill(row, null);
    return LCShelper(X, Y, n - 1, m - 1, memo);
  }

  public static String LCShelper(String s1, String s2, int i, int j, String memo[][]) {
    if (i < 0 || j < 0) {
      return "";
    }
    if (memo[i][j] != null)
      return memo[i][j];
    if (s1.charAt(i) == s2.charAt(j)) {
      return memo[i][j] = s1.charAt(i) + LCShelper(s1, s2, i - 1, j - 1, memo);
    }
    String l1 = LCShelper(s1, s2, i - 1, j, memo);
    String l2 = LCShelper(s1, s2, i, j - 1, memo);
    return memo[i][j] = (l1.length() > l2.length()) ? l1 : l2;
  }

  public static String newLCS(String X, String Y) {
    int m = X.length();
    int n = Y.length();
    String[][] dp = new String[m + 1][n + 1];
    String curr[] = new String[n + 1];
    String prev[] = new String[n + 1];
    Arrays.fill(curr, "");
    Arrays.fill(prev, "");
    for (int i = 0; i <= m; i++) {
      for (int j = 0; j <= n; j++) {
        dp[i][j] = "";
      }
    }

    // Fill the dp table
    for (int i = 1; i <= m; i++) {
      for (int j = 1; j <= n; j++) {
        if (X.charAt(i - 1) == Y.charAt(j - 1)) {
          curr[j] = X.charAt(i - 1) + prev[j - 1];
        } else {
          curr[j] = (prev[j].length() > curr[j - 1].length()) ? prev[j] : curr[j - 1];
        }
      }
      prev = curr;
    }

    return reverse(curr[n]);

  }

  public static String SCS(String X, String Y) {
    String[][] memo = new String[X.length() + 1][Y.length() + 1];
    for (String row[] : memo) {
      Arrays.fill(row, null);
    }
    String lcsString = newLCS(X, Y);
    StringBuilder scs = new StringBuilder();
    int i = 0, j = 0, k = 0;

    while (k < lcsString.length()) {
      while (i < X.length() && X.charAt(i) != lcsString.charAt(k)) {
        scs.append(X.charAt(i++));
      }
      while (j < Y.length() && Y.charAt(j) != lcsString.charAt(k)) {
        scs.append(Y.charAt(j++));
      }
      scs.append(lcsString.charAt(k++));
      i++;
      j++;
    }

    // Append remaining characters
    while (i < X.length()) {
      scs.append(X.charAt(i++));
    }
    while (j < Y.length()) {
      scs.append(Y.charAt(j++));
    }

    return scs.toString();
  }

  public static String reverse(String str) {
    StringBuilder s = new StringBuilder();
    int l = str.length();
    for (int i = 0; i < l; i++) {
      s.insert(0, str.charAt(i));
    }
    return s.toString();
  }

  public static void main(String[] args) {
    // String[][] input = { { "abc", "cab" }, { "aaa", "aaaaa" }, { "xyz", "abc" },
    // { "xaby", "haiblk" } };
    // for (String[] s : input) {
    // System.out.println(SCS(s[0], s[1]));
    // }
    System.out.println(newLCS("bbababbb", "bbbaaaba"));
    System.out.println(LCS("bbababbb", "bbbaaaba"));
  }
}
