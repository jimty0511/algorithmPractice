package practice.problem;

// https://leetcode.com/discuss/interview-question/125016/Microsoft-or-Farthest-Co-prime
public class FarthestCoprime {
    public int[] farthestCoprimes(int end) {
        int[] res = new int[end - 1];
        int k = 0;
        for (int i = 2; i <= end; i++) {
            res[k++] = getFarthestCoprime(i, end);
        }
        return res;
    }

    private int getFarthestCoprime(int pivot, int end) {
        int mid = end / 2;
        int right = 0, left = 0;
        if (pivot > mid) {
            for (int i = 2; i < end; i++) {
                if (isCoprime(pivot, i)) {
                    left = i;
                    break;
                }
            }
        } else {
            for (int i = end; i >= 2; i--) {
                if (isCoprime(pivot, i)) {
                    right = i;
                    break;
                }
            }
        }
        if (left > right)
            return left;
        else
            return right;
    }

    private int gcd(int a, int b) {
        while (a != 0 && b != 0) {
            if (a > b)
                a %= b;
            else
                b %= a;
        }
        return Math.max(a, b);
    }

    private boolean isCoprime(int a, int b) {
        return gcd(a, b) == 1;
    }
}
