package practice.problem;

import javafx.util.Pair;

import java.util.*;

// 826. Most Profit Assigning Work
public class MostProfitAssigningWork {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        List<Pair<Integer, Integer>> jobs = new ArrayList<>();
        int n = profit.length, res = 0, i = 0, max = 0;
        for (int j = 0; j < n; j++)
            jobs.add(new Pair<>(difficulty[j], profit[j]));
        Collections.sort(jobs, (a, b) -> a.getKey() - b.getKey());
        Arrays.sort(worker);
        for (int a : worker) {
            while (i < n && a >= jobs.get(i).getKey())
                max = Math.max(jobs.get(i++).getValue(), max);
            res += max;
        }
        return res;
    }

    public int maxProfitAssignmentTm(int[] difficulty, int[] profit, int[] worker) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        // in case two jobs have same difficulty but different profit, we want to count
        // the higher profit
        for (int i = 0; i < difficulty.length; i++) {
            map.put(difficulty[i], Math.max(profit[i], map.getOrDefault(difficulty[i], 0)));
        }
        int max = 0, res = 0;
        // maximum profit at this difficulty or below in case
        // lower difficulty job offers higher profit
        for (Integer key : map.keySet()) {
            max = Math.max(max, map.get(key));
            map.put(key, max);
        }
        for (int i = 0; i < worker.length; i++) {
            if (map.containsKey(worker[i]))
                res += map.get(worker[i]);
            else {
                Integer floorKey = map.floorKey(worker[i]);
                if (floorKey != null)
                    res += map.get(floorKey);
            }
        }
        return res;
    }
}
