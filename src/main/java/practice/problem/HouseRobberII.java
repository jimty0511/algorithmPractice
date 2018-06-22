package practice.problem;

// 213. House Robber II
public class HouseRobberII {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
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

    public int robDp(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length < 2) return nums[0];
        int[] startFromFirst = new int[nums.length + 1];
        int[] startFromSecond = new int[nums.length + 1];
        startFromFirst[0] = 0;
        startFromFirst[1] = nums[0];
        startFromSecond[0] = 0;
        startFromSecond[1] = 0;
        for (int i = 2; i <= nums.length; i++) {
            startFromFirst[i] = Math.max(nums[i - 1] + startFromFirst[i - 2], startFromFirst[i - 1]);
            startFromSecond[i] = Math.max(nums[i - 1] + startFromSecond[i - 2], startFromSecond[i - 1]);
        }
        return Math.max(startFromFirst[nums.length - 1], startFromSecond[nums.length]);
    }
}
