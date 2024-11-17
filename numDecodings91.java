import java.util.Arrays;

public class numDecodings91 {
  public static int numDecodings(String s) {
    int dp[] = new int[s.length()];
    Arrays.fill(dp, -1);
    return solve(s, 0, dp);
  }

  public static int solve(String s, int ind, int dp[]) {
    if (ind == s.length())
      return 1;
    if (s.charAt(ind) == '0')
      return 0;
    if (dp[ind] != -1)
      return dp[ind];
    int res = solve(s, ind + 1, dp);
    if (ind < s.length() - 1
        && (s.charAt(ind) - '0' == 1 || (s.charAt(ind) - '0' == 2 && s.charAt(ind + 1) - '0' <= 6))) {
      res += solve(s, ind + 2, dp);
    }
    return dp[ind] = res;
  }

  public static int solveBU(String s) {
    int n = s.length();
    int dp[] = new int[n + 1];
    dp[n] = 1;
    for (int ind = n - 1; ind >= 0; ind--) {
      if (s.charAt(ind) == '0') {
        dp[ind] = 0;
      } else {
        int res = dp[ind + 1];
        if (ind < s.length() - 1
            && (s.charAt(ind) - '0' == 1 || (s.charAt(ind) - '0' == 2 && s.charAt(ind + 1) - '0' <= 6))) {
          res += dp[ind + 2];
        }
        dp[ind] = res;
      }
    }
    return dp[0];
  }

  public static void main(String[] args) {
    System.out.println(solveBU("12"));
  }
}
