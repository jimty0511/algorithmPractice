package practice.googleContest;

import java.math.BigInteger;

public class ForegoneSolution {
    public String solution(String n, int idx) {
        char[] a = new char[n.length()], b = new char[n.length()];
        for (int i = 0; i < n.length(); i++) {
            if (n.charAt(i) == '4') {
                a[i] = '2';
                b[i] = '2';
            } else {
                a[i] = n.charAt(i);
                b[i] = '0';
            }
        }
        return "Case #" + idx + ": " + new BigInteger(new String(a)) + " " + new BigInteger(new String(b));
    }
}
