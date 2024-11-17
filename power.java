public class power {
  static public double myPow(double x, int n) {
    if (Math.abs(x) == 1.0) {
      if (n == Integer.MIN_VALUE) {
        return 1.0;
      }
      return x;
    }
    double result = 1;
    int m = Math.abs(n);
    if (n == Integer.MIN_VALUE)
      return 0;
    for (int i = 0; i < m; i++) {
      result *= x;

    }
    result = (n < 0) ? 1 / result : result;
    return result;
  }

  public static void main(String[] args) {
    System.out.println(myPow(2, 4));
    System.out.println(myPow(2, -2));
    System.out.println(myPow(2, 0));
    System.out.println(myPow(2.1, 3));
    System.out.println(Math.pow(2, -2147483648));
    System.out.println(Math.pow(-1, -2147483648));

  }
}
