package practice.lintcode;

public class MergeKSortedArray {
    public int[] mergekSortedArrays(int[][] arrays) {
        // write your code here
        return partition(arrays, 0, arrays.length - 1);
    }

    private int[] partition(int[][] arrays, int s, int e) {
        if (s == e)
            return arrays[s];
        if (s < e) {
            int mid = s + (e - s) / 2;
            int[] nums1 = partition(arrays, s, mid);
            int[] nums2 = partition(arrays, mid + 1, e);
            return merge(nums1, nums2);
        } else
            return null;
    }

    private int[] merge(int[] nums1, int[] nums2) {
        if (nums1 == null)
            return nums2;
        if (nums2 == null)
            return nums1;
        int m = nums1.length, n = nums2.length, i = 0, j = 0, idx = 0;
        int[] res = new int[m + n];
        while (i < m && j < n) {
            if (nums1[i] < nums2[j]) {
                res[idx++] = nums1[i++];
            } else {
                res[idx++] = nums2[j++];
            }
        }
        while (i < m)
            res[idx++] = nums1[i++];
        while (j < n)
            res[idx++] = nums2[j++];
        return res;
    }
}
