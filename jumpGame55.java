import java.util.*;

public class jumpGame55 {
  public static boolean canJump(int nums[], int ind, int dp[]) {
    if (ind > nums.length - 1)
      return false;
    if (ind == nums.length - 1)
      return true;
    if (dp[ind] != -1) {
      return dp[ind] == 1 ? true : false;
    }
    int len = nums[ind];
    boolean can = false;
    while (len > 0) {
      can = can || canJump(nums, ind + len, dp);
      len--;
      if (can == true)
        return true;
    }

    if (can == true)
      dp[ind] = 1;
    else
      dp[ind] = 0;
    return can;
  }

  public static void main(String[] args) {
    int inputs[][] = { { 2, 3, 1, 1, 4 }, { 3, 2, 1, 0, 4 } };
    for (int nums[] : inputs) {
      int dp[] = new int[nums.length];
      Arrays.fill(dp, -1);
      System.out.println(canJump(nums, 0, dp));
    }
  }
}
