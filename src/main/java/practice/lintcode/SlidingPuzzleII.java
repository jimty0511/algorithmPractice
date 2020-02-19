package practice.lintcode;

import java.util.*;

// 794. Sliding Puzzle II
public class SlidingPuzzleII {
    /**
     * @param init_state:  the initial state of chessboard
     * @param final_state: the final state of chessboard
     * @return: return an integer, denote the number of minimum moving
     */
    public int minMoveStep(int[][] init_state, int[][] final_state) {
        // # write your code here
        String start = matrixToStr(init_state);
        String end = matrixToStr(final_state);
        Queue<String> q = new LinkedList<>();
        q.offer(start);
        Set<String> visited = new HashSet<>();
        visited.add(start);
        int step = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                String cur = q.poll();
                if (cur.equals(end))
                    return step;
                for (String next : next(cur)) {
                    if (visited.contains(next))
                        continue;
                    q.offer(next);
                    visited.add(next);
                }
            }
            step++;
        }
        return -1;
    }

    private String matrixToStr(int[][] matrix) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++)
                sb.append(matrix[i][j]);
        }
        return sb.toString();
    }

    int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    private List<String> next(String cur) {
        List<String> res = new ArrayList<>();
        int zero = cur.indexOf('0');
        int x = zero / 3, y = zero % 3;
        for (int[] d : dirs) {
            int xx = x + d[0], yy = y + d[1];
            if (xx < 0 || xx >= 3 || yy < 0 || yy >= 3)
                continue;
            char[] chars = cur.toCharArray();
            chars[x * 3 + y] = chars[xx * 3 + yy];
            chars[xx * 3 + yy] = '0';
            res.add(new String(chars));
        }
        return res;
    }
}
