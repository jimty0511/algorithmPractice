package practice.lintcode;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

// 1785. Bank System
public class BankSystem {

    Map<Integer, TreeMap<Long, Integer>> map;

    public BankSystem() {
        // Write your code here
        map = new HashMap<>();
    }

    /**
     * @param id:        user account id
     * @param amount:    the number of bank deposits
     * @param timestamp: the data of bank transaction
     * @return: nothing
     */
    public void deposite(int id, int amount, long timestamp) {
        // Write your code here
        map.putIfAbsent(id, new TreeMap<>());
        TreeMap<Long, Integer> treeMap = map.get(id);
        Long startKey = treeMap.containsKey(timestamp) ? timestamp : treeMap.lowerKey(timestamp);
        if (startKey != null)
            amount += treeMap.get(startKey);
        map.get(id).put(timestamp, amount);
    }

    /**
     * @param id:        user account id
     * @param amount     : the number of bank withdraw
     * @param timestamp: the data of bank transaction
     * @return: if user account can not withdraw the number of amount,return false. else return true
     */
    public boolean withdraw(int id, int amount, long timestamp) {
        //
        if (!map.containsKey(id))
            return false;
        TreeMap<Long, Integer> treeMap = map.get(id);
        Map.Entry<Long, Integer> entry = treeMap.lowerEntry(timestamp);
        if (amount > entry.getValue())
            return false;
        treeMap.put(timestamp, entry.getValue() - amount);
        return true;
    }

    /**
     * @param id:        user account id
     * @param startTime: start time
     * @param endTime:   end time
     * @return: need return two numbers,the first one is start time account balance,the second is end time account balance
     */
    public int[] check(int id, long startTime, long endTime) {
        //
        if (!map.containsKey(id))
            return new int[0];
        TreeMap<Long, Integer> treeMap = map.get(id);
        Long startKey = treeMap.containsKey(startTime) ? startTime : treeMap.lowerKey(startTime);
        Long endKey = treeMap.containsKey(endTime) ? endTime : treeMap.lowerKey(endTime);

        int startVal = startKey == null ? 0 : treeMap.get(startKey);
        int endVal = endKey == null ? 0 : treeMap.get(endKey);
        return new int[]{startVal, endVal};
    }
}
