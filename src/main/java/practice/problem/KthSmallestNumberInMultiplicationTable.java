package practice.problem;

// 668. Kth Smallest Number in Multiplication Table
public class KthSmallestNumberInMultiplicationTable {
    public int findKthNumber(int m, int n, int k) {
        int low = 1, high = m * n;
        while (low < high) {
            int mid = low + (high - low) / 2;
            int c = count(m, n, mid);
            if (c < k)
                low = mid + 1;
            else
                high = mid;
        }
        return low;
    }

    private int count(int m, int n, int midVal) {
        int count = 0;
        for (int i = 1; i <= m; i++) {
            int temp = Math.min(midVal / i, n);
            count += temp;
        }
        return count;
    }
}
