package practice.problem;

// 154. Find Minimum in Rotated Sorted Array II
public class FindMinimumInRotatedSortedArrayII {
    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0)
            return -1;
        if (nums.length == 1)
            return nums[0];
        int start = 0, end = nums.length - 1;
        while (start < end) {
            if (nums[start] < nums[end])
                return nums[start];
            int mid = start + (end - start) / 2;
            if (nums[start] > nums[mid]) {
                end = mid;
            } else if (nums[start] < nums[mid]) {
                start = mid + 1;
            } else {
                if (nums[start] == nums[end]) {
                    start++;
                    end--;
                } else {
                    start = mid + 1;
                }
            }
        }
        return nums[start];
    }

    public int findMinTwo(int[] nums) {
        int start = 0, end = nums.length - 1;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] > nums[end]) {
                start = mid + 1;
            } else if (nums[mid] < nums[start]) {
                end = mid;
//                start++;
            } else {
                end--;
            }
        }
        return Math.min(nums[end], nums[start]);
    }
}
