// 72. Edit Distance
// Medium
// Topics
// Companies
//
// Given two strings word1 and word2, return the minimum number of operations required to convert word1 to word2.
//
// You have the following three operations permitted on a word:
//
//     Insert a character
//     Delete a character
//     Replace a character

import java.util.Arrays;

public class leetcode72 {
  static public int editDistance(String word1, String word2) {
    int l1 = word1.length();
    int l2 = word2.length();
    int dp[][] = new int[l1][l2];
    for (int row[] : dp)
      Arrays.fill(row, -1);
    return solver(word1, word2, l1 - 1, l2 - 1, dp);
  }

  static public int solver(String p, String q, int i, int j, int[][] dp) {
    if (i < 0) {
      return j + 1;
    }
    if (j < 0) {
      return i + 1;
    }
    if (dp[i][j] != -1)
      return dp[i][j];
    if (p.charAt(i) == q.charAt(j)) {

      return dp[i][j] = solver(p, q, i - 1, j - 1, dp);
    }
    // if characters do not match we can replace/Delete
    int replace = solver(p, q, i - 1, j - 1, dp) + 1;
    int delete = solver(p, q, i - 1, j, dp) + 1;
    int insert = solver(p, q, i, j - 1, dp) + 1;
    return dp[i][j] = Math.min(replace, Math.min(delete, insert));
  }

  static public int editDistanceBUp(String word1, String word2) {
    int l1 = word1.length();
    int l2 = word2.length();
    int dp[][] = new int[l1 + 1][l2 + 1];
    for (int j = 0; j <= l2; j++) {
      dp[0][j] = j;
    }
    for (int i = 0; i <= l1; i++) {
      dp[i][0] = i;
    }
    for (int i = 1; i <= l1; i++) {
      for (int j = 1; j <= l2; j++) {
        if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
          dp[i][j] = dp[i - 1][j - 1];
        } else {
          int replace = dp[i - 1][j - 1] + 1;
          int delete = dp[i - 1][j] + 1;
          int insert = dp[i][j - 1] + 1;
          dp[i][j] = Math.min(replace, Math.min(delete, insert));
        }
      }
    }
    return dp[l1][l2];
  }

  static public int editDistanceSO(String word1, String word2) {
    int l1 = word1.length();
    int l2 = word2.length();
    int prev[] = new int[l2 + 1];
    for (int j = 0; j <= l2; j++)
      prev[j] = j;
    int curr[] = new int[l2 + 1];
    for (int i = 0; i <= l2; i++)
      curr[i] = i;

    for (int i = 1; i <= l1; i++) {
      curr[0] = i;
      for (int j = 1; j <= l2; j++) {
        if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
          curr[j] = prev[j - 1];
        } else {
          int replace = prev[j - 1] + 1;
          int delete = prev[j] + 1;
          int insert = curr[j - 1] + 1;
          curr[j] = Math.min(replace, Math.min(delete, insert));
        }
      }
      prev = curr.clone();
    }
    return curr[l2];
  }

  public static void main(String[] notargs) {
    String[][] input = { { "horse", "ros" }, { "xyz", "abc" }, { "axbzyc", "abcd" }, { "", "abc" } };
    for (String[] s : input) {
      System.out.println(editDistance(s[0], s[1]));
      System.out.println(editDistanceBUp(s[0], s[1]));
      System.out.println(editDistanceSO(s[0], s[1]));
    }

  }
}
