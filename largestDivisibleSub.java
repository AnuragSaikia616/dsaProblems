import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class largestDivisibleSub {
  public static List<Integer> largestDivisibleSubset(int nums[]) {
    int n = nums.length;
    Arrays.sort(nums);
    int dp[] = new int[n];
    int prev[] = new int[n];
    Arrays.fill(dp, 1);
    Arrays.fill(prev, -1);
    int max = 1;
    int lastindex = 0;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < i; j++) {
        if (nums[i] % nums[j] == 0 && dp[i] < dp[j] + 1) {
          dp[i] = dp[j] + 1;
          prev[i] = j;
        }
      }
      if (dp[i] > max) {
        max = dp[i];
        lastindex = i;
      }

    }

    List<Integer> ans = new ArrayList<>();
    while (lastindex != -1) {
      ans.add(nums[lastindex]);
      lastindex = prev[lastindex];
    }
    Collections.reverse(ans);

    return ans;
  }

  public static void main(String[] args) {
    int nums[] = { 4, 8, 10, 240 };
    System.out.println(largestDivisibleSubset(nums));

  }
}
