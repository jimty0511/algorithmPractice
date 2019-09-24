package practice.problem;

import java.util.Arrays;

// 757. Set Intersection Size At Least Two
public class SetIntersectionSizeAtLeastTwo {
    public int intersectionSizeTwo(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[1] - b[1]);
        int res = 0, max1 = -1, max2 = -1;
//        for (int[] i : intervals) {
//            int start = i[0], end = i[1];
//            if (start > max1) {
//                res += 2;
//                max2 = end - 1;
//                max1 = end;
//            } else if (start > max2) {
//                res += 1;
//                max2 = max1 == end ? max1 - 1 : max1;
//                max1 = end;
//            }
//        }
        for (int[] i : intervals) {
            int start = i[0], end = i[1];
            if (start <= max2) { // two points overlapped
                continue;
            } else if (start <= max1) { // one point overlapped
                res += 1;
                max2 = max1;
                max1 = end;
            } else { // no point overlapped
                res += 2;
                max2 = end - 1;
                max1 = end;
            }
        }
        return res;
    }
}
