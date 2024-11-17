import java.util.HashMap;
import java.util.Map;

/**
 * frogJump403
 */
public class frogJump403 {
  public static boolean canCross(int stones[]) {
    if (stones[1] > 1)
      return false;
    Map<String, Boolean> dp = new HashMap<>();
    return solve(stones, 1, 1, dp);
  }

  public static boolean solve(int stones[], int i, int prev, Map<String, Boolean> dp) {
    if (i == stones.length - 1)
      return true;
    String key = i + "," + prev;
    if (dp.containsKey(key)) {
      return dp.get(key);
    }
    boolean ans = false;
    for (int j = i + 1; j < stones.length; j++) {
      int req = stones[j] - stones[i];
      if (prev + 1 < req)
        break;
      if (prev - 1 == req)
        ans = ans || solve(stones, j, req, dp);
      if (prev + 1 == req)
        ans = ans || solve(stones, j, req, dp);
      if (prev == req)
        ans = ans || solve(stones, j, req, dp);
    }
    dp.put(key, ans);
    return ans;
  }

  public static void main(String[] args) {
    int input[][] = { { 0, 1, 3, 5, 6, 8, 12, 17 }, { 0, 2 }, { 0, 1 }, { 0, 1, 200 } };
    for (int stones[] : input) {
      System.out.println(canCross(stones));
    }
  }
}
