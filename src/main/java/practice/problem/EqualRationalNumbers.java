package practice.problem;

// 972. Equal Rational Numbers
public class EqualRationalNumbers {
    public boolean isRationalEqual(String S, String T) {
        return helper(S) == helper(T);
    }

    private double helper(String s) {
        int i = s.indexOf('(');
        if (i > 0) {
            String base = s.substring(0, i);
            String rep = s.substring(i + 1, s.length() - 1);
            for (int j = 0; j < 20; j++)
                base += rep;
            return Double.valueOf(base);
        }
        return Double.valueOf(s);
    }
}
