public class TakeKOfEachCharacterFromLeftAndRight2561 {
  public static int takeCharacters(String s, int k) {
    final int count[] = { 0, 0, 0 };
    for (char c : s.toCharArray()) {
      count[c - 'a'] += 1;
    }
    if (!isValid(count, k))
      return -1;
    int i = 0, j = 0;
    int ans = Integer.MAX_VALUE;
    while (i < s.length()) {
      count[s.charAt(i) - 'a']--;
      i++;
      if (!isValid(count, k)) {
        count[s.charAt(j) - 'a']++;
        j++;
      }
      ans = Math.min(ans, s.length() - (i - j));
    }
    return ans;
  }

  public static boolean isValid(int arr[], int k) {
    for (int val : arr) {
      if (val < k) {
        return false;
      }
    }
    return true;
  }

  public static void main(String[] args) {
    String s = "aabaaaacabc";
    System.out.println(takeCharacters(s, 2));
  }
}
