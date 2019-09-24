package practice.domain;

import java.util.TreeMap;

// 715. Range Module
public class RangeModule {

    TreeMap<Integer, Integer> treeMap;

    public RangeModule() {
        treeMap = new TreeMap<>();
    }

    public void addRange(int left, int right) {
        Integer start = treeMap.floorKey(left);
        Integer end = treeMap.floorKey(right);
        if (start != null && treeMap.get(start) >= left)
            left = start;
        if (end != null && treeMap.get(end) > right)
            right = treeMap.get(end);
        treeMap.put(left, right);
        treeMap.subMap(left, false, right, true).clear();
    }

    public boolean queryRange(int left, int right) {
        Integer start = treeMap.floorKey(left);
        if (start == null)
            return false;
        return treeMap.get(start) >= right;
    }

    public void removeRange(int left, int right) {
        Integer start = treeMap.floorKey(left);
        Integer end = treeMap.floorKey(right);
        if (end != null && treeMap.get(end) > right)
            treeMap.put(right, treeMap.get(end));
        if (start != null && treeMap.get(start) > left)
            treeMap.put(start, left);
        treeMap.subMap(left, true, right, false).clear();
    }
}
