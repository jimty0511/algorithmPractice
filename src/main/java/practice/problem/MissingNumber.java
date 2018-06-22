package practice.problem;

import java.util.Arrays;

// 268. Missing Number
public class MissingNumber {
    public int missingNumber(int[] nums) {
        Arrays.sort(nums);
        int sum = nums.length;
        int missing = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += i;
            missing += nums[i];
        }
        return sum - missing;
    }

    public int missingNumberBit(int[] nums) {
        int xor = 0, i = 0;
        for (i = 0; i < nums.length; i++) {
            xor = xor ^ i ^ nums[i];
        }
        return xor ^ i;
    }
}
