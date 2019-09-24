package practice.problem;

import java.util.stream.Stream;

// 592. Fraction Addition and Subtraction
public class FractionAdditionAndSubtraction {
    public String fractionAddition(String expression) {
        String[] fracs = expression.split("(?=[-+])");
        String res = "0/1";
        for (String f : fracs)
            res = add(res, f);
        return res;
    }

    private String add(String s1, String s2) {
        int[] f1 = Stream.of(s1.split("/")).mapToInt(Integer::parseInt).toArray(),
                f2 = Stream.of(s2.split("/")).mapToInt(Integer::parseInt).toArray();
        int numer = f1[0] * f2[1] + f2[0] * f1[1], denom = f1[1] * f2[1];
        String sign = "";
        if (numer < 0) {
            sign = "-";
            numer *= -1;
        }
        int gcd = gcd(numer, denom);
        return sign + numer / gcd + "/" + denom / gcd;
    }

    private int gcd(int x, int y) {
        return x == 0 || y == 0 ? x + y : gcd(y, x % y);
    }
}
