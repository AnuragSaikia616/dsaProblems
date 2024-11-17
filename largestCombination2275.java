public class largestCombination2275 {
  public static int largestCombination(int nums[]) {
    int n = nums.length;
    int answer = 0;
    for (int i = 0; i < 32; i++) {
      int curr = 0;
      for (int j = 0; i < n; j++) {
        curr += nums[j] & 1;
        nums[j] = nums[j] >> 1;
      }
      answer = Math.max(answer, curr);
    }

    return answer;
  }

  public static void main(String[] args) {

  }
}
