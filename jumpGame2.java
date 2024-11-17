import java.util.Arrays;

public class jumpGame2 {
  public static int jump(int[] nums) {
    int n = nums.length;
    int dp[] = new int[n];
    Arrays.fill(dp, -1);
    return solve(nums, 0, dp);
  }

  public static int solve(int nums[], int i, int dp[]) {
    if (i == nums.length - 1)
      return 0;
    if (dp[i] != -1)
      return dp[i];

    int mini = nums.length;
    for (int k = 1; k <= nums[i]; k++) {
      if (i + k < nums.length)
        mini = Math.min(mini, 1 + solve(nums, i + k, dp));
    }
    return dp[i] = mini;
  }

  public static int solve(int nums[]) {
    int n = nums.length;
    int dp[] = new int[n];
    for (int i = nums.length - 2; i >= 0; i--) {
      int mini = nums.length;
      for (int k = 1; k <= nums[i]; k++) {
        if (i + k < nums.length)
          mini = Math.min(mini, 1 + dp[i + k]);
      }
      dp[i] = mini;
    }
    return dp[0];
  }

  public static void main(String[] args) {
    int nums[] = { 1, 2, 1, 1 };
    System.out.println(solve(nums));

  }
}
