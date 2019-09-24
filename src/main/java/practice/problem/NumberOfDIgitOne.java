package practice.problem;

// 233. Number of Digit One
public class NumberOfDIgitOne {
    public int countDigitOne(int n) {
        if (n <= 0) return 0;
        int q = n, x = 1, ans = 0;
        do {
            int digit = q % 10;
            q /= 10;
            ans += q * x;
            if (digit == 1)
                ans += n % x + 1;
            if (digit > 1)
                ans += x;
            x *= 10;
        } while (q > 0);
        return ans;
    }

    public int countDigitOneTwo(int n) {
        int ones = 0;
        for (long m = 1; m <= n; m *= 10)
            ones += (n / m + 8) / 10 * m + (n / m % 10 == 1 ? n % m + 1 : 0);
        return ones;
    }
}
