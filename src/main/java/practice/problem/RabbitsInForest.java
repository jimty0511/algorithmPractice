package practice.problem;

import java.util.HashMap;
import java.util.Map;

// 781. Rabbits in Forest
public class RabbitsInForest {
    public int numRabbits(int[] answers) {
        if (answers == null || answers.length == 0)
            return 0;
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        for (int n : answers) {
            if (n == 0) {
                sum++;
                continue;
            }
            if (!map.containsKey(n)) {
                map.put(n, 0);
                sum += (n + 1);
            } else {
                map.put(n, map.get(n) + 1);
                if (map.get(n) == n)
                    map.remove(n);
            }
        }
        return sum;
    }
}
