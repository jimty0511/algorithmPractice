package practice.problem;

import java.util.HashMap;
import java.util.Map;

// 169. Majority Element
public class MajorityElement {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        Map.Entry<Integer, Integer> res = null;
        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > nums.length / 2) {
                res = entry;
            }
        }
        return res.getKey();
    }

    public int majorityElementMoore(int[] nums) {
        int len = nums.length, candidate = nums[0], count = 1;
        for (int i = 1; i < len; i++) {
            if (nums[i] == candidate) {
                count++;
            } else {
                count--;
                if (count == 0) {
                    candidate = nums[i];
                    count = 1;
                }
            }
        }
        return candidate;
    }

    public int majorityElementBit(int[] nums) {
        int ans = 0;
        for (int i = 0; i < 32; i++) {
            int ones = 0, zeros = 0;
            for (int j = 0; j < nums.length; j++) {
                if (((nums[j] >> i) & 1) == 1) {
                    ones++;
                } else {
                    zeros++;
                }
            }
            if (ones > zeros)
                ans |= (1 << i);
        }
        return ans;
    }
}
