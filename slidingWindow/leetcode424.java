// 424. Longest Repeating Character Replacement
//
// You are given a string s and an integer k. You can choose any character of the string and 
// change it to any other uppercase English character. You can perform this operation at most k times.
//
// Return the length of the longest substring containing the same letter you can get after performing the above operations.
public class leetcode424 {

  public static int characterReplacement(String s, int k) {
    int answer = 0;
    int n = s.length();

    for (int c = 'A'; c <= 'Z'; c++) {
      int i = 0, j = 0, replaced = 0;
      while (j < n) {
        if (s.charAt(j) == c) {
          j++;
        } else if (replaced < k) {
          j++;
          replaced++;
        } else if (s.charAt(i) == c) {
          i++;
        } else {
          replaced--;
          i++;
        }
        answer = Math.max(answer, j - i);
      }
    }
    return answer;
  }

  // optimized version by keeping track of the maximum occuring character in the
  // valid subarray
  public static int newcharacterReplacement(String s, int k) {
    int answer = 0;
    int n = s.length();
    int l = 0;
    int freq[] = new int[256];
    int maxfreq = 0;
    for (int r = 0; r < n; r++) {
      int curr = s.charAt(r);
      freq[curr]++;
      maxfreq = Math.max(maxfreq, freq[curr]);
      while (r - l + 1 - maxfreq > k) {
        freq[s.charAt(l)]--;
        l++;
      }
      answer = Math.max(answer, r - l + 1);
    }

    return answer;
  }

  // abababb

  public static void main(String[] args) {
    String input[] = { "ABACADDAA" };
    int k[] = { 2 };
    for (int i = 0; i < input.length; i++) {
      System.out.println(newcharacterReplacement(input[i], k[i]));
    }
  }
}
