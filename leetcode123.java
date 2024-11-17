// 123. Best Time to Buy and Sell Stock III
// Hard
// Topics
// Companies
//
// You are given an array prices where prices[i] is the price of a given stock on the ith day.
//
// Find the maximum profit you can achieve. You may complete at most two transactions.
//
// Note: You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).

import java.util.Arrays;

public class leetcode123 {
  public static int maxProfit(int prices[]) {
    int n = prices.length;
    int dp[][][] = new int[n + 1][2][3];
    for (int a[][] : dp) {
      for (int b[] : a) {
        Arrays.fill(b, -1);
      }
    }
    return maxProfitSolver(prices, 0, 1, 2, dp);
  }

  public static int maxProfitSolver(int prices[], int ind, int canbuy, int cap, int dp[][][]) {
    if (ind == prices.length || cap == 0)
      return 0;
    if (dp[ind][canbuy][cap] != -1)
      return dp[ind][canbuy][cap];
    if (canbuy == 1) {
      return dp[ind][canbuy][cap] = Math.max(-prices[ind] + maxProfitSolver(prices, ind + 1, 0, cap, dp),
          maxProfitSolver(prices, ind + 1, 1, cap, dp));
    } else {
      return dp[ind][canbuy][cap] = Math.max(prices[ind] + maxProfitSolver(prices, ind + 1, 1, cap - 1, dp),
          maxProfitSolver(prices, ind + 1, 0, cap, dp));
    }
  }

  public static void main(String[] args) {
    int inputs[][] = { { 3, 3, 5, 0, 0, 3, 1, 4 } };
    for (int prices[] : inputs) {
      System.out.println(maxProfit(prices));
    }

  }
}
