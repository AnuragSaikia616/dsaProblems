public class longestPrefix {
  public static String longestPrefix(String s) {
    int lps[] = makeLSP(s);
    return s.substring(0, lps[s.length() - 1]);
  }

  public static int[] makeLSP(String s) {
    int i = 1, len = 0;
    int lsp[] = new int[s.length()];
    while (i < s.length()) {
      if (s.charAt(i) == s.charAt(len)) {
        lsp[i] = len + 1;
        len++;
        i++;
      } else {
        if (len != 0) {
          len = lsp[len - 1];
        } else {
          len = 0;
          i++;
        }
      }
    }
    return lsp;
  }

  public static void main(String[] args) {
    String s = "ababab";
    System.out.println(longestPrefix(s));

  }
}
