package practice.problem;

// 517. Super Washing Machines
public class SuperWashingMachines {
    public int findMinMoves(int[] machines) {
        int total = 0;
        for (int m : machines)
            total += m;
        if (total % machines.length != 0)
            return -1;
        int avg = total / machines.length, cnt = 0, max = 0;
        for (int load : machines) {
            cnt += load - avg;
            max = Math.max(Math.max(max, Math.abs(cnt)), load - avg);
        }
        return max;
    }

    public int findMinMovesTwo(int[] machines) {
        int total = 0;
        for (int m : machines)
            total += m;
        if (total % machines.length != 0)
            return -1;
        int res = 0, n = machines.length;
        int target = total / n;
        int[] move = new int[n];
        for (int i = 0; i < n - 1; i++) {
            if (machines[i] > target) {
                move[i] += machines[i] - target;
                machines[i + 1] += machines[i] - target;
                machines[i] = target;
                res = Math.max(res, move[i]);
            } else {
                move[i + 1] = target - machines[i];
                machines[i + 1] -= target - machines[i];
                machines[i] = target;
                res = Math.max(res, move[i + 1]);
            }
        }
        return res;
    }
}
