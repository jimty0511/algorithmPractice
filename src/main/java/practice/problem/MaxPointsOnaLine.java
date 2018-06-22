package practice.problem;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

// 149. Max Points on a Line
public class MaxPointsOnaLine {
    public int maxPoints(Point[] points) {
        if (points.length <= 0) return 0;
        if (points.length <= 2) return points.length;
        int result = 0;
        for (int i = 0; i < points.length - 1; i++) {
            Map<Double, Integer> pointsOnLine = new HashMap<>();
            int samePoint = 0, localMax = 0;
            for (int j = i + 1; j < points.length; j++) {
                int x = points[j].x - points[i].x;
                int y = points[j].y - points[i].y;
                if (x == 0 && y == 0) {
                    samePoint++;
                    continue;
                }
                double ratio = findRatio(x, y);
                if (!pointsOnLine.containsKey(ratio)) {
                    pointsOnLine.put(ratio, 1);
                } else {
                    pointsOnLine.put(ratio, pointsOnLine.get(ratio) + 1);
                }
                localMax = Math.max(localMax, pointsOnLine.get(ratio));
            }
            result = Math.max(result, localMax + samePoint);
        }
        return result + 1;
    }

    private Double findRatio(int x, int y) {
        if (y == 0)
            return Double.MAX_VALUE;
        else
            return (double) x / (double) y + 0.0;
    }
}
