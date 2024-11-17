/**
 * leetcode930
 */
public class leetcode930 {

  public static int numSubarraysWithSum(int nums[], int goal) {
    int answer = 0;
    int n = nums.length;
    int sum = 0, l = 0;
    if (goal == 0) {
      int zeroes = 0;
      for (int num : nums) {
        if (num == 0) {
          zeroes++;
        }
      }
      return zeroes * (zeroes + 1) / 2;

    }
    for (int r = 0; r < n; r++) {
      sum += nums[r];
      while (l <= r && sum > goal) {
        sum -= nums[l];
        l++;
      }
      if (sum == goal) {
        int templ = l;
        while (templ <= r && nums[templ] == 0) {
          answer++;
          templ++;
        }
        answer++;
      }
    }

    return answer;
  }

  public static void main(String[] args) {
    int nums[] = { 1, 0, 1, 0, 1 };
    int goal = 1;
    System.out.println(numSubarraysWithSum(nums, goal));
  }
}
