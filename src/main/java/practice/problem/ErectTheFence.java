package practice.problem;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// 587. Erect the Fence
public class ErectTheFence {
    public static class Point {
        int x;
        int y;

        public Point() {
            x = 0;
            y = 0;
        }

        public Point(int a, int b) {
            x = a;
            y = b;
        }
    }

    public List<Point> outerTrees(Point[] points) {
        Set<Point> res = new HashSet<>();
        Point first = points[0];
        int firstIndex = 0;
        for (int i = 1; i < points.length; i++) {
            if (points[i].x < first.x) {
                first = points[i];
                firstIndex = i;
            }
        }
        res.add(first);
        Point cur = first;
        int curIndex = firstIndex;
        do {
            Point next = points[0];
            int nextIndex = 0;
            for (int i = 1; i < points.length; i++) {
                if (i == curIndex)
                    continue;
                int cross = crossProductLength(cur, points[i], next);
                if (nextIndex == curIndex || cross > 0 || (cross == 0 && distance(points[i], cur) > distance(next, cur))) {
                    next = points[i];
                    nextIndex = i;
                }
            }
            for (int i = 0; i < points.length; i++) {
                if (i == curIndex)
                    continue;
                int cross = crossProductLength(cur, points[i], next);
                if (cross == 0)
                    res.add(points[i]);
            }
            cur = next;
            curIndex = nextIndex;
        } while (curIndex != firstIndex);
        return new ArrayList<>(res);
    }

    private int crossProductLength(Point A, Point B, Point C) {
        int BAx = A.x - B.x;
        int BAy = A.y - B.y;
        int BCx = C.x - B.x;
        int BCy = C.y - B.y;
        return (BAx * BCy - BAy * BCx);
    }

    private int distance(Point p1, Point p2) {
        return (p1.x - p2.x) * (p1.x - p2.x) + (p1.y - p2.y) * (p1.y - p2.y);
    }
}
