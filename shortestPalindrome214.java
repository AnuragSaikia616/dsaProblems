import java.util.*;

public class shortestPalindrome214 {
  public static String shortestPalindrome(String s) {
    if (s.length() == 0)
      return "";
    StringBuilder sb = new StringBuilder(s);
    int n = s.length();
    for (int i = n - 1; i >= 0; i--) {
      if (isPalindrome(sb.substring(0, i + 1))) {
        if (i == n - 1) {
          return (s);
        } else {
          String r = sb.substring(i + 1, n);
          sb = new StringBuilder(r);
          return sb.reverse() + s;
        }
      }
    }
    String r = sb.substring(1, n);
    sb = new StringBuilder(r);
    return sb.reverse() + s;
  }

  public static boolean isPalindrome(String s) {
    int l = 0, r = s.length() - 1;
    while (l < r) {
      if (s.charAt(l) != s.charAt(r))
        return false;
      l++;
      r--;
    }
    return true;
  }

  public static void main(String[] args) {
    String input[] = { "abaXYZ", "aba", "abaX", "abcd", "Xaba", "" };
    for (String s : input) {
      System.out.println(shortestPalindrome(s));
    }
  }
}
