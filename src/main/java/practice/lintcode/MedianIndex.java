package practice.lintcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

// 1662. Median Index
public class MedianIndex {
    /**
     * @param a: the array a
     * @return: return the index of median
     */
    public int getAns(int[] a) {
        // write your code here
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < a.length; i++)
            map.put(a[i], i);
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
        int size = list.size();
        if (size % 2 == 0) {
            return list.get(size / 2 - 1).getValue();
        } else {
            return list.get(size / 2).getValue();
        }
    }
}
