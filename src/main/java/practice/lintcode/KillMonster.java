package practice.lintcode;

import java.util.*;

// 1683. Kill Monster
public class KillMonster {
    private boolean helper(int[] monster, int[] atl) {
        for (int i = 0; i < 5; i++) {
            if (atl[i] < monster[i])
                return false;
        }
        return true;
    }

    public int killMonsterTwo(int n, int[][] v) {
        int res = 0;
        int[] atlman = v[0];
        Map<Integer, int[]> map = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            map.put(i, v[i]);
        }
        while (!map.isEmpty()) {
            boolean found = false;
            Set<Integer> keySet = new HashSet<>(map.keySet());
            for (int key : keySet) {
                int[] monster = map.get(key);
                if (helper(monster, atlman)) {
                    found = true;
                    res++;
                    for (int i = 0; i < 5; i++) {
                        atlman[i] += monster[i];
                    }
                    map.remove(key);
                }
            }
            if (!found)
                break;
        }
        return res;
    }
}
