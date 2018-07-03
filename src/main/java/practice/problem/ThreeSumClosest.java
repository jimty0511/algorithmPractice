package practice.problem;

import java.util.Arrays;

// 16. 3Sum Closest
public class ThreeSumClosest {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int closest = nums[0] + nums[1] + nums[2];
        int low, high;
        for (int i = 0; i < nums.length - 1; i++) {
            low = i + 1;
            high = nums.length - 1;
            while (low < high) {
                if (nums[low] + nums[high] == target - nums[i])
                    return target;
                else if (nums[low] + nums[high] > target - nums[i]) {
                    while (low < high && nums[low] + nums[high] > target - nums[i])
                        high--;
                    if (Math.abs(nums[i] + nums[low] + nums[high + 1] - target) < Math.abs(closest - target))
                        closest = nums[i] + nums[low] + nums[high + 1];
                } else {
                    while (low < high && nums[low] + nums[high] < target - nums[i])
                        low++;
                    if (Math.abs(nums[i] + nums[low - 1] + nums[high] - target) < Math.abs(closest - target))
                        closest = nums[i] + nums[low - 1] + nums[high];
                }
            }
        }
        return closest;
    }

    public int threeSumClosestTwo(int[] nums, int target) {
        int result = nums[0] + nums[1] + nums[nums.length - 1];
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            int start = i + 1, end = nums.length - 1;
            while (start < end) {
                int sum = nums[i] + nums[start] + nums[end];
                if (sum > target) {
                    end--;
                } else {
                    start++;
                }
                if (Math.abs(sum - target) < Math.abs(result - target))
                    result = sum;
            }
        }
        return result;
    }
}
