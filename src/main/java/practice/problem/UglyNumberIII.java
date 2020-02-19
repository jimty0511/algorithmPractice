package practice.problem;

// 1201. Ugly Number III
public class UglyNumberIII {
    public int nthUglyNumber(int n, int a, int b, int c) {
        int low = 1, high = (int) (2 * 1e9), res = 0;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (count(a, b, c, mid) >= n) {
                res = mid;
                high = mid - 1;
            } else
                low = mid + 1;
        }
        return res;
    }

    private long gcd(long a, long b) {
        if (a == 0)
            return b;
        return gcd(b % a, a);
    }

    private long lcm(long a, long b) {
        return (a * b) / gcd(a, b);
    }

    private int count(long a, long b, long c, long num) {
        return (int) ((num / a) + (num / b) + (num / c)
                - (num / lcm(a, b)) - (num / lcm(b, c)) - (num / lcm(a, c)) + (num / lcm(a, lcm(b, c))));
    }
}
