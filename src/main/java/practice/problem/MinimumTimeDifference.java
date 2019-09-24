package practice.problem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// 539. Minimum Time Difference
public class MinimumTimeDifference {
    public int findMinDifference(List<String> timePoints) {
        int min = Integer.MAX_VALUE;
        List<Integer> time = new ArrayList<>();
        for (String t : timePoints) {
            int h = Integer.valueOf(t.substring(0, 2));
            time.add(h * 60 + Integer.valueOf(t.substring(3, 5)));
        }
        Collections.sort(time, (a, b) -> a - b);
        for (int i = 1; i < time.size(); i++) {
            min = Math.min(min, time.get(i) - time.get(i - 1));
        }
        int corner = time.get(0) + (1440 - time.get(time.size() - 1));
        return Math.min(min, corner);
    }
}
