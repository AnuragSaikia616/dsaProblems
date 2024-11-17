public class repeatedstringmatch686 {
  public static int repeatedstringmatch(String a, String b) {
    int na = a.length();
    int nb = b.length();
    for (int i = 0; i < na; i++) {
      if (a.charAt(i) == b.charAt(0)) {
        int j;
        for (j = 0; j < nb; j++) {
          if (a.charAt((i + j) % na) != b.charAt(j)) {
            break;
          }
        }
        if (j != nb)
          continue;
        int ans = (nb + i) / na;
        if ((nb + i) % na > 0)
          ans++;
        return ans;
      }
    }

    return -1;
  }

  public static void main(String[] args) {
    String a = "abcabcabcabc";
    String b = "abac";
    System.out.println(repeatedstringmatch(a, b));
  }
}
