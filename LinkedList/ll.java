public class ll {
  private int val;
  private ll next;

  public ll(int val) {
    this.val = val;
    this.next = null;
  }

  public void insert(int val) {
    ll newnode = new ll(this.val);
    newnode.next = this.next;
    this.val = val;
    this.next = newnode;
  }

  public void insertLast(int val) {
    ll newnode = new ll(val);
    ll curr = this;
    while (curr.next != null) {
      curr = curr.next;
    }
    curr.next = newnode;
  }

  public void print() {
    ll curr = this;
    while (curr != null) {
      System.out.print(curr.val + " ");
      curr = curr.next;
    }
    System.out.println();
  }

}
