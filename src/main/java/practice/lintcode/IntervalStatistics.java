package practice.lintcode;

// 1667. Interval Statistics
public class IntervalStatistics {
    /**
     * @param arr: the 01 array
     * @param k:   the limit
     * @return: the sum of the interval
     */
    public long intervalStatistics(int[] arr, int k) {
        // Write your code here.
        if (arr == null || arr.length == 0)
            return 0;
        if (k >= arr.length)
            return 0;
        int left = 0, right = 0;
        long ones = 0, res = 0;
        while (right < arr.length) {
            if (arr[right] == 1) {
                ones++;
                right++;
                continue;
            }
            if (arr[left] == 1) {
                ones--;
                left++;
                continue;
            }
            while (ones > k) {
                if (arr[left] == 1)
                    ones--;
                left++;
            }
            res += right - left + 1 - ones;
            right++;
        }
        return res;
    }
}
