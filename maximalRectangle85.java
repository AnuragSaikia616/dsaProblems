import java.util.*;

/**
 * maximalRectangle85
 */
public class maximalRectangle85 {

  public static int maximalRectangle(char[][] matrix) {
    int cols = matrix[0].length;
    int rows = matrix.length;
    int heights[] = new int[cols];
    int ans = 0;
    for (int i = 0; i < rows; i++) {
      if (i == 0) {
        for (int c = 0; c < cols; c++) {
          heights[c] = matrix[0][c] - '0';
        }
      } else {
        for (int c = 0; c < cols; c++) {
          if (matrix[i][c] == '0') {
            heights[c] = 0;
          } else {
            heights[c] = heights[c] + 1;
          }
        }
      }

      ans = Math.max(largestRectangleArea(heights), ans);
    }
    return ans;
  }

  public record Pair(int start, int height) {
  }

  public static int largestRectangleArea(int heights[]) {
    Stack<Pair> st = new Stack<>();
    int max = 0;
    for (int i = 0; i < heights.length; i++) {
      int s = i;
      while (!st.isEmpty() && st.peek().height > heights[i]) {
        Pair dogge = st.pop();
        max = Math.max(max, dogge.height * (i - dogge.start));
        s = dogge.start;
      }
      st.push(new Pair(s, heights[i]));
    }

    while (!st.isEmpty()) {
      Pair catty = st.pop();
      max = Math.max(max, catty.height * (heights.length - catty.start));
    }
    return max;
  }

  public static void main(String[] args) {
  }
}
