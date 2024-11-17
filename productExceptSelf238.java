public class productExceptSelf238 {
  public static int[] productExceptSelf(int nums[]) {
    int n = nums.length;
    int pre[] = new int[n];
    int suf[] = new int[n];
    pre[0] = nums[0];
    suf[n - 1] = nums[n - 1];
    for (int i = 1; i < n; i++) {
      pre[i] = pre[i - 1] * nums[i];
      suf[n - 1 - i] = suf[n - i] * nums[n - 1 - i];
    }
    nums[0] = suf[1];
    nums[n - 1] = pre[n - 2];
    for (int i = 1; i < n - 1; i++) {
      nums[i] = pre[i - 1] * suf[i + 1];
    }

    return nums;
  }

  public static void main(String[] args) {

  }
}
