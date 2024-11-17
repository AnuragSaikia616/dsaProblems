
// 188. Best Time to Buy and Sell Stock IV
// Hard
// Topics
// Companies
//
// You are given an integer array prices where prices[i] is the price of a given stock on the ith day, and an integer k.
//
// Find the maximum profit you can achieve. You may complete at most k transactions: i.e. you may buy at most k times and sell at most k times.
//
// Note: You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).
import java.util.Arrays;

public class leetcode188 {
  public static int maxProfit(int prices[], int k) {
    int n = prices.length;
    int dp[][][] = new int[n + 1][2][k + 1];
    for (int a[][] : dp) {
      for (int b[] : a) {
        Arrays.fill(b, -1);
      }
    }
    return maxProfitSolver(prices, 0, 1, k, dp);
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
    int prices[] = { 1, 2, 0, 2 };
    int k = 2;
    System.out.println(maxProfit(prices, k));

  }
}
