public class countAndSay38 {

  public static String countAndSay(int n) {
    if (n == 1)
      return "1";
    String s = countAndSay(n - 1);
    int count = 0;
    char prev = s.charAt(0);
    count = 1;
    String ans = "";
    for (int i = 1; i < s.length(); i++) {
      if (s.charAt(i) != prev) {
        ans += String.valueOf(count);
        ans += prev;
        count = 0;
        prev = s.charAt(i);
      }
      count++;
    }
    ans += String.valueOf(count);
    ans += prev;

    return ans;
  }

  public static void main(String[] args) {
    int inputs[] = { 4, 1 };
    for (int inp : inputs) {
      System.out.println(countAndSay(inp));
    }

  }
}
