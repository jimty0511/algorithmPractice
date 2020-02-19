package practice.problem;

import java.util.HashMap;
import java.util.Map;

// https://github.com/allaboutjst/airbnb
public class CollatzConjecture {

    Map<Integer, Integer> map = new HashMap<>();

    public int findLongestSteps(int num) {
        if (num < 1)
            return 0;
        int res = 0;
        for (int i = 1; i <= num; i++) {
            int step = findSteps(i);
            map.put(i, step);
            res = Math.max(res, step);
        }
        return res;
    }

    private int findSteps(int num) {
        if (num <= 1)
            return 1;
        if (map.containsKey(num))
            return map.get(num);
        if (num % 2 == 0)
            num /= 2;
        else
            num = 3 * num + 1;
        if (map.containsKey(num))
            return map.get(num) + 1;
        int step = findSteps(num);
        map.put(num, step);
        return step + 1;
    }
}
