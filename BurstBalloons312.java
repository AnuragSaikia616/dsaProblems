import java.util.Arrays;

/**
 * BurstBalloons312
 */
public class BurstBalloons312 {
  public static int maxCoins(int nums[]) {
    int n = nums.length;
    int arr[] = new int[n + 2];
    for (int i = 0; i < arr.length; i++) {
      if (i == 0 || i == arr.length - 1) {
        arr[i] = 1;
      } else {
        arr[i] = nums[i - 1];
      }
    }
    int dp[][] = new int[n + 2][n + 2];
    for (int row[] : dp)
      Arrays.fill(row, -1);
    return solve(arr, 1, n, dp);
  }

  // memoization solution
  public static int solve(int nums[], int i, int j, int dp[][]) {
    if (i > j)
      return 0;
    if (dp[i][j] != -1)
      return dp[i][j];
    if (dp[i][j] != -1)
      return dp[i][j];
    int ans = 0;
    for (int k = i; k <= j; k++) {
      int cval = nums[k] * nums[i - 1] * nums[j + 1];
      ans = Math.max(ans, cval + solve(nums, i, k - 1, dp) + solve(nums, k + 1, j, dp));
    }
    return dp[i][j] = ans;
  }

  // bottom up solution
  public static int solve(int arr[]) {
    int n = arr.length;
    int nums[] = new int[n + 2];
    for (int i = 0; i < nums.length; i++) {
      if (i == 0 || i == nums.length - 1) {
        nums[i] = 1;
      } else {
        nums[i] = arr[i - 1];
      }
    }
    int dp[][] = new int[n + 2][n + 2];

    for (int i = n; i >= 1; i--) {
      for (int j = 1; j <= n; j++) {
        if (i > j)
          continue;
        int ans = 0;
        for (int k = i; k <= j; k++) {
          ans = Math.max(ans, nums[k] * nums[i - 1] * nums[j + 1] + dp[i][k - 1] + dp[k + 1][j]);
        }
        dp[i][j] = ans;
      }
    }
    return dp[1][n];
  }

  public static void main(String[] args) {
    int nums[] = { 3, 1, 5, 8 };
    System.out.println(solve(nums));
  }
}
