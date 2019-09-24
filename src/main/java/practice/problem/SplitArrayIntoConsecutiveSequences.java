package practice.problem;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

// 659. Split Array into Consecutive Subsequences
public class SplitArrayIntoConsecutiveSequences {
    public boolean isPossible(int[] nums) {
        Map<Integer, Integer> freq = new HashMap<>(), appendFreq = new HashMap<>();
        for (int n : nums) {
            freq.put(n, freq.getOrDefault(n, 0) + 1);
        }
        for (int n : nums) {
            if (freq.get(n) == 0)
                continue;
            else if (appendFreq.getOrDefault(n, 0) > 0) {
                appendFreq.put(n, appendFreq.get(n) - 1);
                appendFreq.put(n + 1, appendFreq.getOrDefault(n + 1, 0) + 1);
            } else if (freq.getOrDefault(n + 1, 0) > 0 &&
                    freq.getOrDefault(n + 2, 0) > 0) {
                freq.put(n + 1, freq.get(n + 1) - 1);
                freq.put(n + 2, freq.get(n + 2) - 1);
                appendFreq.put(n + 3, appendFreq.getOrDefault(n + 3, 0) + 1);
            } else {
                return false;
            }
            freq.put(n, freq.get(n) - 1);
        }
        return true;
    }

    class Interval {
        int start, end, len;

        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
            len = end - start + 1;
        }
    }

    public boolean isPossibleTwo(int[] nums) {
        PriorityQueue<Interval> pq = new PriorityQueue<>((a, b) -> a.end == b.end ? a.len - b.len : a.end - b.end);
        for (int n : nums) {
            while (!pq.isEmpty() && pq.peek().end + 1 < n) {
                if (pq.poll().len < 3)
                    return false;
            }
            if (pq.isEmpty() || pq.peek().end == n) {
                pq.offer(new Interval(n, n));
            } else {
                pq.offer(new Interval(pq.poll().start, n));
            }
        }
        while (!pq.isEmpty()) {
            if (pq.poll().len < 3)
                return false;
        }
        return true;
    }
}
