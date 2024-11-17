import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * leetcode127
 */
public class leetcode127 {

  public static int newLadderLength(String beginWord, String endWord, List<String> wordList) {
    Set<String> wordset = new HashSet<>(wordList);
    Queue<String> q = new LinkedList<>();
    Set<String> visited = new HashSet<>();
    q.add(beginWord);
    int level = 0;
    while (!q.isEmpty()) {
      int n = q.size();
      while (n > 0) {
        String word = q.poll();
        if (word.equals(endWord))
          return level + 1;
        for (int j = 0; j < word.length(); j++) {
          char[] warr = word.toCharArray();
          for (char k = 'a'; k <= 'z'; k++) {
            warr[j] = k;
            String curr = new String(warr);
            if (wordset.contains(curr) && !visited.contains(curr)) {
              q.add(curr);
              visited.add(curr);
            }
          }
        }
        n--;
      }
      level += 1;
    }
    return 0;
  }

  public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
    Map<String, Set<String>> graph = new HashMap<>();
    for (String word : wordList) {
      graph.putIfAbsent(word, new HashSet<>());
    }
    graph.putIfAbsent(beginWord, new HashSet<>());
    for (String word : wordList) {
      if (canTransform(beginWord, word)) {
        graph.get(beginWord).add(word);
        graph.get(word).add(beginWord);
      }
      for (String sword : wordList) {
        if (canTransform(word, sword)) {
          graph.get(word).add(sword);
          graph.get(sword).add(word);
        }
      }
    }
    Queue<String> q = new LinkedList<>();
    Set<String> visited = new HashSet<>();
    q.add(beginWord);
    int level = 0;
    while (!q.isEmpty()) {
      int size = q.size();
      for (int i = 0; i < size; i++) {
        String w = q.poll();
        if (w.equals(endWord)) {
          return level + 1;
        }
        for (String nw : graph.get(w)) {
          if (!visited.contains(nw)) {
            q.add(nw);
            visited.add(nw);
          }
        }
      }
      level++;
    }
    return 0;
  }

  public static boolean canTransform(String a, String b) {
    int count = 0;
    for (int i = 0; i < a.length(); i++) {
      if (a.charAt(i) != b.charAt(i))
        count += 1;
      if (count > 1)
        return false;
    }
    return count == 1;
  }

  public static void main(String[] args) {
    String beginWord = "hit";
    String endWord = "cog";
    String[] words = { "hot", "dot", "dog", "lot", "log", "cog" };
    List<String> wordList = Arrays.asList(words);
    System.out.println(newLadderLength(beginWord, endWord, wordList));

  }
}
