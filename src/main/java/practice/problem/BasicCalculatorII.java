package practice.problem;

import java.util.Stack;

// 227. Basic Calculator II
public class BasicCalculatorII {
    public int calculate(String s) {
        if (s == null || s.length() == 0)
            return 0;
        int len = s.length();
        Stack<Integer> stack = new Stack<>();
        int num = 0;
        char sign = '+';
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c))
                num = num * 10 + c - '0';
            if (!Character.isDigit(c) && c != ' ' || i == len - 1) {
                if (sign == '-') {
                    stack.push(-num);
                } else if (sign == '+') {
                    stack.push(num);
                } else if (sign == '*') {
                    stack.push(stack.pop() * num);
                } else if (sign == '/') {
                    stack.push(stack.pop() / num);
                }
                sign = c;
                num = 0;
            }
        }
        int res = 0;
        for (int i : stack)
            res += i;
        return res;
    }

    public int calculateTwo(String s) {
        if (s == null || s.length() == 0)
            return 0;
        s = s.trim().replaceAll("\\s+", "");
        int len = s.length();
        int res = 0, preVal = 0, i = 0;
        char sign = '+';
        while (i < len) {
            int curVal = 0;
            while (i < len && Character.isDigit(s.charAt(i))) {
                curVal = curVal * 10 + s.charAt(i) - '0';
                i++;
            }
            if (sign == '+') {
                res += preVal;
                preVal = curVal;
            } else if (sign == '-') {
                res += preVal;
                preVal = -curVal;
            } else if (sign == '*') {
                preVal = preVal * curVal;
            } else if (sign == '/') {
                preVal = preVal / curVal;
            }
            if (i < len) {
                sign = s.charAt(i);
                i++;
            }
        }
        res += preVal;
        return res;
    }
}
