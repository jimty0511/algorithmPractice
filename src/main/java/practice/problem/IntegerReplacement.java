package practice.problem;

// 397. Integer Replacement
public class IntegerReplacement {
    public int integerReplacement(int n) {
        if (n == Integer.MAX_VALUE)
            return 32;
        int count = 0;
        while (n > 1) {
            if (n % 2 == 0)
                n /= 2;
            else {
                if ((n + 1) % 4 == 0 && (n - 1 != 2))
                    n++;
                else
                    n--;
            }
            count++;
        }
        return count;
    }

    public int integerReplacementTwo(int n) {
        int res = 0;
        while (n != 1) {
            if ((n & 1) == 0) {
                n >>>= 1;
            } else if (n == 3 || Integer.bitCount(n + 1) > Integer.bitCount(n - 1))
                n--;
            else
                n++;
            res++;
        }
        return res;
    }
}
