import java.util.Stack;

public class largestRectangle84 {
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
