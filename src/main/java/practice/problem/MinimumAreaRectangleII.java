package practice.problem;

import java.util.HashSet;
import java.util.Set;

// 963. Minimum Area Rectangle II
public class MinimumAreaRectangleII {
    public double minAreaFreeRect(int[][] points) {
        Set<String> set = new HashSet<>();
        for (int[] p : points) {
            set.add(p[0] + "," + p[1]);
        }
        double minArea = Double.MAX_VALUE;
        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                for (int k = j + 1; k < points.length; k++) {
                    int[] p1 = points[i], p2 = points[j], p3 = points[k];
                    if (distance(p1, p3) + distance(p3, p2) != distance(p1, p2))
                        continue;
                    // find the missing vertex
                    // important property
                    // For a rectangle, formed with vertices (x1,y1), (x2,y2),
                    // (x3,y3), (x4,y4), assuming these are adjacent to each other,
                    //  x1 + x3 = x2 + x4 and y1 + y3 = y2 + y4
                    int x = p1[0] + p2[0] - p3[0];
                    int y = p1[1] + p2[1] - p3[1];
                    if (!set.contains(x + "," + y))
                        continue;
                    double area = Math.sqrt(distance(points[i], points[k]) * (distance(points[k], points[j])));
                    minArea = Math.min(minArea, area);
                }
            }
        }
        return minArea == Double.MAX_VALUE ? 0 : minArea;
    }

    private double distance(int[] p1, int[] p2) {
        return Math.pow(p1[0] - p2[0], 2) + Math.pow(p1[1] - p2[1], 2);
    }
}
