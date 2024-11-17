// 122. Best Time to Buy and Sell Stock II
// Medium
// Topics
// Companies
//
// You are given an integer array prices where prices[i] is the price of a given stock on the ith day.
//
// On each day, you may decide to buy and/or sell the stock. You can only hold at most one share of the stock at any time. However, you can buy it then immediately sell it on the same day.
//
// Find and return the maximum profit you can achieve.

import java.util.Arrays;

public class leetcode122 {
  public static int maxProfit(int[] prices) {
    int n = prices.length;
    int dp[][] = new int[n][2];
    for (int row[] : dp) {
      Arrays.fill(row, -1);
    }
    return maxProfitSolve(prices, 0, 1, dp);
  }

  public static int maxProfitSolve(int[] prices, int ind, int canbuy, int dp[][]) {
    if (ind == prices.length)
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
      profit = Math.max(prices[ind] + maxProfitSolve(prices, ind + 1, 1, dp),
          0 + maxProfitSolve(prices, ind + 1, 0, dp));
      dp[ind][canbuy] = profit;
      return profit;
    }
    return profit;
  }

  public static int maxProfitTab(int[] prices) {
    int n = prices.length;
    int dp[][] = new int[n + 1][2];
    dp[n][0] = dp[n][1] = 0;
    int profit = 0;
    for (int ind = n - 1; ind >= 0; ind--) {
      for (int canbuy = 0; canbuy <= 1; canbuy++) {
        if (canbuy == 1) {
          profit = Math.max(-prices[ind] + dp[ind + 1][0], 0 + dp[ind + 1][1]);
        }
        if (canbuy == 0) {
          profit = Math.max(prices[ind] + dp[ind + 1][1], 0 + dp[ind + 1][0]);
        }
        dp[ind][canbuy] = profit;
      }
    }
    return profit;
  }

  public static int maxProfitTabSpace(int[] prices) {
    int n = prices.length;
    int prev[] = new int[2];
    int curr[] = new int[2];
    prev[0] = prev[1] = 0;
    int profit = 0;
    for (int ind = n - 1; ind >= 0; ind--) {
      for (int canbuy = 0; canbuy <= 1; canbuy++) {
        if (canbuy == 1) {
          profit = Math.max(-prices[ind] + prev[0], 0 + prev[1]);
        }
        if (canbuy == 0) {
          profit = Math.max(prices[ind] + prev[1], 0 + prev[0]);
        }
        curr[canbuy] = profit;
        prev = curr.clone();
      }
    }
    return profit;
  }

  public static void main(String[] args) {
    int inputs[][] = { { 7, 1, 5, 3, 6, 4 } };
    for (int prices[] : inputs) {
      System.out.println(maxProfit(prices));
      System.out.println(maxProfitTab(prices));
      System.out.println(maxProfitTabSpace(prices));
    }
  }
}
