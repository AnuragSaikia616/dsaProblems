public class maxProduct152 {

  public static int maxProduct(int[] nums) {
    int answer = Integer.MIN_VALUE;
    for (int start = 0; start < nums.length; start++) {
      int prod = 1;
      for (int end = start; end < nums.length; end++) {
        prod *= nums[end];
        answer = Math.max(answer, prod);
      }
    }
    return answer;
  }

  public static void main(String[] args) {
    int nums[] = { 2, 3, -1, 4 };
    System.out.println(maxProduct(nums));
  }
}
