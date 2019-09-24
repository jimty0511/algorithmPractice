package practice.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

// 352. Data Stream as Disjoint Intervals
public class DataStreamAsDisjointIntervals {
    TreeMap<Integer, Interval> treeMap;
    TreeMap<Integer, int[]> treeMapTwo;

    public DataStreamAsDisjointIntervals() {
        treeMap = new TreeMap<>();
        treeMapTwo = new TreeMap<>();
    }

    public void addNum(int val) {
        if (treeMap.containsKey(val))
            return;
        Integer low = treeMap.lowerKey(val);
        Integer high = treeMap.higherKey(val);
        if (low != null && high != null && treeMap.get(low).end + 1 == val && high == val + 1) {
            treeMap.get(low).end = treeMap.get(high).end;
            treeMap.remove(high);
        } else if (low != null && treeMap.get(low).end + 1 >= val) {
            treeMap.get(low).end = Math.max(treeMap.get(low).end, val);
        } else if (high != null && high == val + 1) {
            treeMap.put(val, new Interval(val, treeMap.get(high).end));
            treeMap.remove(high);
        } else
            treeMap.put(val, new Interval(val, val));
    }

    public void addNumTwo(int val) {
        if (treeMapTwo.containsKey(val))
            return;
        Integer low = treeMapTwo.lowerKey(val);
        Integer high = treeMapTwo.higherKey(val);
        if (low != null && high != null && treeMapTwo.get(low)[1] + 1 == val && high == val + 1) {
            treeMapTwo.get(low)[1] = treeMapTwo.get(high)[1];
            treeMapTwo.remove(high);
        } else if (low != null && treeMapTwo.get(low)[1] + 1 >= val) {
            treeMapTwo.get(low)[1] = Math.max(treeMapTwo.get(low)[1], val);
        } else if (high != null && high == val + 1) {
            treeMapTwo.put(val, new int[]{val, treeMapTwo.get(high)[1]});
            treeMapTwo.remove(high);
        } else {
            treeMapTwo.put(val, new int[]{val, val});
        }
    }

    public List<Interval> getIntervals() {
        return new ArrayList<>(treeMap.values());
    }

    public int[][] getIntervalsTwo() {
        int[][] res = new int[treeMapTwo.size()][2];
        int i = 0;
        for (int[] val : treeMapTwo.values()) {
            res[i++] = val;
        }
        return res;
    }

}
