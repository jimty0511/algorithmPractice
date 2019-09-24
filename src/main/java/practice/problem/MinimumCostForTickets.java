package practice.problem;

// 983. Minimum Cost For Tickets
public class MinimumCostForTickets {
    public int mincostTickets(int[] days, int[] costs) {
        int lastDay = days[days.length - 1];
        boolean[] travel = new boolean[lastDay + 1];
        int[] amount = new int[lastDay + 1];
        for (int d : days) {
            travel[d] = true;
        }
        amount[0] = 0;
        for (int i = 1; i <= lastDay; i++) {
            if (travel[i]) {
                int min = amount[i - 1] + costs[0];
                min = Math.min(min, (i < 7 ? 0 : amount[i - 7]) + costs[1]);
                min = Math.min(min, (i < 30 ? 0 : amount[i - 30]) + costs[2]);
                amount[i] = min;
            } else {
                amount[i] = amount[i - 1];
            }
        }
        return amount[lastDay];
    }
}
