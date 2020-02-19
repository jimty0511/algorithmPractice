package practice.lintcode;

// 1558. Interlaced Positive And Negative Numbers
public class InterlacedPositiveAndNegativeNumbers {
    /**
     * @param a: the sequence
     * @return: the longest sequence
     */
    public int getLongest(int[] a) {
        // Write your code here
        if (a == null || a.length == 0)
            return 0;
        int pos = a[0] >= 0 ? 1 : 0;
        int neg = a[0] <= 0 ? 1 : 0;
        int ans = 0;
        for (int i = 1; i < a.length; i++) {
            int tmp = pos;
            pos = a[i] >= 0 ? neg + 1 : 0;
            neg = a[i] <= 0 ? tmp + 1 : 0;
            ans = Math.max(ans, Math.max(pos, neg));
        }
        return ans;
    }
}
