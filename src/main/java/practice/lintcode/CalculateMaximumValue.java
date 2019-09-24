package practice.lintcode;

// 719. Calculate Maximum Value
public class CalculateMaximumValue {
    public int calcMaxValue(String str) {
        // write your code here
        if (str.length() == 0)
            return 0;
        int res = str.charAt(0) - '0';
        for (int i = 1; i < str.length(); i++) {
            int val = str.charAt(i) - '0';
            if (val == 0 || val == 1 || res <= 1)
                res += val;
            else
                res *= val;
        }
        return res;
    }
}
