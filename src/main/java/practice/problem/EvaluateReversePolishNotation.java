package practice.problem;

import java.util.Stack;

// 150. Evaluate Reverse Polish Notation
public class EvaluateReversePolishNotation {
    public int evalRPN(String[] tokens) {
        int a, b;
        Stack<Integer> stack = new Stack<>();
        for (String s : tokens) {
            if (s.equals("+")) {
                stack.add(stack.pop() + stack.pop());
            } else if (s.equals("/")) {
                b = stack.pop();
                a = stack.pop();
                stack.add(a / b);
            } else if (s.equals("*")) {
                stack.add(stack.pop() * stack.pop());
            } else if (s.equals("-")) {
                b = stack.pop();
                a = stack.pop();
                stack.add(a - b);
            } else {
                stack.add(Integer.valueOf(s));
            }
        }
        return stack.pop();
    }
}
