package practice.lintcode;

import java.util.Arrays;
import java.util.Random;

// 544. Top k Largest Numbers
public class TopKLargestNumbers {

    private Random random = new Random();

    /**
     * @param nums: an integer array
     * @param k:    An integer
     * @return: the top k largest numbers in array
     */
    public int[] topk(int[] nums, int k) {
        // write your code here
        quickSort(nums, 0, nums.length - 1, k);
        int[] res = Arrays.copyOfRange(nums, 0, k);
        return res;
    }

    private void quickSort(int[] nums, int start, int end, int k) {
        if (start >= k)
            return;
        if (start >= end)
            return;
        int left = start, right = end;
        int idx = random.nextInt(end - start + 1) + start;
        int pivot = nums[idx];
        while (left <= right) {
            while (left <= right && nums[left] > pivot)
                left++;
            while (left <= right && nums[right] < pivot)
                right--;
            if (left <= right) {
                int tmp = nums[left];
                nums[left] = nums[right];
                nums[right] = tmp;
                left++;
                right--;
            }
        }
        if (start < right)
            quickSort(nums, start, right, k);
        if (left < end)
            quickSort(nums, left, end, k);
    }
}
