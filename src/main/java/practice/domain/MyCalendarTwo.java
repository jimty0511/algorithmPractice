package practice.domain;

import java.util.Map;
import java.util.TreeMap;

// 731. My Calendar II
public class MyCalendarTwo {

    TreeMap<Integer, Integer> treeMap;

    public MyCalendarTwo() {
        treeMap = new TreeMap<>();
    }

    public boolean book(int start, int end) {
        treeMap.put(start, treeMap.getOrDefault(start, 0) + 1);
        treeMap.put(end, treeMap.getOrDefault(end, 0) - 1);
        int count = 0;
        for (Map.Entry<Integer, Integer> entry : treeMap.entrySet()) {
            count += entry.getValue();
            if (count > 2) {
                treeMap.put(start, treeMap.get(start) - 1);
                if (treeMap.get(start) == 0)
                    treeMap.remove(start);
                treeMap.put(end, treeMap.get(end) + 1);
                if (treeMap.get(end) == 0)
                    treeMap.remove(end);
                return false;
            }
        }
        return true;
    }

    public boolean bookTwo(int start, int end) {
        treeMap.put(start, treeMap.getOrDefault(start, 0) + 1);
        treeMap.put(end, treeMap.getOrDefault(end, 0) - 1);
        int count = 0, k = 0;
        for (int v : treeMap.values()) {
            k = Math.max(k, count += v);
            if (k > 2) {
                treeMap.put(start, treeMap.get(start) - 1);
                treeMap.put(end, treeMap.get(end) + 1);
                return false;
            }
        }
        return true;
    }
}
