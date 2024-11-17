import java.util.*;

public class majElement229 {
  public static List<Integer> majorityElement(int nums[]) {
    int n = nums.length;
    List<Integer> ans = new ArrayList<>();
    Map<Integer, Integer> hash = new HashMap<>();
    for (int val : nums) {
      hash.put(val, hash.getOrDefault(val, 0) + 1);
      if (hash.get(val) > n / 3 && !ans.contains(val))
        ans.add(val);
    }

    return ans;
  }

  public static void main(String[] args) {
    int nums[] = { 3, 2, 3 };
    System.out.println(majorityElement(nums));

  }
}
