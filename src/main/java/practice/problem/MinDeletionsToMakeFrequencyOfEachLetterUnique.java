package practice.problem;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

// https://leetcode.com/discuss/interview-question/398035/
public class MinDeletionsToMakeFrequencyOfEachLetterUnique {
    public int solution(String s) {
        if (s == null || s.length() == 0)
            return 0;
        Map<Character, Integer> freq = new HashMap<>();
        Map<Integer, Integer> cnt = new HashMap<>();
        for (char c : s.toCharArray())
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        for (int val : freq.values()) {
            cnt.put(val, cnt.getOrDefault(val, 0) + 1);
        }
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>((a, b) -> b.getKey() - a.getKey());
        pq.addAll(cnt.entrySet());
        int res = 0;
        while (pq.size() > 1) {
            Map.Entry<Integer, Integer> first = pq.poll();
            Map.Entry<Integer, Integer> second = pq.poll();
            res += first.getValue() - 1;
            second.setValue(second.getValue() + first.getValue() - 1);
            pq.offer(second);
        }
        Map.Entry<Integer, Integer> last = pq.poll();
        if (last.getValue() > last.getKey()) {
            res += last.getKey() * (last.getValue() - last.getKey());
            last.setValue(last.getKey());
        }
        res += last.getValue() * (last.getValue() - 1) / 2;
        return res;
    }
}
