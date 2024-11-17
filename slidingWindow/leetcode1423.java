public class leetcode1423 {
  public static int maxScore(int points[], int k) {
    int n = points.length;
    int i = k - 1;
    int j = k - 1;
    int count = 0;
    int sum = 0;
    int answer = Integer.MIN_VALUE;
    for (int it = 1; it <= 2 * k; it++) {
      if (j < 0)
        j = n - 1;
      sum += points[j];
      count++;
      if (count == k) {
        answer = Math.max(answer, sum);
        if (i >= 0) {
          sum -= points[i];
          i--;
          count--;
        }
      }
      j--;
    }

    return answer;
  }

  public static void main(String[] args) {
    int input[][] = { { 1, 2, 3, 4, 5, 6, 1 } };
    int k[] = { 3 };
    for (int i = 0; i < input.length; i++) {
      System.out.println(maxScore(input[i], k[i]));

    }

  }
}
