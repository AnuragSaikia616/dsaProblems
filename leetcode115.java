// 115. Distinct Subsequences
// Hard
// Topics
// Companies
//
// Given two strings s and t, return the number of distinct subsequences of s which equals t.
//
// The test cases are generated so that the answer fits on a 32-bit signed integer.

import java.util.Arrays;

public class leetcode115 {
  public static int distinctSubsequences(String s, String t) {
    int l1 = s.length();
    int l2 = t.length();
    int memo[][] = new int[l1][l2];
    for (int row[] : memo) {
      Arrays.fill(row, -1);
    }
    return solve(s, t, l1 - 1, l2 - 1, memo);
  }

  public static int solve(String s, String t, int l1, int l2, int memo[][]) {
    if (l2 < 0) {
      return 1;
    }
    if (l1 < 0) {
      return 0;
    }
    if (memo[l1][l2] != -1) {
      return memo[l1][l2];
    }

    if (s.charAt(l1) == t.charAt(l2)) {
      int pick = solve(s, t, l1 - 1, l2 - 1, memo);
      int notpick = solve(s, t, l1 - 1, l2, memo);
      return memo[l1][l2] = pick + notpick;
    }
    return memo[l1][l2] = solve(s, t, l1 - 1, l2, memo);

  }

  public static int solveUP(String s, String t) {
    int m = s.length();
    int n = t.length();
    int dp[][] = new int[m + 1][n + 1];
    for (int i = 0; i < m + 1; i++)
      dp[i][0] = 1;
    for (int i = 1; i < n + 1; i++)
      dp[0][i] = 0;
    for (int i = 1; i < m + 1; i++) {
      for (int j = 1; j < n + 1; j++) {
        if (s.charAt(i - 1) == t.charAt(j - 1)) {
          dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
        } else {
          dp[i][j] = dp[i - 1][j];
        }
      }
    }
    return dp[m][n];
  }

  // space optimization
  public static int newSolve(String s, String t) {
    int m = s.length();
    int n = t.length();
    int dp[] = new int[n + 1];
    dp[0] = 1;
    for (int i = 1; i < m + 1; i++) {
      for (int j = n; j >= 1; j--) {
        if (s.charAt(i - 1) == t.charAt(j - 1)) {
          dp[j] = dp[j - 1] + dp[j];
        } else {
          dp[j] = dp[j];
        }
      }
    }
    return dp[n];
  }

  public static void main(String[] args) {
    String strs[][] = { { "rabbbit", "rabbit" } };
    for (String[] str : strs) {
      // System.out.println(distinctSubsequences(str[0], str[1]));
      // System.out.println(solveUP(str[0], str[1]));
      System.out.println(newSolve(str[0], str[1]));
    }
    // System.out.println("Anurag" == "Anurag");
  }
}
