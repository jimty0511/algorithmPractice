package practice.problem;

// 8. String to Integer (atoi)
public class StringToInteger {
    public int myAtoi(String str) {
        int index = 0, sign = 1, total = 0;
        if (str.length() == 0)
            return 0;

        while (index < str.length() && str.charAt(index) == ' ') {
            index++;
            if (index == str.length())
                return total * sign;
        }

        if (str.charAt(index) == '+' || str.charAt(index) == '-') {
            sign = str.charAt(index) == '+' ? 1 : -1;
            index++;
        }

        while (index < str.length()) {
            int digit = str.charAt(index) - '0';
            if (digit < 0 || digit > 9)
                break;
            if (total + digit > Integer.MAX_VALUE / 10 + Integer.MAX_VALUE % 10) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            total = 10 * total + digit;
            index++;
        }
        return total * sign;
    }
}
