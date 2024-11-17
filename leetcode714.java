import java.util.Arrays;

public class leetcode714 {

  public static int maxProfit(int[] prices, int fee) {
    int n = prices.length;
    int dp[][] = new int[n][2];
    for (int row[] : dp) {
      Arrays.fill(row, -1);
    }
    return maxProfitSolve(prices, 0, 1, dp, fee);
  }

  public static int maxProfitSolve(int[] prices, int ind, int canbuy, int dp[][], int fee) {
    if (ind >= prices.length)
      return 0;
    if (dp[ind][canbuy] != -1)
      return dp[ind][canbuy];
    int profit = 0;
    if (canbuy == 1) {
      profit = Math.max(-prices[ind] + maxProfitSolve(prices, ind + 1, 0, dp, fee),
          0 + maxProfitSolve(prices, ind + 1, 1, dp, fee));
      dp[ind][canbuy] = profit;
      return profit;
    }
    if (canbuy == 0) {
      profit = Math.max(prices[ind] + maxProfitSolve(prices, ind + 1, 1, dp, fee) - fee,
          0 + maxProfitSolve(prices, ind + 1, 0, dp, fee));
      dp[ind][canbuy] = profit;
      return profit;
    }
    return profit;
  }

  public static void main(String[] args) {
    int prices[] = { 1, 3, 2, 8, 4, 9 };
    int fee = 2;
    System.out.println(maxProfit(prices, fee));

  }
}
