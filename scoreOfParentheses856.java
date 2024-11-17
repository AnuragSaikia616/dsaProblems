import java.util.Stack;

public class scoreOfParentheses856 {
  public static int scoreOfParentheses(String s) {
    Stack<Integer> st = new Stack<>();
    for (char ch : s.toCharArray()) {
      if (ch == '(') {
        st.push(0);
      } else {
        int temp = 0;
        while (st.peek() != 0) {
          int val = st.pop();
          temp += val;
        }
        st.pop();
        temp = Math.max(1, 2 * temp);
        st.push(temp);
      }
    }
    return st.pop();
  }

  public static void main(String[] args) {
    System.out.println(scoreOfParentheses("(()(()))"));
  }
}
