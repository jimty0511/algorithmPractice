package practice.problem;

// 8. String to Integer (atoi)
public class StringToIntegerATOI {
    public int myAtoi(String str) {
        if (str.isEmpty() || str.trim().isEmpty())
            return 0;
        int idx = 0, sign = 1, total = 0;
        while (str.charAt(idx) == ' ' && idx < str.length())
            idx++;
        if (str.charAt(idx) == '+' || str.charAt(idx) == '-')
            sign = str.charAt(idx++) == '+' ? 1 : -1;
        while (idx < str.length()) {
            int digit = str.charAt(idx) - '0';
            if (digit < 0 || digit > 9)
                break;
            if (Integer.MAX_VALUE / 10 < total || Integer.MAX_VALUE / 10 == total && Integer.MAX_VALUE % 10 < digit)
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            total = total * 10 + digit;
            idx++;
        }
        return total * sign;
    }
}
