public class leetcode583 {

  public static int LCS(String s1, String s2, int i1, int i2) {
    if (i1 == 0 && i2 == 0) {
      return (s1.charAt(i1) == s2.charAt(i2)) ? 1 : 0;
    }
    if (i1 == 0) {
      return (s1.charAt(i1) == s2.charAt(i2)) ? 1 : LCS(s1, s2, i1, i2 - 1);
    }
    if (i2 == 0) {
      return (s1.charAt(i1) == s2.charAt(i2)) ? 1 : LCS(s1, s2, i1 - 1, i2);
    }

    if (s1.charAt(i1) == s2.charAt(i2)) {
      return 1 + LCS(s1, s2, i1 - 1, i2 - 1);
    }
    return Math.max(LCS(s1, s2, i1 - 1, i2), LCS(s1, s2, i1, i2 - 1));

  }

  public static void main(String[] args) {
    String[][] input = { { "sea", "eat" }, { "leetcode", "etco" }, { "a", "ab" }, { "a", "b" }, { "abc", "def" } };
    for (String[] words : input) {
      int l1 = words[0].length();
      int l2 = words[1].length();
      int lcs = LCS(words[0], words[1], l1 - 1, l2 - 1);
      int result = (l1 - lcs) + (l2 - lcs);
      System.out.println("lcs=" + lcs + "  result=" + result);

    }

  }
}
