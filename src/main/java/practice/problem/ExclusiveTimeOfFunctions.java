package practice.problem;

import java.util.List;
import java.util.Stack;

// 636. Exclusive Time of Functions
public class ExclusiveTimeOfFunctions {
    public int[] exclusiveTime(int n, List<String> logs) {
        int[] res = new int[n];
        Stack<Integer> stack = new Stack<>();
        int prevTime = 0;
        for (String log : logs) {
            String[] pairs = log.split(":");
            int id = Integer.parseInt(pairs[0]);
            int curr = Integer.parseInt(pairs[2]);
            if (pairs[1].equals("start")) {
                if (!stack.isEmpty()) {
                    res[stack.peek()] += curr - prevTime;
                }
                stack.push(id);
                prevTime = curr;
            } else {
                res[stack.pop()] += curr - prevTime + 1;
                prevTime = curr + 1;
            }
        }
        return res;
    }
}
