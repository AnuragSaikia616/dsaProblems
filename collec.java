// i play with collectinos package

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class collec {
  public static void main(String[] args) {
    ArrayList<Integer> list = new ArrayList<Integer>();
    list.add(10);
    list.add(20);
    list.add(30);
    System.out.println(list.getLast());
    System.out.println(list.getFirst());
    System.out.println(list.get(1));

    int[][] dp = new int[3][3];
    for (int i = 0; i < dp.length; i++) {
      Arrays.fill(dp[i], 0);
    }

    System.out.println(dp);

  }
}
