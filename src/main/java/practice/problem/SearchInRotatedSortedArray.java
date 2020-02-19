package practice.problem;

// 33. Search in Rotated Sorted Array
public class SearchInRotatedSortedArray {
    public int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (nums[mid] == target)
                return mid;
            if (nums[mid] > target) {
                if (nums[start] <= nums[mid] && nums[end] <= nums[start] && nums[start] > target) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            } else {
                if (nums[mid] <= nums[end] && nums[end] <= nums[start] && nums[end] < target) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
        }
        return -1;
    }

    public int searchTwo(int[] nums, int target) {
        int start = 0, end = nums.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (nums[mid] == target)
                return mid;
            if (nums[start] <= nums[mid]) {
                if (nums[start] <= target && target < nums[mid])
                    end = mid - 1;
                else
                    start = mid + 1;
            }
            if (nums[mid] <= nums[end]) {
                if (nums[mid] < target && target <= nums[end])
                    start = mid + 1;
                else
                    end = mid - 1;
            }
        }
        return -1;
    }

    public int searchThree(int[] nums, int target) {
        if (nums == null || nums.length == 0)
            return -1;
        int s = 0, e = nums.length - 1;
        while (s + 1 < e) {
            int m = s + (e - s) / 2;
            if (nums[m] == target)
                return m;
            if (nums[s] < nums[m]) {
                if (nums[s] <= target && target <= nums[m])
                    e = m;
                else
                    s = m;
            } else {
                if (nums[m] <= target && target <= nums[e])
                    s = m;
                else
                    e = m;
            }
        }
        if (nums[s] == target)
            return s;
        else if (nums[e] == target)
            return e;
        else
            return -1;
    }
}
