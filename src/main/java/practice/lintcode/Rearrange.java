package practice.lintcode;

import java.util.Arrays;

// 951. Rearrange
public class Rearrange {
    /**
     * @param nums: the num arrays
     * @return: the num arrays after rearranging
     */
    public int[] rearrange(int[] nums) {
        // Write your code here
        Arrays.sort(nums);
        int[] ans = new int[nums.length];
        int idx = 0;
        for (int i = 0; i < ans.length; i += 2)
            ans[i] = nums[idx++];
        for (int i = 1; i < ans.length; i += 2)
            ans[i] = nums[idx++];
        return ans;
    }
}
