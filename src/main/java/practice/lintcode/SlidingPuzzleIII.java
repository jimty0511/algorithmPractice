package practice.lintcode;

import java.util.*;

// 950. Sliding Puzzle III
public class SlidingPuzzleIII {
    /**
     * @param matrix: The 3*3 matrix
     * @return: The answer
     */
    public String jigsawPuzzle(int[][] matrix) {
        // Write your code here
        String start = matrixToStr(matrix);
        String end = "123456780";
        Queue<String> q = new LinkedList<>();
        q.offer(start);
        Set<String> visited = new HashSet<>();
        visited.add(start);
        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                String cur = q.poll();
                if (cur.equals(end))
                    return "YES";
                for (String next : next(cur)) {
                    if (visited.contains(next))
                        continue;
                    q.offer(next);
                    visited.add(next);
                }
            }
        }
        return "NO";
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
