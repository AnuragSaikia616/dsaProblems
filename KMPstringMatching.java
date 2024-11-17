public class KMPstringMatching {
  public static int KMP(String s, String p) {
    int i = 0, j = 0;
    int n = s.length(), m = p.length();
    int lps[] = getLPS(p);
    while (i < n) {
      if (s.charAt(i) == p.charAt(j)) {
        i++;
        j++;
      } else {
        if (j > 0)
          j = lps[j - 1];
        else
          i++;
      }
      if (j == m)
        return i - j;
    }
    return -1;
  }

  public static int[] getLPS(String p) {
    int lps[] = new int[p.length()];
    int len = 0;
    int i = 1;
    while (i < p.length()) {
      if (p.charAt(i) == p.charAt(len)) {
        lps[i] = len + 1;
        len++;
        i++;
      } else {
        if (len != 0) {
          len = lps[len - 1];
        } else {
          lps[i] = 0;
          i += 1;
        }
      }
    }

    return lps;
  }

  public static void main(String[] args) {
    String s = "onionyonions";
    String p = "onions";
    System.out.println(KMP(s, p));

  }

}
