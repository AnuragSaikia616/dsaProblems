public class atoi {

  static int solve(String s) {
    int result = 0;
    boolean neg = false;
    int i = 0;
    while (i < s.length() && s.charAt(i) == ' ')
      i++;
    if (i < s.length() && s.charAt(i) == '-') {
      neg = true;
      i++;
    }
    while (i < s.length() && s.charAt(i) == '0')
      i++;
    if (i < s.length() && (s.charAt(i) < 48 || s.charAt(i) > 57))
      return 0;
    while (i < s.length() && (s.charAt(i) >= 48 && s.charAt(i) <= 57)) {
      char curr = s.charAt(i);
      int prev = result;
      result = result * 10;
      if (result / 10 != prev) {
        System.out.println("woah");
        if (neg)
          return Integer.MIN_VALUE;
        return Integer.MAX_VALUE;
      }
      result += curr - '0';
      i++;
    }
    return neg ? -result : result;
  }

  static public int atoi(String s) {
    if (s.isEmpty())
      return 0;
    int ind = 0;
    while (ind < s.length() && s.charAt(ind) == ' ') {
      ind++;
    }
    if (ind == s.length())
      return 0;
    int sign = 1;
    if (s.charAt(ind) == '-' || s.charAt(ind) == '+') {
      sign = s.charAt(ind) == '-' ? -1 : 1;
      ind++;
    }
    while (ind < s.length() && s.charAt(ind) == '0') {
      ind++;
    }
    return sign * atoiHelper(s, ind, 0, sign);
  }

  static public int atoiHelper(String s, int i, int result, int sign) {
    if (i == s.length())
      return result;
    if (s.charAt(i) < '0' || s.charAt(i) > '9')
      return result;
    int curr = s.charAt(i) - '0';
    int prev = result;
    result *= 10;
    System.out.println("result= " + result + " prev=" + prev);
    result += curr;
    if (result / 10 != prev) {
      return (sign == -1) ? Integer.MIN_VALUE : Integer.MAX_VALUE;
    }
    return atoiHelper(s, i + 1, result, sign);
  }

  public static void main(String[] args) {
    String strs[] = { "   00123", "2147483648", "  00-abc12", "  -000123abc", "91283472332", };
    for (String str : strs) {
      System.out.println(atoi(str));
    }

  }
}
