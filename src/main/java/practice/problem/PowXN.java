package practice.problem;

// 50. Pow(x, n)
public class PowXN {
    public double myPow(double x, int n) {
        if (n == 0)
            return 1;
        if (n == 1)
            return x;
        int t = n / 2;
        if (n < 0) {
            t = -t;
            x = 1 / x;
        }
        double res = myPow(x, t);
        if (n % 2 == 0)
            return res * res;
        return res * res * x;
    }

    public double myPowTwo(double x, int n) {
        if (n == 0)
            return 1;
        double res = 1;
        long abs = Math.abs((long) n);
        while (abs > 0) {
            if (abs % 2 != 0) {
                res *= x;
            }
            x *= x;
            abs /= 2;
        }
        if (n < 0) {
            return 1.0 / res;
        }
        return res;
    }

    public double myPowThree(double x, int n) {
        return n > 0 ? helper(x, n) : 1.0 / helper(x, n);
    }

    private double helper(double x, int n) {
        if (n == 0)
            return 1;
        double y = helper(x, n / 2);
        if (n % 2 == 0) {
            return y * y;
        } else {
            return y * y * x;
        }
    }
}
