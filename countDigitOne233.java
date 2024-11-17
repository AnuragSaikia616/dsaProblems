public class countDigitOne233 {
  public static int countDigitOne(int n) {
    int l = String.valueOf(n).length();
    return helper(n, l) + l;
  }

  public static int helper(int n, int l) {
    if (l == 1)
      return 1;
    if (n % 10 == 0) {

    } else {

    }
  }

  public static int nines(int len) {
    int val = 0;
    for (int i = 0; i < len; i++) {
      val = val * 10 + 9;
    }
    return val;
  }

  public static void main(String[] args) {
    System.out.println(countDigitOne(19));
  }
}
