public class splitArray410 {
  public static int splitArray(int nums[], int k) {
    int l = 0, r = 0;
    for (int val : nums) {
      l = Math.max(l, val);
      r += val;
    }
    while (l <= r) {
      int mid = l + (r - l) / 2;
      if (checkSplit(nums, mid) >= k) {
        l = mid + 1;
      } else {
        r = mid - 1;
      }
    }
    return l;
  }

  public static int checkSplit(int nums[], int limit) {
    int splits = 0;
    int sum = 0;
    for (int num : nums) {
      if (sum + num <= limit) {
        sum += num;
      } else {
        splits++;
        sum = num;
      }
    }
    return splits;
  }

  public static void main(String[] args) {
    int nums[] = { 1, 4, 4 };
    int k = 3;
    System.out.println(splitArray(nums, k));

  }
}
