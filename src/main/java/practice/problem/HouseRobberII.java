package practice.problem;

// 213. House Robber II
public class HouseRobberII {
    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
        return Math.max(helper(nums, 0, nums.length - 2), helper(nums, 1, nums.length - 1));
    }

    public int helper(int[] nums, int low, int high) {
        int prevNo = 0, prevYes = 0;
        for (int i = low; i <= high; i++) {
            int temp = prevNo;
            prevNo = Math.max(prevNo, prevYes);
            prevYes = temp + nums[i];
        }
        return Math.max(prevNo, prevYes);
    }
}
