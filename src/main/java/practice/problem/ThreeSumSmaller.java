package practice.problem;

import java.util.Arrays;

// 259. 3Sum Smaller
public class ThreeSumSmaller {
    public int threeSumSmaller(int[] nums, int target) {
        Arrays.sort(nums);
        int low, high, result = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            low = i + 1;
            high = nums.length - 1;
            while (low < high) {
                if (nums[low] + nums[high] + nums[i] < target) {
                    result += high - low;
                    low++;
                } else {
                    high--;
                }
            }
        }
        return result;
    }
}
