package practice.problem;

// 4. Median of Two Sorted Arrays
// Microsoft ladder
public class MedianOfTwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        if (m < n) return findMedianSortedArrays(nums2, nums1);
        int left = 0, right = 2 * n;
        while (left <= right) {
            int mid2 = (left + right) / 2;
            int mid1 = m + n - mid2;
            double L1 = mid1 == 0 ? Double.MIN_VALUE : nums1[(mid1 - 1) / 2];
            double R1 = mid1 == m * 2 ? Double.MAX_VALUE : nums1[mid1 / 2];
            double L2 = mid2 == 0 ? Double.MIN_VALUE : nums2[(mid2 - 1) / 2];
            double R2 = mid2 == n * 2 ? Double.MAX_VALUE : nums2[mid2 / 2];

            if (L1 > R2)
                left = mid2 + 1;
            else if (L2 > R1)
                right = mid2 - 1;
            else
                return (Math.max(L1, L2) + Math.min(R1, R2)) / 2;
        }
        return -1;
    }

    public double findMedianSortedArraysTwo(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length)
            return findMedianSortedArraysTwo(nums2, nums1);
        int len = nums1.length + nums2.length;
        int cut1 = 0, cut2 = 0, cutL = 0, cutR = nums1.length;
        while (cut1 <= nums1.length) {
            cut1 = (cutR - cutL) / 2 + cutL;
            cut2 = len / 2 - cut1;
            double L1 = cut1 == 0 ? Integer.MIN_VALUE : nums1[cut1 - 1];
            double L2 = cut2 == 0 ? Integer.MIN_VALUE : nums2[cut2 - 1];
            double R1 = cut1 == nums1.length ? Integer.MAX_VALUE : nums1[cut1];
            double R2 = cut2 == nums2.length ? Integer.MAX_VALUE : nums2[cut2];
            if (L1 > R2) {
                cutR = cut1 - 1;
            } else if (L2 > R1) {
                cutL = cut1 + 1;
            } else {
                if (len % 2 == 0) {
                    return (Math.max(L1, L2) + Math.min(R1, R2)) / 2;
                } else {
                    return Math.min(R1, R2);
                }
            }
        }
        return -1;
    }

    // https://windliang.cc/2018/07/18/leetCode-4-Median-of-Two-Sorted-Arrays/
    public double findMedianSortedArraysThree(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        if (m > n)
            return findMedianSortedArraysThree(nums2, nums1);
        int iMin = 0, iMax = m;
        while (iMin <= iMax) {
            int i = (iMin + iMax) / 2;
            int j = (m + n + 1) / 2 - i;
            if (j != 0 && i != m && nums2[j - 1] > nums1[i])
                iMin = i + 1;
            else if (i != 0 && j != n && nums1[i - 1] > nums2[j])
                iMax = i - 1;
            else {
                int maxLeft = 0;
                if (i == 0)
                    maxLeft = nums2[j - 1];
                else if (j == 0)
                    maxLeft = nums1[i - 1];
                else
                    maxLeft = Math.max(nums1[i - 1], nums2[j - 1]);
                if ((m + n) % 2 == 1)
                    return maxLeft;
                int minRight = 0;
                if (i == m)
                    minRight = nums2[j];
                else if (j == n)
                    minRight = nums1[i];
                else
                    minRight = Math.min(nums1[i], nums2[j]);
                return (maxLeft + minRight) / 2.0;
            }
        }
        return -1;
    }
}
