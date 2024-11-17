import java.lang.reflect.Array;
import java.security.cert.TrustAnchor;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

import javax.management.Query;

/**
 * graph
 */
public class graph {
  private ArrayList<ArrayList<Integer>> neighbours;
  private int numVertex;

  public graph(int n) {
    neighbours = new ArrayList<>();
    numVertex = n;
    for (int i = 0; i < n + 1; i++) {
      neighbours.add(new ArrayList<>());
    }
  }

  public ArrayList<ArrayList<Integer>> getNeighbours() {
    return neighbours;
  }

  public int getNumVertex() {
    return numVertex;
  }

  public void add(int p, int q) {
    neighbours.get(p).add(q);
    neighbours.get(q).add(p);
  }

  public void delete(int p, int q) {
    neighbours.get(p).remove(q);
    neighbours.get(q).remove(p);
  }

  public void print() {
    for (int i = 1; i < neighbours.size(); i++) {
      System.out.println(i + " -> " + neighbours.get(i));
    }
  }

  public ArrayList<Integer> dfs() {
    Stack<Integer> st = new Stack<>();
    ArrayList<Integer> dfsList = new ArrayList<>();
    boolean visited[] = new boolean[neighbours.size()];
    st.add(1);
    while (!st.isEmpty()) {
      int val = st.pop();
      if (!visited[val]) {
        visited[val] = true;
        dfsList.add(val);
        for (int node : neighbours.get(val)) {
          if (!visited[node]) {
            st.push(node);
          }
        }
      }
    }
    return dfsList;
  }

  public ArrayList<Integer> bfs() {
    Queue<Integer> q = new LinkedList<>();
    ArrayList<Integer> bfsList = new ArrayList<>();
    boolean visited[] = new boolean[neighbours.size()];
    q.add(1);
    while (q.isEmpty() == false) {
      int val = q.poll();
      if (!visited[val]) {
        visited[val] = true;
        bfsList.add(val);
        for (int node : neighbours.get(val)) {
          if (!visited[node]) {
            q.add(node);
          }
        }
      }

    }
    return bfsList;

  }

  public static void main(String[] args) {
    graph g = new graph(5);
    g.add(1, 2);
    g.add(1, 3);
    g.add(1, 4);
    g.add(3, 2);
    g.add(4, 2);
    g.add(4, 5);
    ArrayList<Integer> trav = g.dfs();
    System.out.println(trav);
    System.out.println(g.bfs());

  }

}
