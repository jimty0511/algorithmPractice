package practice.problem;

// 728. Three Distinct Factors
public class ThreeDistinctFactors {
    public boolean isThreeDisctFactors(long n) {
        // write your code here
        long x = (long) Math.sqrt(n);
        if (x * x != n)
            return false;
        return isPrime(x);
    }

    private boolean isPrime(long n) {
        for (int i = 2; i < Math.sqrt(n); i++) {
            if (n % i == 0)
                return false;
        }
        return true;
    }
}
