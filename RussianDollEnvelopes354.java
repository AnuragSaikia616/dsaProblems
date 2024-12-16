import java.util.*;

public class RussianDollEnvelopes354 {

  public static int NewMaxEnvelopes(int input[][]) {
    Arrays.sort(input, (a, b) -> {
      if (a[0] == b[0])
        return b[1] - a[1];
      return a[0] - b[0];
    });

    List<Integer> temp = new ArrayList<>();
    for (int i = 0; i < input.length; i++) {
      int currVal = input[i][1];

      if (temp.isEmpty() || currVal > temp.get(temp.size() - 1)) {
        temp.add(currVal);
      } else {
        int left = 0;
        int right = temp.size();

        while (left < right) {
          int mid = left + (right - left) / 2;
          if (temp.get(mid) >= currVal) {
            right = mid;
          } else {
            left = mid + 1;
          }
        }

        temp.set(left, currVal);
      }
    }

    return temp.size();
  }

  public static void main(String[] args) {
    int input[][] = { { 7, 8 }, { 12, 16 }, { 12, 5 }, { 1, 8 }, { 4, 19 }, { 3, 15 }, { 4, 10 }, { 9, 16 } };
    System.out.println(NewMaxEnvelopes(input));

  }
}
