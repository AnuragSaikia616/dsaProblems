import java.util.*;

class MedianFinder {
  PriorityQueue<Integer> min_heap;
  PriorityQueue<Integer> max_heap;

  public MedianFinder() {
    min_heap = new PriorityQueue<>((a, b) -> Integer.compare(a, b));
    max_heap = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
  }

  public void addNum(int num) {
    if (min_heap.isEmpty()) {
      min_heap.offer(num);
    } else {
      if (num < min_heap.peek()) {
        max_heap.offer(num);
      } else {
        min_heap.offer(num);
      }
    }

    balance();
  }

  public void balance() {
    if (min_heap.size() > 1 + max_heap.size()) {
      max_heap.offer(min_heap.poll());
      return;
    } else if (min_heap.size() < 1 + max_heap.size()) {
      max_heap.offer(min_heap.poll());
      return;
    }
  }

  public double findMedian() {
    double median;
    if ((max_heap.size() + min_heap.size()) % 2 == 0) {
      median = (double) (max_heap.peek() + min_heap.peek()) / 2;
    } else {
      median = max_heap.size() > min_heap.size() ? max_heap.peek() : min_heap.peek();
    }
    return median;
  }
}
