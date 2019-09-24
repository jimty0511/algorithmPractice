package practice.problem;

import java.util.HashSet;
import java.util.Set;

// 391. Perfect Rectangle
public class PerfectRectangle {
    public boolean isRectangleCover(int[][] rectangles) {
        if (rectangles == null || rectangles.length == 0 || rectangles[0].length == 0)
            return false;
        int x1 = Integer.MAX_VALUE, x2 = Integer.MIN_VALUE;
        int y1 = Integer.MAX_VALUE, y2 = Integer.MIN_VALUE;
        Set<String> set = new HashSet<>();
        int area = 0;
        for (int[] rec : rectangles) {
            x1 = Math.min(rec[0], x1);
            y1 = Math.min(rec[1], y1);
            x2 = Math.max(rec[2], x2);
            y2 = Math.max(rec[3], y2);
            area += (rec[2] - rec[0]) * (rec[3] - rec[1]);
            String s1 = rec[0] + " " + rec[1];
            String s2 = rec[0] + " " + rec[3];
            String s3 = rec[2] + " " + rec[1];
            String s4 = rec[2] + " " + rec[3];
            if (!set.add(s1))
                set.remove(s1);
            if (!set.add(s2))
                set.remove(s2);
            if (!set.add(s3))
                set.remove(s3);
            if (!set.add(s4))
                set.remove(s4);
        }
        if (!set.contains(x1 + " " + y1) || !set.contains(x1 + " " + y2) || !set.contains(x2 + " " + y1) ||
                !set.contains(x2 + " " + y2) || set.size() != 4)
            return false;
        return area == (x2 - x1) * (y2 - y1);
    }
}
