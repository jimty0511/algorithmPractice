package practice.problem;

import java.util.LinkedList;
import java.util.Stack;

// 735. Asteroid Collision
public class AsteroidCollision {
    public int[] asteroidCollision(int[] asteroids) {
        LinkedList<Integer> s = new LinkedList<>();
        for (int a : asteroids) {
            if (a > 0) {
                s.add(a);
            } else {
                while (!s.isEmpty() && s.getLast() > 0 && s.getLast() < -a) {
                    s.pollLast();
                }
                if (!s.isEmpty() && s.getLast() == -a) {
                    s.pollLast();
                } else if (s.isEmpty() || s.getLast() < 0) {
                    s.add(a);
                }
            }
        }
        return s.stream().mapToInt(i -> i).toArray();
    }

    public int[] asteroidCollisionStack(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        for (int a : asteroids) {
            if (stack.isEmpty() || a > 0) {
                stack.push(a);
                continue;
            }
            while (true) {
                int prev = stack.peek();
                if (prev < 0) {
                    stack.push(a);
                    break;
                }
                if (prev == -a) {
                    stack.pop();
                    break;
                }
                if (prev > -a) {
                    break;
                }
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(a);
                    break;
                }
            }
        }
        int[] res = new int[stack.size()];
        for (int i = stack.size() - 1; i >= 0; i--)
            res[i] = stack.pop();
        return res;
    }
}
