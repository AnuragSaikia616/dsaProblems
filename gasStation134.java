import java.util.Arrays;

public class gasStation134 {
  public static int canCompleteCircuit(int gas[], int cost[]) {
    int n = gas.length;
    int ans = -1;
    for (int i = 0; i < n; i++) {
      if (gas[i] < cost[i])
        continue;
      if (canny(i, gas, cost) == true)
        return i;
    }
    return ans;
  }

  public static boolean canny(int start, int gas[], int cost[]) {
    int tank = gas[start];
    int station = start;
    for (int i = 1; i < gas.length; i++) {
      tank -= cost[station];
      station = (station + 1) % gas.length;
      tank += gas[station];
      if (tank < cost[station])
        return false;
    }
    return true;
  }

  public static int NEWcanCompleteCircuit(int gas[], int cost[]) {
    // in this solution:
    // 1. We calculate the total gas in tank
    // 2. if we can then we travel on and on
    // 3. if we reach the end that means thats the solution since the question says
    // there is one unique solution
    // 4. if gastank empty then return -1 as we cannot travel to next station
    int totalgas = 0;
    int totalcost = 0;
    int start = 0;
    int total = 0;
    for (int i = 0; i < gas.length; i++) {
      totalgas += gas[i];
      totalcost += cost[i];
      if (totalcost > totalgas || i == gas.length - 1)
        return -1;
      total += gas[i] - cost[i];
      if (total < 0) {
        total = 0;
        start = i + 1;
      }
    }
    return start;
  }

  public static void main(String[] args) {
    int gas[] = { 1, 2, 3, 4, 5 };
    int cost[] = { 3, 4, 5, 1, 2 };
    System.out.println(NEWcanCompleteCircuit(gas, cost));

  }
}
