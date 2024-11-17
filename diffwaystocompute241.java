import java.util.ArrayList;
import java.util.List;

public class diffwaystocompute241 {

  public static List<Integer> diffWaysToCompute(String exp) {
    return solver(exp);
  }

  public static List<Integer> solver(String exp) {
    List<Integer> ans = new ArrayList<>();
    for (int i = 1; i < exp.length() - 1; i++) {
      char ch = exp.charAt(i);
      if (ch == '-' || ch == '*' || ch == '+') {
        List<Integer> left = solver(exp.substring(0, i));
        List<Integer> right = solver(exp.substring(i + 1));
        for (int lval : left) {
          for (int rval : right) {
            if (ch == '-')
              ans.add(lval - rval);
            if (ch == '+')
              ans.add(lval + rval);
            if (ch == '*')
              ans.add(lval * rval);
          }
        }
      }
    }
    if (ans.size() == 0)
      ans.add(Integer.valueOf(exp));
    return ans;
  }

  public static void main(String[] args) {

  }
}
