public class zigzagConversion6 {
  public static String convert(String s, int numRows) {
    int skibbidi = 2 * numRows - 2;
    String ans = "";
    for (int i = 0; i < numRows; i++) {
      int j = i;
      while (j < s.length()) {
        ans += s.charAt(j);
        if (i > 0 && i < numRows - 1) {
          if (j + skibbidi - 2 * i < s.length())
            ans += s.charAt(j + skibbidi - 2 * i);
        }
        j += skibbidi;
      }
    }
    return ans;
  }

  public static void main(String[] args) {
    System.out.println(convert("PAYPALISHIRING", 4));

  }
}
