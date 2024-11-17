import java.sql.*;
import java.util.Arrays;

public class minAbsDiffPart {

  static int minDiffPart(int[] nums, int ind, int taken, int sum, int totsum, int[][] dp) {
    if (taken == nums.length / 2) {
      int diff = Math.abs(2 * sum - totsum);
      return Math.min(dp[ind][sum], diff);
    }
    if (ind == 0) {
      if (taken == nums.length / 2 - 1) {
        sum += nums[ind];
        int diff = Math.abs(2 * sum - totsum);
        return Math.min(dp[ind][sum], diff);
      } else {
        return Integer.MAX_VALUE;
      }
    }
    if (dp[ind][sum] != Integer.MAX_VALUE)
      return dp[ind][sum];

    int pick = minDiffPart(nums, ind - 1, taken + 1, sum + nums[ind], totsum, dp);
    int notpick = minDiffPart(nums, ind - 1, taken, sum, totsum, dp);

    return Math.min(pick, notpick);

  }

  public static void main(String[] args) throws SQLException {

    int nums[] = { 2, 5, 7, 9 };
    int n = nums.length;
    int totsum = 0;
    for (int num : nums) {
      totsum += num;
    }

    int[][] dp = new int[n][totsum];
    for (int row[] : dp)
      Arrays.fill(row, Integer.MAX_VALUE);

    int output = minDiffPart(nums, n - 1, 0, 0, totsum, dp);
    System.out.println(output);

    // Connection conn = DriverManager
    // .getConnection("jdbc:mysql://localhost:3306/snippetbox?user=anurag&password=anurag616");
    //
    // Statement st = conn.createStatement();
    // ResultSet rs = st.executeQuery("SELECT * from snippets");
    // while (rs.next()) {
    // String title;
    // title = rs.getString("title");
    // System.out.println(title);
  }

}
