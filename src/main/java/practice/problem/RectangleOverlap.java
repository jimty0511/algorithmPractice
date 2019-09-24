package practice.problem;

import java.awt.*;

// 836. Rectangle Overlap
public class RectangleOverlap {
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        return Math.max(rec1[0], rec2[0]) < Math.min(rec1[2], rec2[2]) &&
                Math.max(rec1[1], rec2[1]) < Math.min(rec1[3], rec2[3]);
    }

    public boolean isRectangleOverlapTwo(int[] rec1, int[] rec2) {
        return rec1[0] < rec2[2] && rec2[0] < rec1[2] && rec1[1] < rec2[3] && rec2[1] < rec1[3];
    }

    // LintCode 626. Rectangle Overlap
    public boolean doOverlap(Point l1, Point r1, Point l2, Point r2) {
        // write your code here
        if (l2.x > r1.x || l1.x > r2.x)
            return false;
        if (r2.y > l1.y || r1.y > l2.y)
            return false;
        return true;
    }
}
