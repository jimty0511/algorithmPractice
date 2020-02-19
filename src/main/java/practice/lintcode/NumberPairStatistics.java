package practice.lintcode;

import java.awt.*;

// 844. Number Pair Statistics
public class NumberPairStatistics {
    /**
     * @param p: the point List
     * @return: the numbers of pairs which meet the requirements
     */
    public int pairNumbers(Point[] p) {
        // Write your code here
        int oe = 0, ee = 0, eo = 0, oo = 0;
        int cnt = 0;
        for (Point i : p) {
            int first = i.x, second = i.y;
            if (first % 2 == 0 && second % 2 == 0) {
                cnt += ee;
                ee++;
            } else if (first % 2 == 0 && second % 2 == 1) {
                cnt += eo;
                eo++;
            } else if (first % 2 == 1 && second % 2 == 0) {
                cnt += oe;
                oe++;
            } else if (first % 2 == 1 && second % 2 == 1) {
                cnt += oo;
                oo++;
            }
        }
        return cnt;
    }
}
