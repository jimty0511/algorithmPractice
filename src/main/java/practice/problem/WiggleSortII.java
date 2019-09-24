package practice.problem;

// 324. Wiggle Sort II
public class WiggleSortII {
    public void wiggleSort(int[] nums) {
        int median = findKlargestElement(nums, (nums.length + 1) / 2);
        int n = nums.length;
        int left = 0, i = 0, right = n - 1;
        while (i <= right) {
            if (nums[newIndex(i, n)] > median) {
                swap(nums, newIndex(left++, n), newIndex(i++, n));
            } else if (nums[newIndex(i, n)] < median) {
                swap(nums, newIndex(right--, n), newIndex(i, n));
            } else
                i++;
        }
    }

    public int newIndex(int index, int n) {
        return (1 + 2 * index) % (n | 1);
    }

    private int findKlargestElement(int[] nums, int k) {
        int left = 0, right = nums.length - 1;
        while (true) {
            int pos = quickSelect(nums, left, right);
            if (pos + 1 == k)
                return nums[pos];
            else if (pos + 1 > k)
                right = pos - 1;
            else
                left = pos + 1;
        }
    }

    private int quickSelect(int[] nums, int left, int right) {
        int pivot = nums[left];
        int l = left + 1, r = right;
        while (l <= r) {
            if (nums[l] < pivot && nums[r] > pivot) {
                swap(nums, l++, r--);
            }
            if (nums[l] >= pivot)
                l++;
            if (nums[r] <= pivot)
                r--;
        }
        swap(nums, left, r);
        return r;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
