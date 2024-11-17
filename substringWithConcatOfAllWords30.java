import java.util.*;

public class substringWithConcatOfAllWords30 {
  public static List<Integer> findSubstring(String s, String words[]) {
    int wordlen = words[0].length();
    int window = words.length * wordlen;
    int len = words.length;

    HashMap<String, Integer> mpp = new HashMap<>();

    for (String word : words)
      mpp.put(word, mpp.getOrDefault(word, 0) + 1);

    List<Integer> ans = new LinkedList<>();

    for (int i = 0; i < wordlen; i++) {

      HashMap<String, Integer> hm = new HashMap<>();
      int count = 0;

      for (int j = i, k = i; k <= s.length() - window; j += wordlen) {
        String ww = s.substring(j, j + wordlen);
        hm.put(ww, hm.getOrDefault(ww, 0) + 1);
        count++;

        if (count == len) {
          if (hm.equals(mpp)) {
            ans.add(k);
          }
          hm.computeIfPresent(s.substring(k, k + wordlen), (w, val) -> val > 1 ? val - 1 : null);
          count--;
          k = k + wordlen;
        }
      }
    }
    return ans;
  }

  public static void main(String[] args) {
    String s = "barfoofoobarthefoobarman";
    String words[] = { "bar", "foo", "the" };
    System.out.println(findSubstring(s, words));

  }
}
