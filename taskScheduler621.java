import java.util.*;

public class taskScheduler621 {
  public static int leastInterval(char tasks[], int n) {
    int count[] = new int[26];
    int maxfreq = 0;
    for (char t : tasks) {
      count[t - 'A']++;
      maxfreq = Math.max(maxfreq, count[t - 'A']);
    }
    int maxSlots = maxfreq + (maxfreq - 1) * n;
    int nmaxfreq = 0;
    for (int val : count) {
      if (val == maxfreq)
        nmaxfreq++;
    }
    return Math.max(tasks.length, maxSlots + nmaxfreq - 1);
  }

  public static void main(String[] args) {

    char tasks[] = { 'A', 'A', 'A', 'B', 'B', 'B', };
    int n = 2;
    System.out.println(leastInterval(tasks, n));
  }
}
