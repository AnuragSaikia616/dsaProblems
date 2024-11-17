import java.util.Map;
import java.util.Scanner;
import java.math.BigInteger;
import java.util.LinkedHashMap;

public class tcstcstcs {
  public static String solver(String s) {
    String curr = "";
    Map<String, Integer> hm = new LinkedHashMap<>();
    for (char c : s.toCharArray()) {
      if (c == ' ') {
        hm.put(curr, hm.getOrDefault(curr, 0) + 1);
        curr = "";
      } else {
        curr += c;
      }
    }
    if (curr != "")
      hm.put(curr, hm.getOrDefault(curr, 0) + 1);
    String ans = "";
    for (Map.Entry<String, Integer> entry : hm.entrySet()) {
      String word = entry.getKey();
      String num = entry.getValue().toString();
      ans += word + " " + num + " ";
    }
    return ans;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    BigInteger t = new BigInteger(sc.nextLine());
    while (t-- > 0) {
      String s = sc.nextLine();
      System.out.println(solver(s));
    }

    sc.close();
  }
}
