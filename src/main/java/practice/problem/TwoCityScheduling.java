package practice.problem;

import java.util.Arrays;

// 1029. Two City Scheduling
public class TwoCityScheduling {
    public int twoCitySchedCost(int[][] costs) {
        Arrays.sort(costs, (a, b) -> (a[1] - a[0]) - (b[1] - b[0]));
        int cost = 0;
        for (int i = 0; i < costs.length / 2; i++)
            cost += costs[i][1] + costs[costs.length - i - 1][0];
        return cost;
    }
}
