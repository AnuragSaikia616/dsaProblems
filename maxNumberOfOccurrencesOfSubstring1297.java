import java.util.HashMap;
import java.util.HashSet;

public class maxNumberOfOccurrencesOfSubstring1297 {
  public static int maxFreq(String s, int maxLetters, int minsize, int maxsize) {
    HashMap<String, Integer> mpp = new HashMap<>();
    for (int i = 0; i < s.length() - minsize + 1; i++) {
      String subs = s.substring(i, i + minsize);

    }
  }

  public static int countsChar(String s) {
    HashSet<Character> ht = new HashSet<>();
    for (var c : s.toCharArray()) {
      ht.add(c);
    }
    return ht.size();
  }

  public static void main(String[] args) {

  }
}
