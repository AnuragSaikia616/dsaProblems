import java.util.*;

public class wordBreak139 {
  public record Pair(String s, int i) {
  }

  static List<String> ans = new ArrayList<>();

  public static boolean wordBreak(String s, List<String> wordDict) {
    HashMap<String, Boolean> mpp = new HashMap<>();
    for (String word : wordDict) {
      mpp.put(word, true);
    }
    HashMap<Pair, Integer> dp = new HashMap<>();
    return solver(s, mpp, 0, "", dp, "");
  }

  public static boolean solver(String s, HashMap<String, Boolean> mpp, int i, String curr, HashMap<Pair, Integer> dp,
      String sent) {
    if (i == s.length()) {
      if (mpp.containsKey(curr)) {
        sent += curr;
        System.out.println(curr);
        System.out.println(sent);
        ans.add(sent);
        return true;
      }
      return false;
    }
    Pair pp = new Pair(curr, i);
    // if (dp.containsKey(pp))
    // return dp.get(pp) == 0 ? false : true;
    boolean res = solver(s, mpp, i + 1, curr + s.charAt(i), dp, sent);
    if (mpp.containsKey(curr)) {
      System.out.println(curr);
      boolean rep = solver(s, mpp, i + 1, "" + s.charAt(i), dp, sent + curr);
      res = res || rep;
    }
    dp.put(pp, res == false ? 0 : 1);
    return res;
  }

  public static void main(String[] args) {
    String s = "catsanddog";
    List<String> words = new ArrayList<>();
    words.add("cat");
    words.add("sand");
    words.add("and");
    words.add("cats");
    words.add("dog");
    System.out.println(wordBreak(s, words));
    // for (String st : ans)
    // System.out.println(st);
  }
}
