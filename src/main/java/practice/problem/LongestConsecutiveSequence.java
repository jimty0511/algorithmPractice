package practice.problem;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

// 128. Longest Consecutive Sequence
public class LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        Set<Integer> set = new HashSet<>();
        for (int n : nums)
            set.add(n);
        int max = 1;
        for (int n : nums) {
            if (set.remove(n)) {
                int val = n;
                int sum = 1;
                while (set.remove(val - 1)) {
                    val--;
                    sum++;
                }
                val = n;
                while (set.remove(val + 1)) {
                    val++;
                    sum++;
                }
                max = Math.max(sum, max);
            }
        }
        return max;
    }

    public int longestConsecutiveMap(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int max = 1;
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : nums) {
            if (!map.containsKey(n)) {
                int left = map.containsKey(n - 1) ? map.get(n - 1) : 0;
                int right = map.containsKey(n + 1) ? map.get(n + 1) : 0;
                int sum = left + right + 1;
                map.put(n, sum);
                max = Math.max(max, sum);
                map.put(n - left, sum);
                map.put(n + right, sum);
            } else {
                continue;
            }
        }
        return max;
    }
}
