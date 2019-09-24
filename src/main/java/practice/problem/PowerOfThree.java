package practice.problem;

// 326. Power of Three
public class PowerOfThree {
    public boolean isPowerOfThree(int n) {
        if (n <= 0) return false;
        double r = Math.log10(n) / Math.log10(3);
        if (r % 1 == 0)
            return true;
        else
            return false;
    }

    public boolean isPowerOfThreeTwo(int n) {
        if (n > 1)
            while (n % 3 == 0)
                n /= 3;
        return n == 1;
    }
}
