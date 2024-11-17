public class makefancyString1957 {
  public static String makeFancyString(String s) {
    StringBuilder sb = new StringBuilder();
    int count = 0;
    char prev = ' ';
    for (char c : s.toCharArray()) {
      if (prev == c) {
        count++;
      } else {
        prev = c;
        count = 1;
      }
      if (count < 3)
        sb.append(c);
    }
    return sb.toString();
  }

  public static void main(String[] args) {
    System.out.println(makeFancyString("Leeetcooooode"));
  }
}
