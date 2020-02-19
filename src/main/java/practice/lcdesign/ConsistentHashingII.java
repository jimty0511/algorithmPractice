package practice.lcdesign;

import java.util.*;

// 520. Consistent Hashing II
// Chapter 3
public class ConsistentHashingII {

    private int n, k;
    private NavigableMap<Integer, Integer> map;
    private Random random;

    public static ConsistentHashingII create(int n, int k) {
        // Write your code here
        ConsistentHashingII consistentHashingII = new ConsistentHashingII();
        consistentHashingII.n = n;
        consistentHashingII.k = k;
        consistentHashingII.map = new TreeMap<>();
        consistentHashingII.random = new Random();
        return consistentHashingII;
    }

    /*
     * @param machine_id: An integer
     * @return: a list of shard ids
     */
    public List<Integer> addMachine(int machine_id) {
        // write your code here
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < k; ) {
            int shard = random.nextInt(n);
            if (!map.containsKey(shard)) {
                res.add(shard);
                map.put(shard, machine_id);
                i++;
            }
        }
        return res;
    }

    /*
     * @param hashcode: An integer
     * @return: A machine id
     */
    public int getMachineIdByHashCode(int hashcode) {
        // write your code here
        Map.Entry<Integer, Integer> entry = map.ceilingEntry(hashcode);
        return entry == null ? map.firstEntry().getValue() : entry.getValue();
    }
}
