/**
 * uglyNumber2
 */
public class uglyNumber2 {
  public static int nthUglyNumber(int n) {
    int arr[] = new int[n];
    arr[0] = 1;
    int i2 = 2, i3 = 3, i5 = 5;
    for (int i = 1; i < n; i++) {
      int ugly = Math.min(Math.min(i2, i3), i5);
      if (ugly == i2)
        i2 += 2;
      if (ugly == i3)
        i3 += 3;
      if (ugly == i5)
        i5 += 5;
      arr[i] = ugly;
    }
    return arr[n - 1];
  }

  public static void main(String[] args) {
    System.out.println(nthUglyNumber(10));

  }
}
