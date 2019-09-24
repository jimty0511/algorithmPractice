package practice.problem;

import java.util.*;

// 1042. Flower Planting With No Adjacent
public class FlowerPlantingWithNoAdjacent {
    public int[] gardenNoAdj(int N, int[][] paths) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int i = 1; i <= N; i++) {
            map.put(i, new HashSet<>());
        }
        for (int[] p : paths) {
            map.get(p[0]).add(p[1]);
            map.get(p[1]).add(p[0]);
        }
        int[] res = new int[N];
        for (int i = 1; i <= N; i++) {
            Set<Integer> set = new HashSet<>(Arrays.asList(1, 2, 3, 4));
            for (int next : map.get(i)) {
                if (set.contains(res[next - 1]))
                    set.remove(res[next - 1]);
            }
            res[i - 1] = set.iterator().next();
        }
        return res;
    }
}
