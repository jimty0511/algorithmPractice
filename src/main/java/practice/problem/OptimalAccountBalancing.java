package practice.problem;

import java.util.*;

// 465. Optimal Account Balancing
public class OptimalAccountBalancing {
    public int minTransfersTwo(int[][] transactions) {
        Map<Integer, Integer> personToDebt = new HashMap<>();
        for (int[] t : transactions) {
            personToDebt.put(t[0], personToDebt.getOrDefault(t[0], 0) - t[2]);
            personToDebt.put(t[1], personToDebt.getOrDefault(t[1], 0) + t[2]);
        }
        List<Integer> list = new ArrayList<>();
        return helperTwo(new ArrayList<>(personToDebt.values()), 0);
    }

    private int helperTwo(List<Integer> debts, int start) {
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

    //LC
    /*
     * @param edges: a directed graph where each edge is represented by a tuple
     * @return: the number of edges
     */
    public int balanceGraph(int[][] edges) {
        // Write your code here
        Map<Integer, Integer> map = new HashMap<>();
        for (int[] e : edges) {
            map.put(e[0], map.getOrDefault(e[0], 0) - e[2]);
            map.put(e[1], map.getOrDefault(e[1], 0) + e[2]);
        }
        List<Integer> list = new ArrayList<>();
        for (int v : map.values()) {
            if (v != 0)
                list.add(v);
        }
        int matchCount = removeMatched(list);
        return helper(new ArrayList<>(map.values()), 0);
    }

    private int removeMatched(List<Integer> list) {
        Collections.sort(list);
        int l = 0, r = list.size() - 1;
        int cnt = 0;
        while (l < r) {
            if (list.get(l) + list.get(r) == 0) {
                list.remove(l);
                list.remove(r - 1);
                r -= 2;
                cnt++;
            } else if (list.get(l) + list.get(r) < 0)
                l++;
            else
                r--;
        }
        return cnt;
    }

    private int helper(List<Integer> list, int start) {
        while (start < list.size() && list.get(start) == 0)
            start++;
        if (start == list.size())
            return 0;
        int r = Integer.MAX_VALUE;
        for (int i = start + 1; i < list.size(); i++) {
            if (list.get(start) * list.get(i) < 0) {
                list.set(i, list.get(i) + list.get(start));
                r = Math.min(r, 1 + helper(list, start + 1));
                list.set(i, list.get(i) - list.get(start));
            }
        }
        return r;
    }

    public int balanceGraphDp(int[][] edges) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int[] e : edges) {
            map.put(e[0], map.getOrDefault(e[0], 0) - e[2]);
            map.put(e[1], map.getOrDefault(e[1], 0) + e[2]);
        }
        int[] acc = new int[map.size()];
        int len = 0;
        for (int v : map.values()) {
            if (v != 0)
                acc[len++] = v;
        }
        if (len == 0)
            return 0;
        int[] dp = new int[1 << len];
        Arrays.fill(dp, Integer.MAX_VALUE / 2);
        for (int i = 1; i < dp.length; i++) {
            int sum = 0, cnt = 0;
            for (int j = 0; j < len; j++) {
                if ((1 << j & i) != 0) {
                    sum += acc[j];
                    cnt++;
                }
            }
            if (sum == 0) {
                dp[i] = cnt - 1;
                for (int j = 1; j < i; j++) {
                    if (((i & j) == j) && dp[j] + dp[i - j] < dp[i])
                        dp[i] = dp[j] + dp[i - j];
                }
            }
        }
        return dp[dp.length - 1];
    }
}
