package practice.problem;

// 733. Flood Fill
public class FloodFill {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int color = image[sr][sc];
        if (color != newColor) {
            helper(image, sr, sc, color, newColor);
        }
        return image;
    }

    private void helper(int[][] image, int r, int c, int color, int newColor) {
        if (r >= 0 && r < image.length && c >= 0 && c < image[0].length && image[r][c] == color) {
            image[r][c] = newColor;
            helper(image, r - 1, c, color, newColor);
            helper(image, r + 1, c, color, newColor);
            helper(image, r, c + 1, color, newColor);
            helper(image, r, c - 1, color, newColor);
        }
    }
}
