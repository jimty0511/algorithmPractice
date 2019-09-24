package practice.problem;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

// 1106. Parsing A Boolean Expression
public class ParsingABooleanExpression {
    public boolean parseBoolExpr(String expression) {
        Stack<Character> stack = new Stack<>();
        for (char c : expression.toCharArray()) {
            if (c == ')') {
                Set<Character> seen = new HashSet<>();
                while (stack.peek() != '(')
                    seen.add(stack.pop());
                stack.pop();
                char op = stack.pop();
                if (op == '&')
                    stack.push(seen.contains('f') ? 'f' : 't');
                else if (op == '|')
                    stack.push(seen.contains('t') ? 't' : 'f');
                else
                    stack.push(seen.contains('t') ? 'f' : 't');
            } else if (c != ',') {
                stack.push(c);
            }
        }
        return stack.pop() == 't';
    }
}
