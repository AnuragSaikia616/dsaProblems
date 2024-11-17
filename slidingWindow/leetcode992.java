// 992. Subarrays with K Different Integers
//
// Given an integer array nums and an integer k, return the number of good subarrays of nums.
//
// A good array is an array where the number of different integers in that array is exactly k.
//
//     For example, [1,2,3,1,2] has 3 different integers: 1, 2, and 3.
//
// A subarray is a contiguous part of an array.
public class leetcode992 {
  public static int subarraysWithKDistinct(int nums[], int k) {
    int answer = 0;
    int n = nums.length;
    int i = 0;
    int j = 0;
    int map[] = new int[n + 1];
    int count = 0;
    while (j < n) {
      if (map[nums[j]]++ == 0)
        count++;

      while (count > k)
        if (--map[nums[i++]] == 0)
          count--;

      if (count == k) {
        int tmap[] = map.clone();
        for (int it = i; it <= j - k + 1 && tmap[nums[it]]-- > 1; it++) {
          answer++;
        }
        answer++;
      }
      j++;
    }

    return answer;
  }

  // following is the optimal solution
  // this solution uses the fact that
  // subarrys with exactly K distinct = sub with atmost k - sub with atmost k-1
  // so the call for this solution will be
  // answer = f(k) - f(k-1)
  // f() return the number of subarrys with atmost distinct numbers
  public static int newsubarraysWithKDistinct(int nums[], int k) {
    int n = nums.length;
    int l = 0, ans = 0;
    int hash[] = new int[n + 1];
    for (int r = 0; r < n; r++) {
      if (++hash[nums[r]] == 1)
        k--;
      while (k == -1) {
        if (--hash[nums[l++]] == 0)
          k++;
      }
      ans += r - l + 1;
    }
    return ans;
  }

  public static void main(String[] args) {
    int input[][] = { { 1, 2, 1, 2, 3 }, { 1, 1, 1, 1, 2 }, { 1, 2, 1, 2, 2 } };
    int k[] = { 2, 2, 2 };
    for (int i = 0; i < k.length; i++) {
      System.out.println(subarraysWithKDistinct(input[i], k[i]));
    }

  }
}

// 1112321
