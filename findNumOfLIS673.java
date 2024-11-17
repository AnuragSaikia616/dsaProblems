import java.util.Arrays;
import java.util.Collections;

/**
 * findNumOfLIS673
 */
public class findNumOfLIS673 {

  public static int findNumberOfLIS(int nums[]) {
    int n = nums.length;
    int dp[] = new int[n];
    Arrays.fill(dp, 1);
    int maxi = 1;
    int ans[] = new int[n + 1];
    Arrays.fill(ans, 0);
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < i; j++) {
        if (nums[i] > nums[j]) {
          if (dp[i] == dp[j] + 1) {
            ans[dp[i]]++;
          }
          if (dp[i] < dp[j] + 1) {
            dp[i] = dp[j] + 1;
            ans[dp[i]] += ans[dp[j]]++;
          }
        }
      }
      if (dp[i] == maxi)
        ans[dp[i]]++;
      maxi = Math.max(maxi, dp[i]);
    }

    return ans[maxi];
  }

  public static void main(String[] args) {
    int nums[] = { 1, 2, 3, 4, 5, 6, 1, 1 };
    System.out.println(findNumberOfLIS(nums));

  }
}
