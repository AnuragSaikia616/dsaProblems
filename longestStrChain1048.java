import java.util.*;

/**
 * longestStrChain1048
 */
public class longestStrChain1048 {
  public static int longestStrChain(String words[]) {
    int n = words.length;
    int ans = 1;
    int dp[] = new int[n];
    Arrays.fill(dp, 1);
    List<String> sortedwords = new ArrayList<>(Arrays.asList(words));
    sortedwords.sort((a, b) -> Integer.compare(a.length(), b.length()));
    System.out.println(sortedwords);
    for (int i = 1; i < n; i++) {
      for (int j = 0; j < i; j++) {
        if (isPred(sortedwords.get(j), sortedwords.get(i)) && dp[i] < dp[j] + 1) {
          System.out.println(sortedwords.get(j));
          System.out.println(sortedwords.get(i));
          dp[i] = dp[j] + 1;
        }
      }
      ans = Math.max(ans, dp[i]);
    }

    return ans;
  }

  public static boolean isPred(String a, String b) {
    if (a.length() + 1 != b.length())
      return false;
    int i = 0, j = 0;
    while (i < a.length()) {
      if (a.charAt(i) != b.charAt(j)) {
        j++;
        if (j > i + 1)
          return false;
      } else {
        i++;
        j++;
      }
    }
    return true;
  }

  public static void main(String[] args) {
    String words[] = { "bccbcbfea", "dccdcafaaeb", "eaef", "eec", "bbedafdeceb", "ffcabbbbced", "dcbcb", "ddb",
        "bddcbcfcd", "bfddddfbeac", "efafdeadee", "aae", "baacc", "f", "daddf", "bfbbed", "cdefbea", "cdeabcebfecf",
        "ecacdaa", "bfc", "bbbcc", "ebbeaefbedc", "ddd", "dedf", "baefd", "efccaab", "bdebadbefdb", "b", "bea" };
    System.out.println(longestStrChain(words));
    // System.out.println(isPred("aae", "eaef"));
  }
}
