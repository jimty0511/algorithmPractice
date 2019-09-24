package practice.problem;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

// 554. Brick Wall
public class BrickWall {
    public int leastBricks(List<List<Integer>> wall) {
        if (wall == null || wall.size() == 0)
            return 0;
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        for (List<Integer> w : wall) {
            int length = 0;
            for (int i = 0; i < w.size() - 1; i++) {
                length += w.get(i);
                map.put(length, map.getOrDefault(length, 0) + 1);
                count = Math.max(count, map.get(length));
            }
        }
        return wall.size() - count;
    }
}
