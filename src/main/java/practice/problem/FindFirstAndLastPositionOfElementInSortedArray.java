package practice.problem;

// 34. Find First and Last Position of Element in Sorted Array
public class FindFirstAndLastPositionOfElementInSortedArray {
    public int[] searchRange(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                int left = mid, right = mid;
                while (left >= 0 && nums[left] == target) {
                    left--;
                }
                while (right <= nums.length - 1 && nums[right] == target) {
                    right++;
                }
                return new int[]{left + 1, right - 1};
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return new int[]{-1, -1};
    }
}
