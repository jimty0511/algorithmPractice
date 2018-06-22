package practice.problem;

// 29. Divide Two Integers
public class DivideTwoIntegers {
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
