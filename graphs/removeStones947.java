public class removeStones947 {
  public static int removeStones(int stones[][]) {
    int maxRow = 0, maxCol = 0;
    for (int stone[] : stones) {
      maxRow = Math.max(maxRow, stone[0]);
      maxCol = Math.max(maxCol, stone[1]);
    }
    disjointset dsj = new disjointset(maxRow + maxCol + 1);
    int stoneNodes[] = new int[maxCol + maxRow + 1 + 1];
    for (int stone[] : stones) {
      int r = stone[0];
      int c = stone[1] + maxRow + 1;
      dsj.unionBySize(r, c);
      stoneNodes[r] = 1;
      stoneNodes[c] = 1;
    }
    int comp = 0;
    for (int i = 0; i < dsj.parent.size(); i++) {
      if (dsj.findParent(i) == i && stoneNodes[i] == 1)
        comp++;
    }
    return stones.length - comp;
  }

  public static void main(String[] args) {
    int stones[][] = { { 0, 1 }, { 1, 1 } };
    System.out.println(removeStones(stones));
  }
}
