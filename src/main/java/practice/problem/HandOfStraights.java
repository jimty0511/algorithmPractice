package practice.problem;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

// 846. Hand of Straights
public class HandOfStraights {
    public boolean isNStraightHand(int[] hand, int W) {
        Map<Integer, Integer> c = new TreeMap<>();
        for (int i : hand) {
            c.put(i, c.getOrDefault(i, 0) + 1);
        }
        for (int it : c.keySet()) {
            if (c.get(it) > 0) {
                for (int i = W - 1; i >= 0; i--) {
                    if (c.getOrDefault(it + i, 0) < c.get(it))
                        return false;
                    c.put(it + i, c.get(it + i) - c.get(it));
                }
            }
        }
        return true;
    }

    public boolean isNStraightHandTwo(int[] hand, int W) {
        int len = hand.length;
        if (len % W != 0)
            return false;
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        for (int i : hand)
            treeMap.put(i, treeMap.getOrDefault(i, 0) + 1);
        while (!treeMap.isEmpty()) {
            int first = treeMap.firstKey();
            for (int j = 1; j < W; j++) {
                int next = first + j;
                if (treeMap.containsKey(next)) {
                    treeMap.put(next, treeMap.get(next) - 1);
                    if (treeMap.get(next) == 0)
                        treeMap.remove(next);
                } else {
                    return false;
                }
            }
            treeMap.put(first, treeMap.get(first) - 1);
            if (treeMap.get(first) == 0)
                treeMap.remove(first);
        }
        return true;
    }
}
