package practice.problem;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

// https://leetcode.com/discuss/interview-question/364618/
public class MinStepsToMakePilesEqualHeight {
    public int solution(int[] arr) {
        int res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int a : arr)
            map.put(a, map.getOrDefault(a, 0) + 1);
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>((a, b) -> b.getKey() - a.getKey());
        pq.addAll(map.entrySet());
        while (pq.size() > 1) {
            Map.Entry<Integer, Integer> first = pq.poll();
            Map.Entry<Integer, Integer> second = pq.poll();
            res += first.getValue();
            second.setValue(second.getValue() + first.getValue());
            pq.offer(second);
        }
        return res;
    }
}
