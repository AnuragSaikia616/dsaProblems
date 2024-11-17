
// 309. Best Time to Buy and Sell Stock with Cooldown
// Medium
//
// You are given an array prices where prices[i] is the price of a given stock on the ith day.
//
// Find the maximum profit you can achieve. You may complete as many transactions as you like (i.e., buy one and sell one share of the stock multiple times) with the following restrictions:
//
//     After you sell your stock, you cannot buy stock on the next day (i.e., cooldown one day).
//
// Note: You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).
import java.util.Arrays;

public class leetcode309 {
  public static int maxProfit(int[] prices) {
    int n = prices.length;
    int dp[][] = new int[n][2];
    for (int row[] : dp) {
      Arrays.fill(row, -1);
    }
    return maxProfitSolve(prices, 0, 1, dp);
  }

  public static int maxProfitSolve(int[] prices, int ind, int canbuy, int dp[][]) {
    if (ind >= prices.length)
      return 0;
    if (dp[ind][canbuy] != -1)
      return dp[ind][canbuy];
    int profit = 0;
    if (canbuy == 1) {
      profit = Math.max(-prices[ind] + maxProfitSolve(prices, ind + 1, 0, dp),
          0 + maxProfitSolve(prices, ind + 1, 1, dp));
      dp[ind][canbuy] = profit;
      return profit;
    }
    if (canbuy == 0) {
      profit = Math.max(prices[ind] + maxProfitSolve(prices, ind + 2, 1, dp),
          0 + maxProfitSolve(prices, ind + 1, 0, dp));
      dp[ind][canbuy] = profit;
      return profit;
    }
    return profit;
  }

  public static void main(String[] args) {
    int prices[] = { 1, 2, 3, 0, 2 };
    System.out.println(maxProfit(prices));

  }
}
