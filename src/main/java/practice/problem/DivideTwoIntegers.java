package practice.problem;

// 29. Divide Two Integers
// Microsoft ladder
public class DivideTwoIntegers {

    public int divideTwo(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1)
            return Integer.MAX_VALUE;
        int a = Math.abs(dividend);
        int b = Math.abs(divisor);
        boolean isNegative = (dividend < 0 && divisor > 0) ||
                (dividend > 0 && divisor < 0);
        int res = 0;
        while (a - b >= 0) {
            int x = 0;
            while (a - (b << 1 << x) >= 0)
                x++;
            res += 1 << x;
            a -= b << x;
        }
        return !isNegative ? res : -res;
    }

    public int divide(int dividend, int divisor) {
        long result = divideLong(dividend, divisor);
        return result > Integer.MAX_VALUE ? Integer.MAX_VALUE : (int) result;
    }

    private long divideLong(long dividend, long divisor) {
        boolean negative = dividend < 0 != divisor < 0;
        if (dividend < 0)
            dividend = -dividend;
        if (divisor < 0)
            divisor = -divisor;
        if (dividend < divisor)
            return 0;

        long sum = divisor;
        long divide = 1;
        while ((sum + sum) <= dividend) {
            sum += sum;
            divide += divide;
        }

        return negative ? -(divide + divideLong((dividend - sum), divisor)) : (divide + divideLong((dividend - sum), divisor));
    }
}
