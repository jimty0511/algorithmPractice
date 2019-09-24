package practice.problem;

import java.util.Arrays;

// 31. Next Permutation
public class NextPermutation {
    public void nextPermutation(int[] nums) {
        if (nums.length <= 1)
            return;
        int i = nums.length - 1;
        while (i - 1 >= 0 && nums[i - 1] >= nums[i])
            i--;
        if (i - 1 >= 0) {
            int j = nums.length - 1;
            while (nums[j] <= nums[i - 1])
                j--;
            swap(nums, i - 1, j);
        }
        Arrays.sort(nums, i, nums.length);
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
