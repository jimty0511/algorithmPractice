package practice.lintcode;

import java.util.Stack;

// 887. Ternary Expression Parser
public class TernaryExpressionParser {
    public String parseTernary(String expression) {
        // write your code here
        Stack<Character> stk = new Stack<>();
        int len = expression.length();
        for (int i = len - 1; i >= 0; i--) {
            if (expression.charAt(i) == '?') {
                i--;
                char a = stk.pop(), b = stk.pop();
                if (expression.charAt(i) == 'T') {
                    stk.push(a);
                } else {
                    stk.push(b);
                }
            } else if (expression.charAt(i) != ':')
                stk.push(expression.charAt(i));
        }
        return String.valueOf(stk.pop());
    }
}
