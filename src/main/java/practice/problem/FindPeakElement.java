package practice.problem;

// 162. Find Peak Element
public class FindPeakElement {
    public int findPeakElement(int[] nums) {
        return findPeakElementHelper(nums, 0, nums.length - 1);
    }

    private int findPeakElementHelper(int[] nums, int start, int end) {
        if (start == end) {
            return start;
        } else if (start + 1 == end) {
            if (nums[start] > nums[end]) {
                return start;
            }
            return end;
        } else {
            int m = (start + end) / 2;
            if (nums[m] > nums[m - 1] && nums[m] > nums[m + 1]) {
                return m;
            } else if (nums[m - 1] > nums[m] && nums[m] > nums[m + 1]) {
                return findPeakElementHelper(nums, start, m - 1);
            } else {
                return findPeakElementHelper(nums, m + 1, end);
            }
        }
    }

    public int findPeakElementIter(int[] nums) {
        int N = nums.length;
        if (N == 1)
            return 0;
        int left = 0, right = N - 1;
        while (right - left > 1) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < nums[mid + 1]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return (left == N - 1 || nums[left] > nums[left + 1]) ? left : right;
    }

    public int findPeakElementIterThree(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < nums[mid + 1])
                left = mid + 1;
            else
                right = mid;
        }
        return left;
    }

    public int findPeakElementIterTwo(int[] nums) {
        int n = nums.length;
        int l = 0, r = n - 1;
        while (l < r) {
            if (l + 1 == r) {
                if (nums[l] > nums[r])
                    return l;
                else
                    return r;
            }
            int mid = l + (r - l) / 2;
            if (nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1])
                return mid;
            else if (nums[mid] > nums[mid - 1] && nums[mid] < nums[mid + 1])
                l = mid + 1;
            else
                r = mid - 1;
        }
        return l;
    }
}
