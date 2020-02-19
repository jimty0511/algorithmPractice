package practice.lintcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HeartBeat {

    private Map<String, Integer> map;
    private int k;

    public HeartBeat() {
        // do intialization if necessary
        map = new HashMap<>();
    }

    /*
     * @param slaves_ip_list: a list of slaves'ip addresses
     * @param k: An integer
     * @return: nothing
     */
    public void initialize(List<String> slaves_ip_list, int k) {
        // write your code here
        this.k = k;
        for (String ip : slaves_ip_list)
            map.put(ip, 0);
    }

    /*
     * @param timestamp: current timestamp in seconds
     * @param slave_ip: the ip address of the slave server
     * @return: nothing
     */
    public void ping(int timestamp, String slave_ip) {
        // write your code here
        if (!map.containsKey(slave_ip))
            return;
        map.put(slave_ip, timestamp);
    }

    /*
     * @param timestamp: current timestamp in seconds
     * @return: a list of slaves'ip addresses that died
     */
    public List<String> getDiedSlaves(int timestamp) {
        // write your code here
        List<String> res = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            String ip = entry.getKey();
            int time = entry.getValue();
            if (time <= timestamp - 2 * k)
                res.add(ip);
        }
        return res;
    }
}
