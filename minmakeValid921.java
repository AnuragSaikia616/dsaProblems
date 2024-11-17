public class minmakeValid921 {
  public static int minAddToMakeValid(String s) {
    int n = s.length();
    int o = 0, c = 0;
    int ans = 0;
    for (char p : s.toCharArray()) {
      if (p == '(') {
        o++;
      } else if (p == ')' && o == c) {
        ans++;
      } else {
        c++;
      }
    }
    ans += o - c;
    return ans;
  }

  public static void main(String[] args) {
    String ss[] = { ")))", "(", "()))(", ")))()(" };
    for (String s : ss) {
      System.out.println(minAddToMakeValid(s));
    }

  }
}
