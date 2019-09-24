package practice.problem;

import java.util.Arrays;

// 493. Reverse Pairs
public class ReversePairs {
    public int reversePairs(int[] nums) {
        return mergeSort(nums, 0, nums.length - 1);
    }

    private int mergeSort(int[] nums, int s, int e) {
        if (s >= e)
            return 0;
        int mid = s + (e - s) / 2;
        int cnt = mergeSort(nums, s, mid) + mergeSort(nums, mid + 1, e);
        for (int i = s, j = mid + 1; i <= mid; i++) {
            while (j <= e && nums[i] / 2.0 > nums[j])
                j++;
            cnt += j - (mid + 1);
        }
        Arrays.sort(nums, s, e + 1);
        return cnt;
    }


    /**
     * BIT way
     */
//    private int search(int[] bit, int i) {
//        int sum = 0;
//        while (i < bit.length) {
//            sum += bit[i];
//            i += i & -i;
//        }
//        return sum;
//    }
//
//    private void insert(int[] bit, int i) {
//        while (i > 0) {
//            bit[i] += 1;
//            i -= i & -i;
//        }
//    }
//
//    public int reversePairs(int[] nums) {
//        int res = 0;
//        int[] copy = Arrays.copyOf(nums, nums.length);
//        int[] bit = new int[copy.length + 1];
//        Arrays.sort(copy);
//        for (int ele : nums) {
//            res += search(bit, index(copy, 2L * ele + 1));
//            insert(bit, index(copy, ele));
//        }
//        return res;
//    }
//
//    private int index(int[] arr, long val) {
//        int l = 0, r = arr.length - 1, m = 0;
//        while (l <= r) {
//            m = l + (r - l) / 2;
//            if (arr[m] >= val) {
//                r = m - 1;
//            } else {
//                l = m + 1;
//            }
//        }
//        return l + 1;
//    }
}
