import java.util.*;

/**
 * reverseWords151
 */
public class reverseWords151 {
  public static String reverseWords(String s) {
    int n = s.length();
    Stack<Character> chs = new Stack<>();
    String answer = "";
    for (int i = n - 1; i >= 0; i--) {
      if (s.charAt(i) == ' ' && chs.isEmpty())
        continue;
      if (s.charAt(i) != ' ')
        chs.add(s.charAt(i));
      if (s.charAt(i) == ' ' || i == 0) {
        while (!chs.isEmpty()) {
          answer += chs.pop();
        }
        if (i != 0)
          answer += ' ';
      }
    }
    if (answer.charAt(answer.length() - 1) == ' ') {
      answer = answer.substring(0, answer.length() - 1);
    }
    return answer;
  }

  public static void main(String[] args) {
    String ss[] = { "the sky is blue", "  hello world", "", "  " };
    for (String s : ss) {
      System.out.println(reverseWords(s));
    }

  }
}
