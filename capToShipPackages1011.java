public class capToShipPackages1011 {
  public static int shipWithinDays(int weights[], int days) {
    int r = 0, l = 1;
    for (int w : weights) {
      l = Math.max(l, w);
      r += w;
    }
    while (l <= r) {
      int mid = l + (r - l) / 2;
      if (numDaysToShip(weights, mid) <= days) {
        r = mid - 1;
      } else {
        l = mid + 1;
      }
    }
    return l;
  }

  public static int numDaysToShip(int weights[], int shipCap) {
    int count = 1;
    int load = weights[0];
    for (int i = 1; i < weights.length; i++) {
      if (load + weights[i] > shipCap) {
        count++;
        load = weights[i];
      } else {
        load += weights[i];
      }
    }

    return count;
  }

  public static void main(String[] args) {
    int weights[] = { 12, 3, 4, 5, 6, 7, 8, 9, 10 };
    int days = 5;

    System.out.println(shipWithinDays(weights, days));

  }
}
