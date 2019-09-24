package practice.problem;

import java.util.*;

// 818. Race Car
public class RaceCar {
    public int racecar(int target) {
        Deque<int[]> queue = new LinkedList<>();
        queue.offerLast(new int[]{0, 1});
        Set<String> visited = new HashSet<>();
        visited.add(0 + " " + 1);
        for (int level = 0; !queue.isEmpty(); level++) {
            for (int k = queue.size(); k > 0; k--) {
                int[] cur = queue.pollFirst();  // cur[0] is position; cur[1] is speed
                if (cur[0] == target)
                    return level;
                int[] next = new int[]{cur[0] + cur[1], cur[1] << 1};  // accelerate instruction
                String key = next[0] + " " + next[1];
                if (!visited.contains(key) && 0 < next[0] && next[0] < (target << 1)) {
                    queue.offerLast(next);
                    visited.add(key);
                }
                next = new int[]{cur[0], cur[1] > 0 ? -1 : 1};  // reverse instruction
                key = next[0] + " " + next[1];
                if (!visited.contains(key) && 0 < next[0] && next[0] < (target << 1)) {
                    queue.offerLast(next);
                    visited.add(key);
                }
            }
        }
        return -1;
    }

    public int racecarTwo(int target) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0, 1});
        Set<String> visited = new HashSet<>();
        visited.add(0 + " " + 1);
        for (int level = 0; !q.isEmpty(); level++) {
            for (int k = q.size(); k > 0; k--) {
                int[] cur = q.poll();
                if (cur[0] == target)
                    return level;
                int[] next = new int[]{cur[0] + cur[1], cur[1] * 2};
                String key = next[0] + " " + next[1];
                if (!visited.contains(key) && 0 < next[0] && next[0] < target * 2) {
                    q.offer(next);
                    visited.add(key);
                }
                next = new int[]{cur[0], cur[1] > 0 ? -1 : 1};
                key = next[0] + " " + next[1];
                if (!visited.contains(key) && 0 < next[0] && next[0] < target * 2) {
                    q.offer(next);
                    visited.add(key);
                }
            }
        }
        return -1;
    }
}
