import java.util.Arrays;

public class minimumMountainRemovals1671 {

  public static int minimumMountainRemovals1(int nums[]) {
    int n = nums.length;
    int incDP[] = new int[n];
    int decDP[] = new int[n];
    Arrays.fill(incDP, 1);
    Arrays.fill(decDP, 1);
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < i; j++) {
        if (nums[i] > nums[j])
          incDP[i] = Math.max(incDP[i], incDP[j] + 1);
      }
    }
    for (int i = 0; i < n; i++) {
      for (int j = i; j < n; j++) {
        if (nums[i] > nums[j])
          decDP[i] = Math.max(decDP[i], decDP[j] + 1);
      }
    }
    int longest = 0;
    for (int i = 0; i < n; i++) {
      longest = Math.max(incDP[i] + decDP[i], longest);
    }
    return n - longest;
  }

  public static void main(String[] args) {
    int nums[] = { 9, 8, 1, 7, 6, 5, 4, 3, 2, 1 };
    System.out.println(minimumMountainRemovals1(nums));
  }
}
