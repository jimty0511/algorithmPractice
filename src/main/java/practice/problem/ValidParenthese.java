package practice.problem;

import java.util.Stack;

// 20. Valid Parentheses
public class ValidParenthese {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(')');
            } else if (c == '[') {
                stack.push(']');
            } else if (c == '{') {
                stack.push('}');
            } else if (stack.isEmpty() || stack.pop() != c) {
                return false;
            }
        }
        return stack.isEmpty();
    }

    public String[] isValidPimco(String[] values) {
        if (values == null || values.length == 0)
            return new String[]{"NO"};
        Stack<Character> stack;
        String[] res = new String[values.length];
        for (int i = 0; i < values.length; i++) {
            String s = values[i];
            stack = new Stack<>();
            boolean valid = true;
            for (char c : s.toCharArray()) {
                if (c == '(') {
                    stack.push(')');
                } else if (c == '[') {
                    stack.push(']');
                } else if (c == '{') {
                    stack.push('}');
                } else if (stack.isEmpty() || stack.pop() != c) {
                    valid = false;
                    break;
                }
            }
            if (!stack.isEmpty())
                valid = false;
            if (valid)
                res[i] = "YES";
            else
                res[i] = "NO";
        }
        return res;
    }
}
