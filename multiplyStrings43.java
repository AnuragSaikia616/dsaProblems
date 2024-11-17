public class multiplyStrings43 {

  public static String multiply(String num1, String num2) {
    int n = num1.length();
    int m = num2.length();
    int res[] = new int[n + m];
    for (int i = n - 1; i >= 0; i--) {
      for (int j = m - 1; j >= 0; j--) {
        int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
        int sum = res[i + j + 1] + mul;
        res[i + j + 1] = sum % 10;
        res[i + j] += sum / 10;
      }
    }
    String ans = "";
    if (res[0] != 0)
      ans += '0';
    for (int i = 1; i < n + m; i++) {
      System.out.println(res[i]);
      ans = ans + (char) (res[i] + '0');
    }
    return ans;
  }

  public static void main(String[] args) {
    System.out.println(multiply("132", "456"));
  }
}
