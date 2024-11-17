import java.util.*;

public class KlargestElement215 {
  public static int findKthLargest(int[] nums, int k) {
    PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
    for (int val : nums) {
      pq.add(val);
      if (pq.size() > k)
        pq.poll();
    }
    return pq.poll();
  }

  public static void main(String[] args) {
    int nums[] = { 3, 2, 1, 5, 6, 4 };
    int k = 4;
    System.out.println(findKthLargest(nums, k));

  }
}
