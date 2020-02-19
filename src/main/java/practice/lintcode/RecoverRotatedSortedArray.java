package practice.lintcode;

import java.util.List;

// 39. Recover Rotated Sorted Array
public class RecoverRotatedSortedArray {
    /**
     * @param nums: An integer array
     * @return: nothing
     */
    public void recoverRotatedSortedArray(List<Integer> nums) {
        // write your code here
        for (int i = 0; i < nums.size() - 1; i++) {
            if (nums.get(i) > nums.get(i + 1)) {
                swap(nums, 0, i);
                swap(nums, i + 1, nums.size() - 1);
                swap(nums, 0, nums.size() - 1);
                return;
            }
        }
    }

    private void swap(List<Integer> nums, int start, int end) {
        for (int i = start, j = end; i < j; i++, j--) {
            int tmp = nums.get(i);
            nums.set(i, nums.get(j));
            nums.set(j, tmp);
        }
    }
}
