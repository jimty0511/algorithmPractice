package practice.domain;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;

public class LFUCacheLHS {
    private int capacity;
    private int min = -1;
    Map<Integer, Integer> vals;
    Map<Integer, Integer> frequencies;
    Map<Integer, LinkedHashSet<Integer>> lists;

    public LFUCacheLHS(int capacity) {
        this.capacity = capacity;
        vals = new HashMap<>();
        frequencies = new HashMap<>();
        lists = new HashMap<>();
        lists.put(1, new LinkedHashSet<>());
    }

    public int get(int key) {
        if (!vals.containsKey(key))
            return -1;
        int frequency = frequencies.get(key);
        frequencies.put(key, frequency + 1);
        lists.get(frequency).remove(key);
        if (frequency == min && lists.get(frequency).size() == 0) {
            min++;
        }
        if (!lists.containsKey(frequency + 1)) {
            lists.put(frequency + 1, new LinkedHashSet<>());
        }
        lists.get(frequency + 1).add(key);
        return vals.get(key);
    }

    public void put(int key, int value) {
        if (capacity <= 0)
            return;
        if (vals.containsKey(key)) {
            vals.put(key, value);
            get(key);
            return;
        }
        if (vals.size() >= capacity) {
            int evit = lists.get(min).iterator().next();
            lists.get(min).remove(evit);
            vals.remove(evit);
        }
        vals.put(key, value);
        frequencies.put(key, 1);
        min = 1;
        lists.get(1).add(key);
    }
}
