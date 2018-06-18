package practice.problem;

// 678. Valid Parenthesis String
public class ValidParenthesisString {
    public boolean checkValidString(String s) {
        int low = 0, high = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                low++;
                high++;
            } else if (s.charAt(i) == ')') {
                if (low > 0)
                    low--;
                high--;
            } else {
                if (low > 0)
                    low--;
                high++;
            }
            if (high < 0)
                return false;
        }
        return low == 0;
    }

    public boolean checkValidStringTwo(String s) {
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '*' || s.charAt(i) == '(')
                sum++;
            else
                sum--;
            if (sum < 0)
                return false;
        }
        sum = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '*' || s.charAt(i) == ')')
                sum++;
            else
                sum--;
            if (sum < 0)
                return false;
        }
        return true;
    }
}
