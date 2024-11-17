import java.util.*;

public class bingo {
  public interface storeDB {
    public int get();

    // public void put();
    //
    // public void delete();

  }

  public static class A {
    int val;

    public A(int val) {
      this.val = val;
    }

  }

  public abstract class B {
    public B() {
      System.out.println("B object created");
    }

    public void show() {
      System.out.println("Showing");
    }
  }

  public static class SQLdb extends A implements storeDB {
    private int n;

    public SQLdb(int val) {
      super(val);
      this.n = val;
    }

    public int get() {
      return this.n;
    }

  }
  // public static class Human {
  //
  // int age;
  //
  // public Human(int age) {
  // this.age = age;
  // }
  // }

  public static void main(String[] args) {
    final double number = Math.PI;
    // // Stack Queue Map List
    List<Integer> li = new ArrayList<>();
    li.add(10);
    li.get(0);
    li.size();
    String s = "anurag";
    String snew = s.substring(2, 5);
    // System.out.println(snew);
    //
    s.length();
    int arr[] = new int[10];
    int len = arr.length;
    int num = 1000;
    System.out.println(String.valueOf(num));
    //
    // Stack Queue
    Stack<Integer> st = new Stack<>();
    st.push(10);
    st.pop();
    //
    Queue<Integer> q = new LinkedList<>();
    q.add(10);
    q.offer(9);
    q.poll();

    // Priority Queue
    Pair p = new Pair(10, 20);
    PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.x,
        b.x));
    while (!pq.isEmpty()) {
      pq.poll();
    }

    // Map
    Map<Integer, Integer> mp = new HashMap<>();
    // mp.getOrDefault(pq.remove(), 0);
    mp.put(10, 20);
    for (Map.Entry<Integer, Integer> et : mp.entrySet()) {
      System.out.println(et.getKey() + " -> " + et.getValue());

    }

    storeDB std = new SQLdb(10);
    System.out.println(std.get());
  }

  /**
   * Pair
   */
  public record Pair(int x, int y) {
  }
}
