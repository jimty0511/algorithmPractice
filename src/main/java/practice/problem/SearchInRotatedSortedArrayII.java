package practice.problem;

// 81. Search in Rotated Sorted Array II
public class SearchInRotatedSortedArrayII {
    public boolean search(int[] nums, int target) {
        int start = 0, end = nums.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target)
                return true;
            if (nums[mid] < nums[end]) {
                if (target > nums[mid] && target <= nums[end]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            } else if (nums[mid] > nums[end]) {
                if (target >= nums[start] && target < nums[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else {
                end--;
            }
        }
        return false;
    }

    public boolean searchTwo(int[] nums, int target) {
        int start = 0, end = nums.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (nums[mid] == target)
                return true;
            if (nums[mid] < nums[end] || nums[mid] < nums[start]) {
                if (nums[mid] < target && target <= nums[end]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            } else if (nums[mid] > nums[end] || nums[mid] > nums[start]) {
                if (nums[start] <= target && target < nums[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else {
                end--;
            }
        }
        return false;
    }

    public boolean searchThree(int[] nums, int target) {
        if (nums == null || nums.length == 0)
            return false;
        int s = 0, e = nums.length - 1;
        while (s + 1 < e) {
            int m = s + (e - s) / 2;
            if (nums[m] == target)
                return true;
            if (nums[s] < nums[m]) {
                if (nums[s] <= target && target <= nums[m])
                    e = m;
                else
                    s = m;
            } else if (nums[m] < nums[s]) {
                if (nums[m] < target && target < nums[s])
                    s = m;
                else
                    e = m;
            } else
                e--;
        }
        if (nums[s] == target || nums[e] == target)
            return true;
        else
            return false;
    }
}
