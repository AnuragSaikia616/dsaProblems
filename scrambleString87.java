import java.util.HashMap;
import java.util.Map;

public class scrambleString87 {

  public static boolean isScramble(String s1, String s2) {
    if (s1.length() != s2.length())
      return false;
    if (s1.length() <= 1)
      return true;
    Map<String, Boolean> dp = new HashMap<>();
    return solver(s1, s2, dp);
  }

  public static boolean solver(String s1, String s2, Map<String, Boolean> dp) {
    if (s1.equals(s2))
      return true;
    if (s1.length() <= 1 || s2.length() <= 1)
      return s1.equals(s2);
    String key = s1 + "#" + s2;
    if (dp.containsKey(key))
      return dp.get(key);
    boolean flag = false;
    for (int i = 1; i < s1.length(); i++) {
      boolean withoutswap = solver(s1.substring(0, i), s2.substring(0, i), dp)
          && solver(s1.substring(i), s2.substring(i), dp);
      boolean withswap = solver(s1.substring(0, i), s2.substring(i), dp)
          && solver(s1.substring(i), s2.substring(0, i), dp);
      if (withoutswap || withswap)
        flag = true;
    }
    dp.put(key, flag);
    return flag;
  }

  public static void main(String[] args) {
    String one = "great";
    String two = "rgeat";
    System.out.println(isScramble(one, two));
  }
}
