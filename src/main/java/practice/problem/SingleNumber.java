package practice.problem;

import java.util.Arrays;

// 136. Single Number
public class SingleNumber {
    public int singleNumber(int[] nums) {
        int res = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 0) {
                res += nums[i];
            } else {
                res -= nums[i];
            }
        }
        return res;
    }

    public int singleNumberBit(int[] nums) {
        int res = 0;
        for (int num : nums) {
            res ^= num;
        }
        return res;
    }
}
