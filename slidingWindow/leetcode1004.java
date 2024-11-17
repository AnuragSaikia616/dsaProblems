/**
 * leetcode1004
 */
public class leetcode1004 {

  public static int longestOnes(int nums[], int k) {
    int answer = 0;
    int n = nums.length;
    for (int i = 0; i < n; i++) {
      int av = k;
      int count = 0;
      int next = -1;
      for (int j = i; j < n; j++) {
        if (next == -1 && nums[j] == 0) {
          next = j + 1;
        }

        if (nums[j] == 1) {
          count++;
        } else if (nums[j] == 0 && av > 0) {
          count++;
          av--;
        } else {
          break;
        }
      }
      if (next != -1)
        i = next - 1;
      answer = Math.max(answer, count);
    }

    return answer;
  }

  public static int newlongestOnes(int[] nums, int k) {
    int i = 0, j = 0;
    while (j < nums.length) {
      if (nums[j] == 0) {
        k--;
      }
      if (k < 0) {
        if (nums[i] == 0) {
          k++;
        }
        i++;
      }
      j++;
    }
    return j - i;
  }

  public static void main(String[] args) {
    int input[][] = { { 1, 1, 0, 0, 0, 1, 1, 1 }, { 1, 0, 1, 0, 1, 0, 0, 1, 1 }, { 0, 0, 0, 0, 0, 1 }, { 1, 1, 1 } };
    int k[] = { 0, 2, 5, 5 };
    for (int i = 0; i < input.length; i++) {
      System.out.println(newlongestOnes(input[i], k[i]));
    }
  }
}
