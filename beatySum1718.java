public class beatySum1718 {
  public static int beautySum(String s) {
    int n = s.length();
    int beautySum = 0;
    for (int i = 0; i < n; i++) {
      int hm[] = new int[26];
      for (int j = i; j < n; j++) {
        hm[s.charAt(j) - 'a']++;
        int maxi = Integer.MIN_VALUE;
        int mini = Integer.MAX_VALUE;
        for (int k = 0; k < 26; k++) {
          int val = hm[k];
          if (hm[k] > 0) {
            maxi = Math.max(maxi, val);
            mini = Math.min(mini, val);
          }
        }
        int beauty = maxi - mini;
        beautySum += beauty;
      }
    }

    return beautySum;
  }

  public static void main(String[] args) {
    String ss[] = { "aabcb", "aabcbaa" };
    for (String s : ss) {
      System.out.println(beautySum(s));
    }

  }
}
