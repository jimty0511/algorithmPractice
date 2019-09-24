package practice.problem;

// 134. Gas Station
public class GasStation {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        for (int i = 0; i < gas.length; i++) {
            gas[i] -= cost[i];
        }
        int sum = 0, result = 0, n = gas.length;
        for (int i = 0; i < n * 2 - 1; i++) {
            sum += gas[i % n];
            if (sum < 0) {
                result = i + 1;
                if (result >= n)
                    return -1;
                sum = 0;
            }
        }
        return result;
    }

    public int canCompleteCircuitTwo(int[] gas, int[] cost) {
        int tank = 0;
        for (int i = 0; i < gas.length; i++) {
            tank += gas[i] - cost[i];
        }
        if (tank < 0)
            return -1;
        int start = 0, sum = 0;
        for (int i = 0; i < gas.length; i++) {
            int cur = gas[i] - cost[i];
            if (sum + cur < 0) {
                start = i + 1;
                sum = 0;
            } else {
                sum += cur;
            }
        }
        return start;
    }
}
