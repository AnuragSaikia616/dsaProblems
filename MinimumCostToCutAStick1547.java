import java.util.Arrays;

public class MinimumCostToCutAStick1547 {
  public static int minCost(int n, int cuts[]) {
    int len = cuts.length;
    int arr[] = new int[len + 2];
    for (int i = 0; i < len; i++) {
      arr[i + 1] = cuts[i];
    }
    arr[0] = 0;
    arr[len + 1] = n;
    Arrays.sort(arr);
    int dp[][] = new int[len + 1][len + 1];
    for (int row[] : dp) {
      Arrays.fill(row, -1);
    }
    return f(1, len, arr, dp);
  }

  public static int f(int i, int j, int cuts[], int dp[][]) {
    if (i > j)
      return 0;

    if (dp[i][j] != -1)
      return dp[i][j];
    int mini = Integer.MAX_VALUE;
    for (int k = i; k <= j; k++) {
      int ans = cuts[j + 1] - cuts[i - 1] + f(i, k - 1, cuts, dp) + f(k + 1, j, cuts, dp);
      mini = Math.min(mini, ans);
    }
    return dp[i][j] = mini;
  }

  public static void main(String[] args) {
    int cuts[] = { 1, 3, 4, 5 };
    System.out.println(minCost(7, cuts));

  }
}
