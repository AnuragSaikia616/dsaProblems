public class cloudAnalogy {

  public static void pattern(int n) {
    int lim = 2 * n - 1;
    for (int i = 0; i < lim; i++) {
      for (int j = 0; j < lim; j++) {
        if (i < n) {
          if (j >= i && j < lim - i) {
            System.out.print((char) ('A' + j));
          } else {
            System.out.print(' ');
          }
        } else {
          if (j <= i && j >= lim - i - 1) {
            System.out.print((char) ('A' + j));
          } else {
            System.out.print(' ');
          }
        }
      }
      System.out.println();
    }
  }

  public static void pattern2(int n) {
    int lim = 2 * n - 1;

    for (int i = 0; i < lim; i++) {
      for (int j = 0; j < lim; j++) {
        if (i < n) {
          if (j > i && j < lim - i - 1) {
            System.out.print(' ');
          } else {
            System.out.print((char) ('A' + j));
          }
        } else {
          if (j <= i - 1 && j >= lim - i) {
            System.out.print(' ');
          } else {
            System.out.print((char) ('A' + j));
          }
        }
      }
      System.out.println();
    }
  }

  public static void reversePattern(int lim, int i, int j) {
    if (i > lim - 1) {
      return;
    }
    if (j > lim - 1) {
      System.out.println();
      i = i + 1;
      j = 0;
      reversePattern(lim, i, j);
    } else {
      if (i < 5) {
        if (j >= i && j < lim - i) {
          System.out.print((char) ('A' + j));
        } else {
          System.out.print(' ');
        }
      } else {
        if (j <= i && j >= lim - i - 1) {
          System.out.print((char) ('A' + j));
        } else {
          System.out.print(' ');
        }
      }
      j = j + 1;
      reversePattern(lim, i, j);
    }
  }

  public static String wordrevcount(String s) {
    int i = 0;
    int n = s.length();
    String ans = "";
    while (i < n) {
      if (s.charAt(i) == ' ') {
        ans += s.charAt(i);
        i++;
      } else {
        String word = "";
        int len = 0;
        while (i < n && s.charAt(i) != ' ') {
          word = s.charAt(i) + word;
          len++;
          i++;
        }
        word += String.valueOf(len);
        ans += word;
      }
    }

    return ans;
  }

  public static int passwordgen(int k) {
    int num = (int) Math.pow(10, k - 1);
    int lim = (int) Math.pow(10, k);
    int facts[] = new int[10];
    for (int i = 0; i < 10; i++) {
      facts[i] = fact(i);
    }
    while (num < lim) {
      int temp = num;
      int sum = 0;
      while (temp > 0) {
        int d = temp % 10;
        temp = temp / 10;
        sum += facts[d];
      }
      if (sum == num)
        return sum;
      num++;
    }
    return -1;
  }

  public static int fact(int n) {
    if (n < 2)
      return 1;
    return n * fact(n - 1);
  }

  public static void main(String[] args) {
    int n = 5;
    reversePattern(n * 2 - 1, 0, 0);
    // pattern2(5);
  }
}
