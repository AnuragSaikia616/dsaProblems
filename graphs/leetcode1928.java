import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * leetcode1928
 */
public class leetcode1928 {

  record Pair(int node, int fee, int time) {
  }

  public static int minCost(int maxTime, int edges[][], int passingFees[]) {
    int numNodes = passingFees.length;

    List<List<int[]>> graph = new ArrayList<>();
    for (int i = 0; i < numNodes; i++)
      graph.add(new ArrayList<>());
    for (int e[] : edges) {
      int source = e[0], dest = e[1], time = e[2];
      graph.get(source).add(new int[] { dest, time });
      graph.get(dest).add(new int[] { source, time });
    }

    Queue<Pair> pq = new PriorityQueue<>((x, y) -> x.fee == y.fee ? x.time - y.time : x.fee - y.fee);
    pq.offer(new Pair(0, passingFees[0], 0));
    int time[] = new int[numNodes];
    Arrays.fill(time, maxTime + 1);
    time[0] = 0;
    while (!pq.isEmpty()) {
      Pair curr = pq.poll();
      if (curr.node == numNodes - 1)
        return curr.fee;
      for (int[] neighbor : graph.get(curr.node)) {
        int tonode = neighbor[0]; // dest node
        int tott = neighbor[1] + curr.time;
        if (tott >= time[tonode])
          continue;
        time[tonode] = tott;
        pq.offer(new Pair(tonode, passingFees[tonode] + curr.fee, tott));

      }
    }
    return -1;
  }

  public static void main(String[] args) {
    int maxTime = 26;
    int edges[][] = { { 0, 1, 10 }, { 1, 2, 10 }, { 2, 5, 10 }, { 0, 3, 1 }, { 3,
        4, 10 }, { 4, 5, 15 } };
    int passingFees[] = { 5, 1, 2, 20, 20, 3 };
    System.out.println(minCost(maxTime, edges, passingFees));

    // int edges[][] = { { 9, 7, 18 }, { 26, 3, 12 }, { 28, 45, 33 }, { 47, 10, 27
    // }, { 34, 18, 38 }, { 32, 13, 39 },
    // { 32, 26, 32 }, { 12, 0, 2 }, { 4, 1, 7 }, { 5, 3, 2 }, { 39, 25, 27 }, { 45,
    // 10, 34 }, { 3, 19, 5 },
    // { 25, 32, 23 }, { 30, 10, 47 }, { 37, 2, 31 }, { 10, 32, 15 }, { 23, 14, 19
    // }, { 22, 6, 14 }, { 45, 39, 38 },
    // { 39, 21, 30 }, { 42, 17, 42 }, { 20, 17, 15 }, { 24, 0, 27 }, { 2, 46, 11 },
    // { 2, 24, 13 }, { 36, 22, 30 },
    // { 2, 1, 31 }, { 41, 35, 45 }, { 4, 19, 20 }, { 32, 27, 33 }, { 38, 46, 1 }, {
    // 21, 11, 15 }, { 33, 41, 2 },
    // { 45, 18, 30 }, { 8, 33, 50 }, { 37, 11, 6 }, { 25, 17, 42 }, { 45, 39, 33 },
    // { 7, 4, 49 }, { 17, 42, 36 },
    // { 36, 16, 9 }, { 46, 25, 24 }, { 43, 4, 6 }, { 35, 13, 28 }, { 1, 28, 1 }, {
    // 34, 35, 15 }, { 38, 1, 15 },
    // { 16, 6, 28 }, { 13, 0, 42 }, { 3, 30, 24 }, { 43, 27, 35 }, { 8, 0, 45 }, {
    // 27, 20, 47 }, { 6, 16, 47 },
    // { 0, 34, 35 }, { 0, 35, 3 }, { 40, 11, 24 }, { 1, 0, 49 }, { 44, 20, 32 }, {
    // 26, 12, 17 }, { 3, 2, 25 },
    // { 37, 25, 42 }, { 27, 1, 15 }, { 36, 25, 38 }, { 24, 47, 33 }, { 33, 28, 15
    // }, { 25, 43, 37 }, { 47, 31, 47 },
    // { 29, 10, 50 }, { 11, 1, 21 }, { 29, 3, 48 }, { 1, 25, 10 }, { 48, 17, 16 },
    // { 19, 24, 22 }, { 30, 7, 2 },
    // { 11, 22, 19 }, { 20, 42, 41 }, { 27, 3, 48 }, { 17, 0, 34 }, { 19, 14, 32 },
    // { 49, 2, 20 }, { 10, 3, 38 },
    // { 0, 49, 13 }, { 6, 3, 28 }, { 42, 23, 6 }, { 14, 8, 1 }, { 35, 16, 3 }, {
    // 17, 7, 40 }, { 18, 7, 49 },
    // { 36, 35, 13 }, { 14, 40, 45 }, { 16, 33, 11 }, { 31, 22, 33 }, { 38, 15, 48
    // }, { 15, 14, 25 }, { 37, 13, 37 },
    // { 44, 32, 7 }, { 48, 1, 31 }, { 33, 12, 20 }, { 22, 26, 23 }, { 4, 10, 11 },
    // { 43, 28, 43 }, { 19, 8, 14 },
    // { 35, 31, 33 }, { 28, 27, 19 }, { 40, 11, 36 }, { 36, 43, 28 }, { 22, 21, 15
    // } };
    // int passingFees[] = { 199, 505, 107, 961, 682, 400, 304, 517, 512, 18, 334,
    // 627, 893, 412, 922, 289, 19, 161, 206,
    // 879, 336, 831, 577, 802, 139, 348, 440, 219, 273, 691, 99, 858, 389, 955,
    // 561, 353, 937, 904, 858, 704, 548,
    // 497, 787, 546, 241, 67, 743, 42, 87, 137 };
    // int maxTime = 500;
    // System.out.println(minCost(maxTime, edges, passingFees));
  }
}
