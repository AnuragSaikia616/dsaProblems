import java.util.PriorityQueue;

public class HouseRobberIV2560 {
  public static int minCapability(int nums[], int k) {
    int right = 0, left = 0;
    for (int val : nums) {
      right = Math.max(right, val);
    }
    while (left < right) {
      int mid = left + (right - left) / 2;
      if (getMaxPossibleCountWithLim(nums, mid) >= k) {
        right = mid;
      } else {
        left = mid + 1;
      }
    }
    return left;
  }

  public static int getMaxPossibleCountWithLim(int nums[], int maxu) {
    int taken = 0;

    for (int i = 0; i < nums.length; i++) {
      if (nums[i] <= maxu) {
        taken++;
        i++;
      }
    }
    return taken;
  }

  public static void main(String[] args) {
    int nums[] = { 2, 3, 5, 9 };
    System.out.println(minCapability(nums, 2));
  }
}
