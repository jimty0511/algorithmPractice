package practice.domain;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCacheLHM {

    private int capacity;
    LinkedHashMap<Integer, Integer> map;

    public LRUCacheLHM(int capacity) {
        this.capacity = capacity;
        map = new LinkedHashMap<Integer, Integer>(16, 0.75f, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry eldest) {
                return size() > capacity;
            }
        };
    }

    public int get(int key) {
        if (!map.containsKey(key))
            return -1;
        return map.get(key);
    }

    public void put(int key, int value) {
        map.put(key, value);
    }
}
