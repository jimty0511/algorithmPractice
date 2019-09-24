package practice.problem;

import java.util.Stack;

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
        if (sum == 0)
            return true;
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

    public boolean checkValidStringStack(String s) {
        Stack<Integer> left = new Stack<>();
        Stack<Integer> star = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(')
                left.push(i);
            else if (c == '*')
                star.push(i);
            else {
                if (left.isEmpty() && star.isEmpty())
                    return false;
                if (!left.isEmpty())
                    left.pop();
                else
                    star.pop();
            }
        }
        while (!left.isEmpty() && !star.isEmpty()) {
            if (left.pop() > star.pop())
                return false;
        }
        return left.isEmpty();
    }
}
