package practice.domain;

import java.util.Map;
import java.util.TreeMap;

// 732. My Calendar III
public class MyCalendarThree {

    Map<Integer, Integer> map;

    public MyCalendarThree() {
        map = new TreeMap<>();
    }

    public int book(int start, int end) {
        map.put(start, map.getOrDefault(start, 0) + 1);
        map.put(end, map.getOrDefault(end, 0) - 1);
        int cnt = 0, k = 0;
        for (int v : map.values()) {
            k = Math.max(k, cnt += v);
        }
        return k;
    }
}
