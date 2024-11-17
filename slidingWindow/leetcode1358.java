public class leetcode1358 {
  public static int numberOfSubstrings(String s) {
    int n = s.length();
    int answer = 0;
    int hash[] = new int[256];
    int l = 0;
    for (int r = 0; r < n; r++) {
      int ch = s.charAt(r);
      hash[ch] += 1;

      while ((hash['a'] >= 1) && (hash['b'] >= 1) && (hash['c'] >= 1)) {
        hash[s.charAt(l)] -= 1;
        l++;
        answer += n - r;
      }
    }

    return answer;
  }

  public static void main(String[] args) {
    String input[] = { "aaaabc", "abcabc" };
    for (int i = 0; i < input.length; i++) {
      System.out.println(numberOfSubstrings(input[i]));
    }
  }
}
