package practice.lintcode;

import java.util.LinkedList;
import java.util.Queue;

// 600. Smallest Rectangle Enclosing Black Pixels
public class SmallestRectangleEnclosingBlackPixels {
    /**
     * @param image: a binary matrix with '0' and '1'
     * @param x:     the location of one of the black pixels
     * @param y:     the location of one of the black pixels
     * @return: an integer
     */
    public int minArea(char[][] image, int x, int y) {
        // write your code here
        if (image == null || image.length == 0 || image[0].length == 0)
            return 0;
        int[][] dirs = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        int minX = Integer.MAX_VALUE, minY = Integer.MAX_VALUE, maxX = Integer.MIN_VALUE, maxY = Integer.MIN_VALUE;
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x, y});
        image[x][y] = 0;
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            minX = Math.min(minX, cur[0]);
            minY = Math.min(minY, cur[1]);
            maxX = Math.max(maxX, cur[0]);
            maxY = Math.max(maxY, cur[1]);
            for (int[] d : dirs) {
                int r = cur[0] + d[0], c = cur[1] + d[1];
                if (r < 0 || r >= image.length || c < 0 || c >= image[0].length || image[r][c] == '0')
                    continue;
                q.offer(new int[]{r, c});
                image[r][c] = '0';
            }
        }
        int width = maxX - minX + 1;
        int height = maxY - minY + 1;
        return width * height;
    }
}
