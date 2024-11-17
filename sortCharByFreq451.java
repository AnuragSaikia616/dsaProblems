import java.util.*;

public class sortCharByFreq451 {

  public static String frequencySort(String s) {
    int n = s.length();
    Map<Character, Integer> hash = new HashMap<>();
    for (char c : s.toCharArray()) {
      hash.put(c, hash.getOrDefault(c, 0) + 1);
    }

    PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>(
        (a, b) -> b.getValue() - a.getValue());

    pq.addAll(hash.entrySet());

    String answer = "";

    while (!pq.isEmpty()) {
      Map.Entry<Character, Integer> val = pq.remove();
      for (int i = 0; i < val.getValue(); i++) {
        answer += val.getKey();
      }
    }
    return answer;
  }

  public static void main(String[] args) {
    String s = "aaatree";
    System.out.println(frequencySort(s));

  }
}
