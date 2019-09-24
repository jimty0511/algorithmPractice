package practice.problem;

import java.util.HashMap;
import java.util.Map;

// 169. Majority Element
public class MajorityElement {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
            if (map.get(n) > nums.length / 2)
                return n;
        }
        return 0;
    }

    public int majorityElementMoore(int[] nums) {
        int res = 0, count = 0;
        for (int n : nums) {
            if (count == 0)
                res = n;
            if (res != n)
                count--;
            else
                count++;
        }
        return res;
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
