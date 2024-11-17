import java.util.*;

public class accountsMerge721 {
  int parent[];
  int size[];

  public int largestIsland(int[][] grid) {
    int n = grid.length;
    int numnodes = n * n;
    parent = new int[numnodes];
    size = new int[numnodes];
    for (int i = 0; i < numnodes; i++) {
      parent[i] = i;
      size[i] = 1;
    }
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        // (n-1)*i+j will the the coordinate node
        if (grid[i][j] == 0) {
          size[nodeify(i, j, n)] = 0;
        } else {
          if (j > 0 && grid[i][j - 1] == 1)
            union(nodeify(i, j, n), nodeify(i, j - 1, n));
          if (i > 0 && grid[i - 1][j] == 1)
            union(nodeify(i, j, n), nodeify(i - 1, j, n));
        }
      }
    }
    int maxSize = 0;
    for (int i = 0; i < parent.length; i++) {
      parent[i] = find(i);
      maxSize = Math.max(maxSize, size[parent[i]]);
    }
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        if (grid[i][j] == 0) {
          int tsize = 1;
          List<Integer> uni = new ArrayList<>();
          tsize += sizeadder(i, j + 1, n, uni);
          tsize += sizeadder(i, j - 1, n, uni);
          tsize += sizeadder(i + 1, j, n, uni);
          tsize += sizeadder(i - 1, j, n, uni);
          maxSize = Math.max(maxSize, tsize);
        }
      }
    }

    return maxSize;
  }

  public int find(int node) {
    if (parent[node] == node)
      return node;
    return parent[node] = find(parent[node]);
  }

  public void union(int u, int v) {
    int rootu = find(u);
    int rootv = find(v);
    if (rootu == rootv)
      return;
    if (size[rootu] < size[rootv]) {
      parent[rootu] = rootv;
      size[rootv] += size[rootu];
    } else {
      parent[rootv] = rootu;
      size[rootu] += size[rootv];
    }
  }

  public int nodeify(int i, int j, int n) {
    return n * i + j;
  }

  public int sizeadder(int i, int j, int n, List<Integer> uniques) {
    if (i < 0 || i >= n || j < 0 || j >= n)
      return 0;
    int node = nodeify(i, j, n);
    if (uniques.contains(find(node)))
      return 0;
    uniques.add(find(node));
    return size[find(node)];
  }
}
