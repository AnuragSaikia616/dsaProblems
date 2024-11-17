import java.util.PriorityQueue;

public class handOfStraights846 {

  public static boolean isNStraightHand(int hand[], int groupSize) {
    int n = hand.length;
    if (n % groupSize != 0)
      return false;
    if (groupSize == 1)
      return true;
    PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> Integer.compare(a, b));
    for (int val : hand) {
      pq.offer(val);
    }
    while (!pq.isEmpty()) {
      int curr = pq.poll();
      for (int i = curr + 1; i < groupSize + curr; i++) {
        if (pq.contains(i)) {
          pq.remove(i);
        } else {
          return false;
        }
      }
    }
    return true;
  }

  public static void main(String[] args) {
    int hand[] = { 1, 2, 3, 6, 2, 3, 4, 7, 8 };
    int groupSize = 3;
    System.out.println(isNStraightHand(hand, groupSize));

  }
}
