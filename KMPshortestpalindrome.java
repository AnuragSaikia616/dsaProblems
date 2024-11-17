import java.util.*;

public class KMPshortestpalindrome {
  public static String shortestPalindrome(String s) {
    StringBuilder sb = new StringBuilder(s);
    String temp = s + "#" + sb.reverse();
    int lsp[] = makeLSP(temp);
    int ind = lsp[temp.length() - 1];
    StringBuilder rev = new StringBuilder(s.substring(ind, s.length()));
    return rev.reverse() + s;
  }

  public static int[] makeLSP(String s) {
    int len = 0, i = 1;
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
          lsp[i] = 0;
          i++;
        }
      }
    }
    return lsp;
  }

  public static void main(String[] args) {
    String s = "aacecaaaaaa";
    System.out.println(shortestPalindrome(s));

  }
}
