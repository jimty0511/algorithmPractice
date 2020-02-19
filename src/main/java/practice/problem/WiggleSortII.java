package practice.problem;

import java.util.Arrays;

// 324. Wiggle Sort II
public class WiggleSortII {

    public void wiggleSortLC(int[] nums) {
        int n = nums.length;
        int mid = partition(nums, 0, n - 1, (n + 1) / 2);
        int odd = 1, even = n % 2 == 0 ? n - 2 : n - 1;
        int[] tmp = new int[n];
        for (int i = 0; i < n; i++) {
            if (nums[i] > mid) {
                tmp[odd] = nums[i];
                odd += 2;
            } else if (nums[i] < mid) {
                tmp[even] = nums[i];
                even -= 2;
            }
        }
        while (odd < n) {
            tmp[odd] = mid;
            odd += 2;
        }
        while (even >= 0) {
            tmp[even] = mid;
            odd -= 2;
        }
        for (int i = 0; i < n; i++)
            nums[i] = tmp[i];
    }

    private int partition(int[] nums, int start, int end, int k) {
        if (start >= end)
            return nums[k];
        int l = start, r = end;
        int pivot = nums[(start + end) / 2];
        while (l <= r) {
            while (l <= r && nums[l] < pivot)
                l++;
            while (l <= r && nums[r] > pivot)
                r--;
            if (l <= r) {
                int tmp = nums[l];
                nums[l] = nums[r];
                nums[r] = tmp;
                l++;
                r--;
            }
        }
        if (k <= r) {
            return partition(nums, start, r, k);
        }
        if (k >= l) {
            return partition(nums, l, end, k);
        }
        return nums[k];
    }

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
