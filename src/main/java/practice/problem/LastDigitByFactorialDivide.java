package practice.problem;

public class LastDigitByFactorialDivide {
    public int computeLastDigit(long A, long B) {
        if (A == B)
            return 1;
        long left = A + 1, right = B;
        int prod = 1;
        for (long i = left; i <= right; i++) {
            int lastDigit = (int) i % 10;
            prod = (prod * lastDigit) % 10;
            if (prod == 0)
                return 0;
        }
        return prod;
    }
}
