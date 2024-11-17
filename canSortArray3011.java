public class canSortArray3011 {
  public static boolean canSortArray(int nums[]) {
    int prevmax = 0;
    int currmin = 0;
    int currmax = 0;
    int currbits = 0;
    for (int val : nums) {
      int nsetbits = Integer.bitCount(val);
      if (currmin < prevmax)
        return false;
      if (nsetbits == currbits) {
        currmin = Math.min(currmin, val);
        currmax = Math.max(currmax, val);
      } else {
        prevmax = currmax;
        currmin = currmax = val;
        currbits = nsetbits;
      }
    }
    return true;
  }

  public static void main(String[] args) {
    int nums[] = { 8, 4, 2, 30, 15 };
    System.out.println(canSortArray(nums));
  }
}
