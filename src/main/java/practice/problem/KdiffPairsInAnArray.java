package practice.problem;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

// 532. K-diff Pairs in an Array
public class KdiffPairsInAnArray {
    public int findPairs(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k < 0)
            return 0;
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        for (int key : map.keySet()) {
            if (k == 0) {
                if (map.get(key) >= 2)
                    count++;
            } else {
                if (map.containsKey(key + k))
                    count++;
            }
        }
        return count;
    }

    public int findPairsTwi(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length, res = 0;
        for (int i = 0, j = 0; i < n; i++) {
            if (i == j)
                j++;
            while (i + 1 < n && nums[i] == nums[i + 1])
                i++;
            while (j + 1 < n && nums[j] == nums[j + 1])
                j++;
            while (j < n && Math.abs(nums[j] - nums[i]) < k)
                j++;
            if (j >= n)
                break;
            if (Math.abs(nums[j] - nums[i]) == k) {
                res++;
                j++;
            }
        }
        return res;
    }
}
