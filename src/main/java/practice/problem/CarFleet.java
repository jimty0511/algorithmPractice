package practice.problem;

import java.util.TreeMap;

// 853. Car Fleet
public class CarFleet {
    public int carFleet(int target, int[] position, int[] speed) {
        TreeMap<Integer, Double> map = new TreeMap<>();
        for (int i = 0; i < position.length; i++) {
            map.put(-position[i], (double) (target - position[i]) / speed[i]);
        }
        int res = 0;
        double cur = 0;
        for (double time : map.values()) {
            if (time > cur) {
                cur = time;
                res++;
            }
        }
        return res;
    }
}
