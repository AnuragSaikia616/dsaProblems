// LONGEST PALINDROMIC SUBSEQ

public class LPS {
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

  // public static int longPalindromicSub(int s, int ind, int subs) {
  //
  // }

  public static void main(String[] args) {
    System.out.println(isPalindrome("malayalam"));

  }
}
