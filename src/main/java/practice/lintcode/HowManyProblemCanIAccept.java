package practice.lintcode;

// 937.How Many Problem Can I Accept
public class HowManyProblemCanIAccept {
    /**
     * @param n: an integer
     * @param k: an integer
     * @return: how many problem can you accept
     */
    public long canAccept(long n, int k) {
        // Write your code here
        long l = 0;
        long r = (long) Math.sqrt(2 * n);
        while (l <= r) {
            long mid = (l + r) / 2;
            long sum = k * mid * (mid + 1) / 2;
            if (sum <= n)
                l = mid + 1;
            else
                r = mid - 1;
        }
        if (k * r * (r + 1) / 2 <= n)
            return r;
        else
            return l;
    }

    public long canAcceptTwo(long n, int k) {
        long ans = 0;
        for (int m = 1; ; m++) {
            long sum = k * m * (m - 1) / 2;
            if (sum > n)
                break;
            ans++;
        }
        return ans - 1;
    }
}
