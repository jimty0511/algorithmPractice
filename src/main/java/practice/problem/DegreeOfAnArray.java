package practice.problem;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

// 697. Degree of an Array
public class DegreeOfAnArray {
    public int findShortestSubArray(int[] nums) {
        Map<Integer, Integer> left = new HashMap<>(), right = new HashMap<>(), count = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (!left.containsKey(nums[i]))
                left.put(nums[i], i);
            right.put(nums[i], i);
            count.put(nums[i], count.getOrDefault(nums[i], 0) + 1);
        }
        int ans = nums.length;
        int degree = Collections.max(count.values());
        for (int n : count.keySet()) {
            if (count.get(n) == degree) {
                ans = Math.min(ans, right.get(n) - left.get(n) + 1);
            }
        }
        return ans;
    }
}
