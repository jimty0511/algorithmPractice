package practice.problem;

import java.util.HashMap;
import java.util.Map;

// 956. Tallest Billboard
public class TallestBillboard {
    public int tallestBillboard(int[] rods) {
        Map<Integer, Integer> dp = new HashMap<>();
        dp.put(0, 0);
        for (int ele : rods) {
            Map<Integer, Integer> temp = new HashMap<>(dp);
            for (int dif : dp.keySet()) {
                temp.put(dif + ele, Math.max(temp.getOrDefault(dif + ele, 0), dp.get(dif) + ele));
                temp.put(dif - ele, Math.max(temp.getOrDefault(dif - ele, 0), dp.get(dif)));
            }
            dp = temp;
        }
        return dp.get(0);
    }
}
