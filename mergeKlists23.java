import java.util.*;

public class mergeKlists23 {
  public static class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
      this.val = val;
    }

    public ListNode(int val, ListNode next) {
      this.val = val;
      this.next = next;
    }
  }

  public ListNode mergeKLists(ListNode[] lists) {
    Queue<ListNode> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.val, b.val));
    for (ListNode list : lists) {
      if (list != null)
        pq.add(list);
    }
    ListNode ans = new ListNode();
    ListNode curr = ans;
    while (!pq.isEmpty()) {
      ListNode mini = pq.poll();
      curr.next = mini;
      curr = curr.next;
      if (curr.next != null)
        pq.add(curr.next);
    }
    return ans.next;
  }

  public static void main(String[] args) {

  }
}
