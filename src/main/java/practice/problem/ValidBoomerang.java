package practice.problem;

// 1037. Valid Boomerang
public class ValidBoomerang {
    public boolean isBoomerang(int[][] points) {
        // (y1-y0)/(x1-x0) != (y2-y0)/(x2-x0)
        return (points[1][1] - points[0][1]) * (points[2][0] - points[0][0]) != (points[2][1] - points[0][1]) * (points[1][0] - points[0][0]);
    }
}
