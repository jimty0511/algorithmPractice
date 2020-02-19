package practice.problem;

// 13. Roman to Integer
// Microsoft ladder
public class RomanToInt {
    public int romanToInt(String s) {
        int res = 0;
        if (s.length() == 0) return 0;
        for (int i = 0; i < s.length() - 1; i++) {
            int cur = getVal(s.charAt(i));
            int next = getVal(s.charAt(i + 1));
            if (cur < next) {
                res -= cur;
            } else {
                res += cur;
            }
        }
        return res + getVal(s.charAt(s.length() - 1));
    }

    private int getVal(char c) {
        switch (c) {
            case 'M':
                return 1000;
            case 'D':
                return 500;
            case 'C':
                return 100;
            case 'L':
                return 50;
            case 'X':
                return 10;
            case 'V':
                return 5;
            case 'I':
                return 1;
        }
        throw new IllegalArgumentException("unknown character");
    }
}
