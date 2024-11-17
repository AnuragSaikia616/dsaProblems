public class leetcode1248 {

  public static int numberOfSubarrays(int nums[], int k) {
    int n = nums.length;
    int answer = 0;
    int oddcount = 0;
    int l = 0;
    for (int r = 0; r < n; r++) {
      if (nums[r] % 2 != 0)
        oddcount++;
      while (l <= r - k + 1 && oddcount > k) {
        if (nums[l] % 2 != 0)
          oddcount--;
        l++;
      }
      if (oddcount == k) {
        int temp = l;
        while (temp <= r - k + 1 && nums[temp] % 2 == 0) {
          answer++;
          temp++;
        }
        answer++;
      }
    }
    return answer;
  }

  public static void main(String[] args) {
    int input[][] = { { 2, 2, 1, 1, 1 }, { 2, 2, 1 }, { 1, 2, 2, 2 } };
    int k[] = { 3, 1, 1 };
    for (int i = 0; i < input.length; i++) {
      System.out.println(numberOfSubarrays(input[i], k[i]));
    }

  }
}
