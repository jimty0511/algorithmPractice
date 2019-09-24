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

    public int findShortestSubArrayTwo(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        Map<Integer, int[]> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i]))
                map.put(nums[i], new int[]{1, i, i});
            else {
                int[] tmp = map.get(nums[i]);
                tmp[0]++;
                tmp[2] = i;
            }
        }
        int degree = Integer.MIN_VALUE, res = Integer.MAX_VALUE;
        for (int[] val : map.values()) {
            if (val[0] > degree) {
                degree = val[0];
                res = val[2] - val[1] + 1;
            } else if (val[0] == degree) {
                res = Math.min(res, val[2] - val[1] + 1);
            }
        }
        return res;
    }
}
