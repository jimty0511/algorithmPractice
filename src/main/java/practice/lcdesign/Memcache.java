package practice.lcdesign;

import java.util.HashMap;
import java.util.Map;

// 538. Memcache
// Chapter 2
public class Memcache {

    class Value {
        int val;
        int expire;

        public Value(int val, int expire) {
            this.val = val;
            this.expire = expire;
        }
    }

    Map<Integer, Value> map;

    public Memcache() {
        // do intialization if necessary
        map = new HashMap<>();
    }

    /*
     * @param curtTime: An integer
     * @param key: An integer
     * @return: An integer
     */
    public int get(int curtTime, int key) {
        // write your code here
        if (!map.containsKey(key))
            return Integer.MAX_VALUE;
        Value value = map.get(key);
        if (value.expire == -1 || value.expire >= curtTime)
            return value.val;
        else
            return Integer.MAX_VALUE;
    }

    /*
     * @param curtTime: An integer
     * @param key: An integer
     * @param value: An integer
     * @param ttl: An integer
     * @return: nothing
     */
    public void set(int curtTime, int key, int value, int ttl) {
        // write your code here
        int expire;
        if (ttl == 0)
            expire = -1;
        else
            expire = curtTime + ttl - 1;
        map.put(key, new Value(value, expire));
    }

    /*
     * @param curtTime: An integer
     * @param key: An integer
     * @return: nothing
     */
    public void delete(int curtTime, int key) {
        // write your code here
        if (!map.containsKey(key))
            return;
        map.remove(key);
    }

    /*
     * @param curtTime: An integer
     * @param key: An integer
     * @param delta: An integer
     * @return: An integer
     */
    public int incr(int curtTime, int key, int delta) {
        // write your code here
        if (get(curtTime, key) == Integer.MAX_VALUE)
            return Integer.MAX_VALUE;
        map.get(key).val += delta;
        return map.get(key).val;
    }

    /*
     * @param curtTime: An integer
     * @param key: An integer
     * @param delta: An integer
     * @return: An integer
     */
    public int decr(int curtTime, int key, int delta) {
        // write your code here
        if (get(curtTime, key) == Integer.MAX_VALUE)
            return Integer.MAX_VALUE;
        map.get(key).val -= delta;
        return map.get(key).val;
    }
}
