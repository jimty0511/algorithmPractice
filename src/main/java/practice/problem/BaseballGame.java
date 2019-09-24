package practice.problem;

import java.util.LinkedList;
import java.util.Stack;

// 682. Baseball Game
public class BaseballGame {
    public int calPoints(String[] ops) {
        int sum = 0;
        LinkedList<Integer> list = new LinkedList<>();
        for (String s : ops) {
            if (s.equals("C")) {
                sum -= list.removeLast();
            } else if (s.equals("D")) {
                list.add(list.peekLast() * 2);
                sum += list.peekLast();
            } else if (s.equals("+")) {
                list.add(list.peekLast() + list.get(list.size() - 2));
                sum += list.peekLast();
            } else {
                list.add(Integer.parseInt(s));
                sum += list.peekLast();
            }
        }
        return sum;
    }

    public int calPointsStack(String[] ops) {
        int sum = 0;
        Stack<Integer> stack = new Stack<>();
        for (String s : ops) {
            if (s.equals("C")) {
                sum -= stack.pop();
            } else if (s.equals("D")) {
                stack.push(stack.peek() * 2);
                sum += stack.peek();
            } else if (s.equals("+")) {
                stack.push(stack.get(stack.size() - 1) + stack.get(stack.size() - 2));
                sum += stack.peek();
            } else {
                stack.push(Integer.parseInt(s));
                sum += stack.peek();
            }
        }
        return sum;
    }

    public int calPointsArray(String[] ops) {
        int[] ar = new int[ops.length];
        int i = -1, sum = 0;
        for (String st : ops) {
            char c = st.charAt(0);
            if (c == '+') {
                sum += (ar[++i] = ar[i - 1] + ar[i - 2]);
            } else if (c == 'D') {
                sum += (ar[++i] = 2 * ar[i - 1]);
            } else if (c == 'C') {
                sum -= ar[i--];
            } else {
                sum += (ar[++i] = Integer.parseInt(st));
            }
        }
        return sum;
    }
}
