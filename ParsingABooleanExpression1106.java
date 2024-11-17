import java.util.Stack;

public class ParsingABooleanExpression1106 {
  public static boolean parseBoolExpr(String exp) {
    Stack<Character> opst = new Stack<>();
    Stack<Character> boolst = new Stack<>();
    for (char c : exp.toCharArray()) {
      if (c == 't' || c == 'f') {
        boolst.push(c);
      } else if (c == '!' || c == '|' || c == '&') {
        if (c != '!')
          boolst.push('X');
        opst.push(c);
      } else if (c == ')') {
        char op = opst.pop();
        if (op == '!') {
          boolst.push(boolst.pop() == 't' ? 'f' : 't');
        } else {
          char curr = boolst.pop();
          boolean first = true;
          boolean res = true;
          while (curr != 'X') {
            boolean currb = curr == 't' ? true : false;
            if (first) {
              first = false;
              res = currb;
            } else if (op == '|') {
              res = res || currb;
            } else {
              res = res && currb;
            }
            curr = boolst.pop();
          }
          boolst.push(res ? 't' : 'f');
        }
      } else {
        continue;
      }
    }
    return boolst.pop() == 't' ? true : false;
  }

  public static void main(String[] args) {
    String expression = "!(&(f,t))";
    System.out.println(parseBoolExpr(expression));

  }
}
