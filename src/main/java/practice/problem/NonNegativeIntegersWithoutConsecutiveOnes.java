package practice.problem;

// 600. Non-negative Integers without Consecutive Ones
// https://www.geeksforgeeks.org/count-number-binary-strings-without-consecutive-1s/
public class NonNegativeIntegersWithoutConsecutiveOnes {
    public int findIntegers(int num) {
        StringBuilder sb = new StringBuilder(Integer.toBinaryString(num));
        int n = sb.length();
        int[] ones = new int[n], zeroes = new int[n];
        ones[0] = zeroes[0] = 1;
        for (int i = 1; i < n; i++) {
            ones[i] = zeroes[i - 1];
            zeroes[i] = ones[i - 1] + zeroes[i - 1];
        }
        int res = ones[n - 1] + zeroes[n - 1];
        for (int i = 1; i < n; i++) {
            if (sb.charAt(i) == '1' && sb.charAt(i - 1) == '1')
                break;
            if (sb.charAt(i) == '0' && sb.charAt(i - 1) == '0')
                res -= ones[n - i - 1];
        }
        return res;
    }
}
