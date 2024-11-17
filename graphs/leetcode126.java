
/**
 * leetcode126
 */
import java.util.*;

public class leetcode126 {
  public static List<List<String>> findLadders(String bw, String ew, List<String> wordlist) {
    Queue<List<String>> q = new LinkedList<>();
    List<String> levellist = new ArrayList<>();
    Set<String> wordset = new HashSet<>(wordlist);
    List<List<String>> ans = new ArrayList<>();
    ArrayList<String> todelete = new ArrayList<>();

    levellist.add(bw);
    q.add(levellist);
    while (!q.isEmpty()) {
      int n = q.size();
      while (n > 0) {
        List<String> path = q.poll();
        String word = path.get(path.size() - 1);
        todelete.add(word);
        if (word.equals(ew)) {
          if (ans.size() == 0) {
            ans.add(path);
          } else {
            if (path.size() <= ans.get(0).size()) {
              ans.add(path);
            }
          }
        }
        for (int j = 0; j < word.length(); j++) {
          char[] warr = word.toCharArray();
          for (char k = 'a'; k <= 'z'; k++) {
            warr[j] = k;
            String curr = new String(warr);
            if (wordset.contains(curr)) {
              List<String> newpath = new ArrayList<>(path);
              newpath.add(curr);
              q.add(newpath);
            }
          }
        }
        n--;
        for (String del : todelete) {
          wordset.remove(del);
        }
        todelete.clear();
      }
    }
    return ans;
  }

  public static void main(String[] args) {
    String beginWord = "hit";
    String endWord = "cog";
    String[] words = { "hot", "dot", "dog", "lot", "log", "cog" };
    List<String> wordList = Arrays.asList(words);

    List<List<String>> res = findLadders(beginWord, endWord, wordList);
    System.out.println(res.size());
    for (List<String> l : res) {
      for (String s : l) {
        System.out.print(s + "->");
      }
      System.out.println();
    }
  }
}
