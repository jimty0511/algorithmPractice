package practice.problem;

import java.util.PriorityQueue;

// 215. Kth Largest Element in an Array
//Microsoft ladder
public class KthLargestElementInAnArray {

    public int findKthLargestLc(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k < 1 || k > nums.length)
            return -1;
        return partition(nums, 0, nums.length - 1, nums.length - k);
    }

    private int partition(int[] nums, int start, int end, int k) {
        if (start >= end)
            return nums[k];
        int left = start, right = end;
        int pivot = nums[left];
        while (left <= right) {
            while (left <= right && nums[left] < pivot)
                left++;
            while (left <= right && nums[right] > pivot)
                right--;
            if (left <= right) {
                swap(nums, left, right);
                left++;
                right--;
            }
        }
        if (left - start == k) {
            return pivot;
        } else if (left - start < k) {
            return partition(nums, left + 1, end, k - (left - start + 1));
        } else {
            return partition(nums, start, right - 1, k);
        }
    }

    public long findKthLargest(long[] nums, long k) {
        long start = 0, end = nums.length - 1, idx = nums.length - k;
        while (start < end) {
            long pivot = findKthLargestHelper(nums, start, end);
            if (pivot < idx)
                start = pivot + 1;
            else if (pivot > idx)
                end = pivot - 1;
            else
                return nums[(int) pivot];
        }
        return nums[(int) start];
    }

    private long findKthLargestHelper(long[] nums, long start, long end) {
        long pivot = start, tmp;
        while (start <= end) {
            while (start <= end && nums[(int) start] <= nums[(int) pivot])
                start++;
            while (start <= end && nums[(int) end] > nums[(int) pivot])
                end--;
            if (start > end)
                break;
            tmp = nums[(int) start];
            nums[(int) start] = nums[(int) end];
            nums[(int) end] = tmp;
        }
        tmp = nums[(int) end];
        nums[(int) end] = nums[(int) pivot];
        nums[(int) pivot] = tmp;
        return end;
    }

    public int findKthLargest(int[] nums, int k) {
        int start = 0, end = nums.length - 1, index = nums.length - k;
        while (start < end) {
            int pivot = findKthLargestHelper(nums, start, end);
            if (pivot < index)
                start = pivot + 1;
            else if (pivot > index)
                end = pivot - 1;
            else
                return nums[pivot];
        }
        return nums[start];
    }

    private int findKthLargestHelper(int[] nums, int start, int end) {
        int pivot = start, temp;
        while (start <= end) {
            while (start <= end && nums[start] <= nums[pivot])
                start++;
            while (start <= end && nums[end] > nums[pivot])
                end--;
            if (start > end)
                break;
            temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
        }
        temp = nums[end];
        nums[end] = nums[pivot];
        nums[pivot] = temp;
        return end;
    }

    public int findKthLargestPq(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> a - b);
        for (int n : nums) {
            if (pq.size() < k || n > pq.peek()) {
                pq.offer(n);
            }
            if (pq.size() > k) {
                pq.poll();
            }
        }
        return pq.peek();
    }

    public int findKthLargestTwo(int[] nums, int k) {
        if (nums == null || nums.length == 0)
            return Integer.MAX_VALUE;
        return helperTwo(nums, 0, nums.length - 1, nums.length - k);
    }

    private int helperTwo(int[] nums, int start, int end, int k) {
        if (start > end)
            return Integer.MAX_VALUE;
        int pivot = nums[end];
        int left = start;
        for (int i = start; i < end; i++) {
            if (nums[i] <= pivot)
                swap(nums, left++, i);
        }
        swap(nums, left, end);
        if (left == k)
            return nums[left];
        else if (left < k)
            return helperTwo(nums, left + 1, end, k);
        else
            return helperTwo(nums, start, left - 1, k);
    }

    private void swap(int[] A, int i, int j) {
        int tmp = A[i];
        A[i] = A[j];
        A[j] = tmp;
    }

    public int findKthLargestThree(int[] nums, int k) {
        if (nums == null || nums.length == 0)
            return 0;
        int left = 0, right = nums.length - 1;
        while (true) {
            int pos = quickSelect(nums, left, right);
            if (pos + 1 == k) {
                return nums[pos];
            } else if (pos + 1 > k) {
                right = pos - 1;
            } else {
                left = pos + 1;
            }
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
}
