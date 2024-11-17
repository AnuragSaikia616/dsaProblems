import java.nio.charset.Charset;
import java.util.HashSet;
import java.util.Set;

public class leetcode3 {
  public static int lengthOfLongestSubstring(String s) {
    int n = s.length();
    int answer = 0;
    for (int i = 0; i < n; i++) {
      Set<Character> set = new HashSet<>();
      for (int j = i; j < n; j++) {
        if (set.contains(s.charAt(j))) {
          break;
        }
        set.add(s.charAt(j));
      }
      answer = Math.max(answer, set.size());
    }
    return answer;
  }

  public static void main(String[] args) {
    String str = "abc";
    System.out.println(lengthOfLongestSubstring(str));
  }
}
