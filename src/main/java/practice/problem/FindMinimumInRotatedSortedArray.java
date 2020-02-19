package practice.problem;

// 153. Find Minimum in Rotated Sorted Array
// Microsoft ladder
public class FindMinimumInRotatedSortedArray {
    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        if (nums.length == 1)
            return nums[0];
        int start = 0, end = nums.length - 1;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (mid > 0 && nums[mid] < nums[mid - 1])
                return nums[mid];
            if (nums[start] <= nums[mid] && nums[mid] > nums[end])
                start = mid + 1;
            else
                end = mid - 1;
        }
        return nums[start];
    }

    public int findMinTwo(int[] nums) {
        if (nums == null || nums.length == 0)
            return -1;
        if (nums.length == 1)
            return nums[0];
        int left = 0, right = nums.length - 1, target = nums[nums.length - 1];
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target)
                right = mid;
            else
                left = mid;
        }
        return Math.min(nums[left], nums[right]);
    }
}
