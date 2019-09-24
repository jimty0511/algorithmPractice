package practice.problem;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

// 403. Frog Jump
public class FrogJump {
    public boolean canCross(int[] stones) {
        if (stones == null || stones.length == 0)
            return true;
        Map<Integer, Set<Integer>> map = new HashMap<>(stones.length);
        map.put(0, new HashSet<>());
        map.get(0).add(1);
        for (int i = 1; i < stones.length; i++) {
            map.put(stones[i], new HashSet<>());
        }
        for (int i = 0; i < stones.length - 1; i++) {
            int stone = stones[i];
            for (int step : map.get(stone)) {
                int reach = step + stone;
                if (reach == stones[stones.length - 1])
                    return true;
                Set<Integer> set = map.get(reach);
                if (set != null) {
                    set.add(step);
                    set.add(step + 1);
                    if (step - 1 > 0)
                        set.add(step - 1);
                }
            }
        }
        return false;
    }
}
