import java.util.*;

public class IPO502 {
  public record Pair(int p, int c) {

  }

  public static int findMaximizedCapital(int k, int w, int profits[], int capital[]) {
    int n = profits.length;
    List<Pair> l = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      Pair p = new Pair(profits[i], capital[i]);
      l.add(p);
    }
    l.sort((a, b) -> Integer.compare(a.c, b.c));
    int ans = w;
    PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> Integer.compare(b.p, a.p));
    int i = 0;
    while (i < n) {
      if (l.get(i).c <= ans) {
        pq.add(l.get(i));
        i++;
      } else {
        if (!pq.isEmpty() && k-- > 0) {
          ans += pq.poll().p;
        } else {
          break;
        }
      }
    }
    while (k-- > 0 && !pq.isEmpty()) {
      ans += pq.poll().p;
    }

    return ans;
  }

  public static void main(String[] args) {
    int k = 100;
    int w = 0;
    int profits[] = { 1, 2, 21 };
    int capital[] = { 0, 0, 2 };
    System.out.println(findMaximizedCapital(k, w, profits, capital));

  }
}

// profits = 1,2,3 capital = 0,1,1
// after sort
// 3,2,1 2,1,0
//
