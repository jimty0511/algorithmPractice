package practice.problem;

// 415. Add Strings
public class AddString {
    public String addStrings(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        for (int i = num1.length() - 1, j = num2.length() - 1; i >= 0 || j >= 0 || carry == 1; i--, j--) {
            carry += i < 0 ? 0 : num1.charAt(i) - '0';
            carry += j < 0 ? 0 : num2.charAt(j) - '0';
            sb.append(carry % 10);
            carry /= 10;
        }
        return sb.reverse().toString();
    }

    public String addStringsTwo(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        int carry = 0, i = num1.length() - 1, j = num2.length() - 1;
        while (i >= 0 || j >= 0) {
            int sum = carry;
            if (i >= 0)
                sum += num1.charAt(i--) - '0';
            if (j >= 0)
                sum += num2.charAt(j--) - '0';
            sb.append(sum % 10);
            carry = sum / 10;
        }
        if (carry != 0)
            sb.append(carry);
        return sb.reverse().toString();
    }
}
