import java.lang.reflect.Array;
import java.util.Arrays;

public class longIncSubQ {

  public static int solve(int nums[], int i, int dp[][], int prev) {
    if (i == -1) {
      return 0;
    }
    if (dp[i][prev + 1] != -1)
      return dp[i][prev + 1];
    int nottake = solve(nums, i - 1, dp, prev);
    int take = 0;
    if (prev == -1 || nums[i] < nums[prev])
      take = 1 + solve(nums, i - 1, dp, i);
    return dp[i][prev + 1] = Math.max(nottake, take);
  }

  public static int newSolve(int nums[]) {
    int n = nums.length;
    int dp[][] = new int[n + 1][n + 1];
    for (int row[] : dp)
      Arrays.fill(row, 0);
    for (int i = 0; i < n; i++) {
      for (int prev = i - 1; prev >= -1; prev--) {
        int nottake = dp[i][prev + 1];
        int take = 0;
        if (prev == -1 || nums[i] < nums[prev]) {
          take = 1 + dp[i][i + 1];
        }
        dp[i + 1][prev + 1] = Math.max(nottake, take);
      }
    }
    int max = 0;
    for (int val : dp[n]) {
      max = Math.max(max, val);
    }
    return max;
  }

  public static void main(String[] args) {
    int nums[] = { 10, 1, 2, 3, 4, 100, 20 };
    int n = nums.length;
    int dp[][] = new int[n][n + 1];
    for (int row[] : dp) {
      Arrays.fill(row, -1);
    }
    // System.out.println(solve(nums, nums.length - 1, dp, -1));
    System.out.println(newSolve(nums));

  }
}
