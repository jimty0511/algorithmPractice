package practice.problem;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

// 841. Keys and Rooms
public class KeysAndRooms {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        Set<Integer> seen = new HashSet<>();
        seen.add(0);
        while (!stack.isEmpty()) {
            int cur = stack.pop();
            for (int next : rooms.get(cur)) {
                if (!seen.contains(next)) {
                    seen.add(next);
                    stack.push(next);
                    if (rooms.size() == seen.size())
                        return true;
                }
            }
        }
        return seen.size() == rooms.size();
    }
}
