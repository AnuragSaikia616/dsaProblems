public class trappingRainWater42 {
  public static int trap(int height[]) {
    int l = 0;
    int r = height.length - 1;
    for (int i = 0; i <= r; i++) {
      if (height[i] < height[l])
        break;
      l = i;
    }
    for (int i = r; i >= 0; i--) {
      if (height[i] < height[r])
        break;
      r = i;
    }

    int ans = 0;
    int currLmax = height[l];
    int currRmax = height[r];
    while (l < r - 1) {
      if (currLmax < currRmax) {
        l++;
      } else {
        r--;
      }
      currRmax = Math.max(currRmax, height[r]);
      currLmax = Math.max(currLmax, height[l]);
      ans += currLmax - height[l];
      ans += currRmax - height[r];
    }
    return ans;
  }

  public static void main(String[] args) {
    int height[] = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
    System.out.println(trap(height));

  }
}
