package practice.problem;

import java.util.Stack;

// 921. Minimum Add to Make Parentheses Valid
public class MinimumAddToMakeParenthesesValid {
    public int minAddToMakeValid(String S) {
        Stack<Character> s = new Stack<>();
        for (char c : S.toCharArray()) {
            if (c == ')' && !s.isEmpty() && s.peek() == '(')
                s.pop();
            else
                s.push(c);
        }
        return s.size();
    }

    public int minAddToMakeValidTwo(String S) {
        int left = 0, right = 0;
        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == '(') {
                right++;
            } else if (right > 0) {
                right--;
            } else
                left++;
        }
        return left + right;
    }
}
