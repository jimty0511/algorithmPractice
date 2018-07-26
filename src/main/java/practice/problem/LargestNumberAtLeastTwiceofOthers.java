package practice.problem;

// 747. Largest Number At Least Twice of Others
public class LargestNumberAtLeastTwiceofOthers {
    public int dominantIndex(int[] nums) {
        if (nums == null || nums.length == 0)
            return -1;
        if (nums.length == 1)
            return 0;
        int max = Integer.MIN_VALUE + 1;
        int secMax = Integer.MIN_VALUE;
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max) {
                secMax = max;
                max = nums[i];
                index = i;
            } else if (nums[i] != max && nums[i] > secMax) {
                secMax = nums[i];
            }
        }
        if (secMax * 2 <= max)
            return index;
        else
            return -1;
    }
}
