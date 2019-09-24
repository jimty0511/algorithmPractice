package practice.problem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// 465. Optimal Account Balancing
public class OptimalAccountBalancing {
    public int minTransfers(int[][] transactions) {
        Map<Integer, Integer> personToDebt = new HashMap<>();
        for (int[] t : transactions) {
            personToDebt.put(t[0], personToDebt.getOrDefault(t[0], 0) - t[2]);
            personToDebt.put(t[1], personToDebt.getOrDefault(t[1], 0) + t[2]);
        }
        return helper(new ArrayList<>(personToDebt.values()), 0);
    }

    private int helper(List<Integer> debts, int start) {
        while (start < debts.size() && debts.get(start) == 0)
            start++;
        if (start == debts.size())
            return 0;
        int r = Integer.MAX_VALUE;
        for (int i = start + 1; i < debts.size(); i++) {
            if (debts.get(start) * debts.get(i) < 0) {
                debts.set(i, debts.get(i) + debts.get(start));
                r = Math.min(r, 1 + helper(debts, start + 1));
                debts.set(i, debts.get(i) - debts.get(start));
            }
        }
        return r;
    }
}
