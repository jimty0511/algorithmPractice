package practice.problem;

// 661. Image Smoother
public class ImageSmother {
    public int[][] imageSmoother(int[][] M) {
        int m = M.length, n = M[0].length;
        int[][] res = new int[m][n];
        if (m == 0 || n == 0) return res;
        int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int sum = M[i][j];
                int count = 1;
                for (int[] d : dirs) {
                    int x = i + d[0], y = j + d[1];
                    if (x < 0 || x >= m || y < 0 || y >= n)
                        continue;
                    sum += M[x][y];
                    count++;
                }
                res[i][j] = sum / count;
            }
        }
        return res;
    }
}
