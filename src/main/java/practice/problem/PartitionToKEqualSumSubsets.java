package practice.problem;

import java.util.Arrays;

// 698. Partition to K Equal Sum Subsets
public class PartitionToKEqualSumSubsets {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        for (int n : nums)
            sum += n;
        if (k <= 0 || sum % k != 0)
            return false;
        int target = sum / k;
        Arrays.sort(nums);
        if (nums[nums.length - 1] > target)
            return false;
        boolean[] visited = new boolean[nums.length];
        while (k > 0 && helper(nums, nums.length - 1, target, visited))
            k--;
        return k == 0;
    }

    private boolean helper(int[] nums, int idx, int target, boolean[] visited) {
        if (target == 0)
            return true;
        if (idx < 0)
            return false;
        if (target < nums[0])
            return false;
        for (int i = idx; i >= 0; i--) {
            if (visited[i] || nums[i] > target)
                continue;
            visited[i] = true;
            if (helper(nums, i - 1, target - nums[i], visited))
                return true;
            visited[i] = false;
        }
        return false;
    }

    public boolean canPartitionKSubsetsTwo(int[] nums, int k) {
        if (k == 1)
            return true;
        int total = 0, max = Integer.MIN_VALUE;
        for (int n : nums) {
            total += n;
            max = Math.max(max, n);
        }
        if (total % k != 0)
            return false;
        int target = total / k;
        if (max > target)
            return false;
        return helperTwo(nums, k, target, 0, new boolean[nums.length], 0);
    }

    private boolean helperTwo(int[] nums, int k, int targetSum, int currSum, boolean[] visited, int idx) {
        if (k == 0)
            return true;
        if (currSum > targetSum)
            return false;
        if (currSum == targetSum)
            return helperTwo(nums, k - 1, targetSum, 0, visited, 0);
        for (int i = idx; i < nums.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                if (helperTwo(nums, k, targetSum, currSum + nums[i], visited, i + 1))
                    return true;
                visited[i] = false;
            }
        }
        return false;
    }
}
