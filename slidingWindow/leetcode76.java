// 76. Minimum Window Substring
//
// Given two strings s and t of lengths m and n respectively, return the minimum
// window
// substring
// of s such that every character in t (including duplicates) is included in the
// window. If there is no such substring, return the empty string "".
//
// The testcases will be generated such that the answer is unique.
/**
 * leetcode76
 */
public class leetcode76 {
  public static String minWindow(String s, String t) {
    String answer = "";
    int anslen = Integer.MAX_VALUE;
    int charmap[] = new int[256];
    for (char c : t.toCharArray())
      charmap[c]++;
    int l = 0;
    int count = 0;
    for (int r = 0; r < s.length(); r++) {
      if (--charmap[s.charAt(r)] >= 0)
        count++;
      while (l <= r - t.length() + 1 && count == t.length()) {
        if (anslen > r - l + 1) {
          anslen = r - l + 1;
          answer = s.substring(l, r + 1);
        }
        if (++charmap[s.charAt(l)] > 0)
          count--;
        l++;
      }
    }
    return answer;
  }

  public static void main(String[] args) {
    String s[] = { "ADOBECODEBANC" };
    String t[] = { "ABC" };
    for (int i = 0; i < t.length; i++) {
      System.out.println(minWindow(s[i], t[i]));
    }

  }
}
