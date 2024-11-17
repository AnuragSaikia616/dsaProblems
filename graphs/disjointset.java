import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class disjointset {
  List<Integer> parent, rank, size;

  public disjointset(int n) {
    parent = new ArrayList<>(n + 1);
    rank = new ArrayList<>(n + 1);
    size = new ArrayList<>(n + 1);
    for (int i = 0; i <= n; i++) {
      rank.add(0);
      parent.add(i);
      size.add(1);
    }
  }

  public int findParent(int node) {
    if (parent.get(node) == node)
      return node;
    parent.set(node, findParent(parent.get(node)));
    return parent.get(node);

  }

  public void unionByRank(int u, int v) {
    int ultp_u = findParent(u);
    int ultp_v = findParent(v);
    if (ultp_u == ultp_v) {
      return;
    }
    if (rank.get(ultp_u) < rank.get(ultp_v)) {
      parent.set(ultp_u, ultp_v);
    } else if (rank.get(ultp_u) > rank.get(ultp_v)) {
      parent.set(ultp_v, ultp_u);
    } else {
      parent.set(ultp_v, ultp_u);
      rank.set(ultp_u, rank.get(ultp_u) + 1);
    }
  }

  public void unionBySize(int u, int v) {
    int rootu = findParent(u);
    int rootv = findParent(v);
    if (rootu == rootv)
      return;
    if (size.get(rootu) < size.get(rootv)) {
      parent.set(rootu, rootv);
      size.set(rootv, size.get(rootu) + size.get(rootv));
    } else {
      parent.set(rootv, rootu);
      size.set(rootu, size.get(rootu) + size.get(rootv));
    }
  }

  public void isConnected(int u, int v) {
    if (findParent(u) == findParent(v))
      System.out.println("Connected");
    else
      System.out.println("Not Connected");
  }

  public static void main(String[] args) {
    disjointset dsj = new disjointset(7);
    dsj.unionBySize(1, 2);
    dsj.unionBySize(2, 3);
    dsj.unionBySize(4, 5);
    dsj.unionBySize(6, 7);
    dsj.unionBySize(5, 6);
    dsj.isConnected(3, 7);
    dsj.unionBySize(3, 7);
    dsj.isConnected(3, 7);
  }
}
