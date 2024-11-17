import java.io.BufferedReader;
import java.io.InputStreamReader;

public class theUnlucky13 {
  static final long mod = 1000000009;
  static long dp[] = new long[1000000009];

  public static long solve(int n) {
    if (n == 0)
      return dp[n] = 1;
    if (n == 1)
      return dp[n] = 10;
    if (dp[n] != 0)
      return dp[n];
    int part1 = n / 2;
    if (n % 2 == 0) {
      dp[n] = ((solve(part1) * solve(part1)) % mod - (solve(part1 - 1) * solve(part1 - 1)) % mod) % mod;
    } else {
      dp[n] = ((solve(part1) * solve(n - part1)) % mod
          - (solve(part1 - 1) * solve(n - part1 - 1)) % mod) % mod;
    }
    return dp[n] = (dp[n] + mod) % mod;
  }

  public static long newSolve(int n) {
    long dp[] = new long[n + 1];
    for (int i = 2; i < dp.length; i++) {
      int part = i / 2;
      if (i % 2 == 0)
        dp[i] = (dp[part] * dp[part] - dp[part - 1] * dp[part - 1]) % mod;
      else
        dp[i] = (dp[part] * dp[i - part] - dp[part - 1] * dp[i - part - 1]) % mod;
    }
    return dp[n] = (dp[n] + mod) % mod;
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int t = Integer.parseInt(br.readLine());
    while (t-- > 0) {
      long n = Integer.parseInt(br.readLine());
      System.out.println(solve((int) (n % mod)));
      // System.out.println(newSolve((int) n));
    }
  }
}
