import java.util.Arrays;

public class minInsertions {

  public static int minInsertCount(String str, int lp, int rp, int[][] dp) {
    if (rp <= lp)
      return 0;
    int min = Integer.MAX_VALUE;
    if (dp[lp][rp] != -1)
      return dp[lp][rp];
    if (str.charAt(rp) == str.charAt(lp)) {
      return Math.min(min, minInsertCount(str, lp + 1, rp - 1, dp));
    }
    min = Math.min(min, Math.min(minInsertCount(str, lp + 1, rp, dp) + 1, minInsertCount(str, lp, rp - 1, dp) + 1));
    return min;

  }

  public static void main(String[] args) {
    String strs[] = { "a", "aa", "madbam", "mbadm", "leetcode" };
    for (String st : strs) {
      int[][] dp = new int[st.length()][st.length()];
      for (int i = 0; i < dp.length; i++) {
        Arrays.fill(dp[i], -1);
      }
      System.out.println(minInsertCount(st, 0, st.length() - 1, dp));
    }

  }

}
