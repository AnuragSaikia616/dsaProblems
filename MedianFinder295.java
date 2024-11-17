import java.util.*;

public class MedianFinder295 {
  public class MedianFinder {
    PriorityQueue<Integer> nums;
    int size;

    public MedianFinder() {
      nums = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
      size = 0;
    }

    public void addNum(int num) {
      nums.offer(num);
      size++;
    }

    public double findMedian() {
      PriorityQueue<Integer> pq = new PriorityQueue<>(this.nums);
      double med;
      if (size % 2 == 0) {
        for (int i = 0; i < (size / 2) - 1; i++) {
          pq.poll();
        }
        double first = pq.poll();
        double second = pq.poll();
        med = (first + second) / 2;
      } else {
        for (int i = 0; i < size / 2; i++) {
          pq.poll();
        }
        med = pq.poll();
      }

      return med;
    }
  }

  public static void main(String[] args) {

  }
}
