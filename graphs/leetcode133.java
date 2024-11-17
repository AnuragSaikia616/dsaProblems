import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * leetcode133
 */
public class leetcode133 {

  static class Node {
    public int val;
    public ArrayList<Node> neighbours;

    public Node(int val) {
      this.val = val;
      neighbours = new ArrayList<>();
    }
  }

  public static void main(String[] args) {
    // Node g = new Node(1);
    // Node n2 = new Node(2);
    // Node n3 = new Node(3);
    // Node n4 = new Node(4);
    // g.neighbours.add(n2);
    // g.neighbours.add(n3);
    // n2.neighbours.add(n4);
    Map<Integer, Boolean> mp = new HashMap<>();
    mp.put(1, false);
    System.out.println(mp.containsKey(1));
  }
}
