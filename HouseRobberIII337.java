import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

import javax.swing.tree.TreeNode;

public class HouseRobberIII337 {
  public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
      this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
      this.val = val;
      this.left = left;
      this.right = right;
    }
  }

  /**
   * Pair
   */
  public record Pair(TreeNode node, boolean canrob) {
  }

  public static int rob(TreeNode root) {
    Map<Pair, Integer> dp = new HashMap<>();
    return Math.max(solve(root, true, dp), solve(root, false, dp));
  }

  public static int solve(TreeNode node, boolean canrob, Map<Pair, Integer> dp) {
    if (node == null)
      return 0;
    Pair p = new Pair(node, canrob);
    if (dp.containsKey(p))
      return dp.get(p);
    int res = 0;
    if (canrob) {
      int take = node.val + solve(node.left, false, dp) + solve(node.right, false, dp);
      int nottake = solve(node.left, true, dp) + solve(node.right, true, dp);
      res = Math.max(take, nottake);
    } else {
      res = solve(node.left, true, dp) + solve(node.right, true, dp);
    }
    dp.put(p, res);
    return res;
  }

  public static void main(String[] args) {

  }
}
