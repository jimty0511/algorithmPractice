package practice.domain;

import java.util.HashMap;
import java.util.TreeSet;

public class LFUCache {

    class Cache implements Comparable<Cache> {

        int key, f, r;

        public Cache(int key, int f, int r) {
            this.key = key;
            this.f = f;
            this.r = r;
        }

        @Override
        public int hashCode() {
            return key;
        }

        @Override
        public boolean equals(Object obj) {
            return key == ((Cache) obj).key;
        }

        @Override
        public int compareTo(Cache o) {
            return key == o.key ? 0 : f == o.f ? r - o.r : f - o.f;
        }
    }

    int capacity, id;
    HashMap<Integer, Integer> hashMap;
    HashMap<Integer, Cache> caches;
    TreeSet<Cache> treeSet;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        id = 0;
        hashMap = new HashMap<>();
        caches = new HashMap<>();
        treeSet = new TreeSet<>();
    }

    public int get(int key) {
        id++;
        if (hashMap.containsKey(key)) {
            update(key);
            return hashMap.get(key);
        }
        return -1;
    }

    public void put(int key, int value) {
        if (capacity == 0)
            return;
        id++;
        if (hashMap.containsKey(key)) {
            update(key);
            hashMap.put(key, value);
            return;
        }
        if (hashMap.size() == capacity) {
            Cache first = treeSet.pollFirst();
            hashMap.remove(first.key);
            caches.remove(first.key);
        }
        hashMap.put(key, value);
        Cache cache = new Cache(key, 1, id);
        caches.put(key, cache);
        treeSet.add(cache);
    }

    private void update(int key) {
        int f = caches.get(key).f;
        treeSet.remove(caches.get(key));
        Cache cache = new Cache(key, f + 1, id);
        caches.put(key, cache);
        treeSet.add(cache);
    }
}
