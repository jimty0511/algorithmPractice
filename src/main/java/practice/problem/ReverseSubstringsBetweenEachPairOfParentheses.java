package practice.problem;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

// 1190. Reverse Substrings Between Each Pair of Parentheses
public class ReverseSubstringsBetweenEachPairOfParentheses {
    public String reverseParentheses(String s) {
        Stack<Character> stk = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == ')') {
                List<Character> tmp = new ArrayList<>();
                while (!stk.isEmpty() && stk.peek() != '(')
                    tmp.add(stk.pop());
                if (!stk.isEmpty())
                    stk.pop();
                for (char ch : tmp)
                    stk.push(ch);
            } else
                stk.push(c);
        }
        StringBuilder sb = new StringBuilder();
        while (!stk.isEmpty())
            sb.append(stk.pop());
        return sb.reverse().toString();
    }

    public String reverseParenthesesOn(String s) {
        int len = s.length();
        Stack<Integer> open = new Stack<>();
        int[] pair = new int[len];
        for (int i = 0; i < len; i++) {
            if (s.charAt(i) == '(')
                open.push(i);
            else if (s.charAt(i) == ')') {
                int j = open.pop();
                pair[i] = j;
                pair[j] = i;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0, d = 1; i < len; i += d) {
            if (s.charAt(i) == '(' || s.charAt(i) == ')') {
                i = pair[i];
                d = -d;
            } else
                sb.append(s.charAt(i));
        }
        return sb.toString();
    }
}
