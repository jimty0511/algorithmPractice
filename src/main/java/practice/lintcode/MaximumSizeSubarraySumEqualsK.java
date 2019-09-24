package practice.lintcode;

import java.util.HashMap;
import java.util.Map;

// 911. Maximum Size Subarray Sum Equals k
public class MaximumSizeSubarraySumEqualsK {
    public int maxSubArrayLen(int[] nums, int k) {
        // Write your code here
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int res = 0, preSum = 0;
        for (int i = 0; i < nums.length; i++) {
            preSum += nums[i];
            if (map.containsKey(preSum - k))
                res = Math.max(res, i - map.get(preSum - k));
            if (!map.containsKey(preSum))
                map.put(preSum, i);
        }
        return res;
    }
}
