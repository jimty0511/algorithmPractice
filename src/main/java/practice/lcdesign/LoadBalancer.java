package practice.lcdesign;

import java.util.*;

// 526. Load Balancer
public class LoadBalancer {

    List<Integer> list;
    Random rand;
    Map<Integer, Integer> dict;
    int len = 0;

    public LoadBalancer() {
        // do intialization if necessary
        list = new ArrayList<>();
        rand = new Random();
        dict = new HashMap<>();
    }

//    /*
//     * @param server_id: add a new server to the cluster
//     * @return: nothing
//     */
//    public void add(int server_id) {
//        // write your code here
//        int idx = list.size();
//        dict.put(server_id, idx);
//        list.add(server_id);
//    }
//
//    /*
//     * @param server_id: server_id remove a bad server from the cluster
//     * @return: nothing
//     */
//    public void remove(int server_id) {
//        // write your code here
//        Integer idx = dict.get(server_id);
//        if (idx == null)
//            return;
//        int n = list.size();
//        list.set(idx, list.get(n - 1));
//        dict.put(list.get(n - 1), idx);
//        list.remove(n - 1);
//        dict.remove(server_id);
//    }
//
//    /*
//     * @return: pick a server in the cluster randomly with equal probability
//     */
//    public int pick() {
//        // write your code here
//        int size = list.size();
//        int idx = Math.abs(rand.nextInt()) % size;
//        return list.get(idx);
//    }

    /*
     * @param server_id: add a new server to the cluster
     * @return: nothing
     */
    public void add(int server_id) {
        // write your code here
        if (!dict.containsKey(server_id)) {
            dict.put(server_id, len);
            list.add(server_id);
            len++;
        }
    }

    /*
     * @param server_id: server_id remove a bad server from the cluster
     * @return: nothing
     */
    public void remove(int server_id) {
        // write your code here
        if (dict.containsKey(server_id)) {
            int lastItem = list.get(len - 1);
            int removeIdx = dict.get(server_id);
            dict.put(lastItem, removeIdx);
            list.set(removeIdx, lastItem);
            dict.remove(server_id);
            list.remove(len - 1);
            len--;
        }
    }

    /*
     * @return: pick a server in the cluster randomly with equal probability
     */
    public int pick() {
        // write your code here
        return list.get(rand.nextInt(len));
    }
}
