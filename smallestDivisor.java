import java.util.*;

public class smallestDivisor {
  public static int smallestDivisor(int nums[], int threshold) {
    int l = 1;
    int r = Integer.MIN_VALUE;
    for (int num : nums) {
      r = Math.max(r, num);
    }
    int ans = r;
    while (l <= r) {
      int mid = l + (r - l) / 2;
      if (getSum(nums, mid) > threshold) {
        l = mid + 1;
      } else {
        r = mid - 1;
        ans = Math.min(ans, mid);
      }
    }
    return ans;
  }

  public static int getSum(int nums[], int div) {
    int sum = 0;
    for (int num : nums) {
      sum += (num + div - 1) / div;
    }
    return sum;
  }

  public static void main(String[] args) {
    int nums[] = { 5, 6, 7 };
    int th = 100;
    System.out.println(smallestDivisor(nums, th));
  }
}
