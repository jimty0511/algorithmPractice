package practice.lintcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// 912. Best Meeting Point
public class BestMeetingPoint {
    public int minTotalDistance(int[][] grid) {
        // Write your code here
        List<Integer> x = new ArrayList<>(), y = new ArrayList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    x.add(i);
                    y.add(j);
                }
            }
        }
        return helper(x) + helper(y);
    }

    private int helper(List<Integer> list) {
        Collections.sort(list);
        int i = 0, j = list.size() - 1;
        int res = 0;
        while (i < j) {
            res += list.get(j--) - list.get(i++);
        }
        return res;
    }
}
