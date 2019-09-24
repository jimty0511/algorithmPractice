package practice.problem;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

// 773. Sliding Puzzle
public class SlidingPuzzle {
    private int[] d = {1, -1, 3, -3};

    public int slidingPuzzle(int[][] board) {
        String target = "123450";
        String start = "";
        for (int[] b : board) {
            for (int n : b) {
                start += n;
            }
        }
        Set<String> visited = new HashSet<>();
        visited.add(start);
        Queue<String> q = new LinkedList<>();
        q.offer(start);
        int ans = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                String cur = q.poll();
                if (cur.equals(target))
                    return ans;
                int zero = cur.indexOf('0');
                for (int k = 0; k < 4; k++) {
                    int j = zero + d[k];
                    if (j < 0 || j > 5 || zero == 2 && j == 3 || zero == 3 && j == 2)
                        continue;
                    char[] chars = cur.toCharArray();
                    chars[zero] = chars[j];
                    chars[j] = '0';
                    String s = String.valueOf(chars);
                    if (visited.add(s))
                        q.offer(s);
                }
            }
            ans++;
        }
        return -1;
    }
}
