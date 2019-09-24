package practice.problem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 679. 24 Game
public class TwentyFourGame {
    public boolean judgePoint24(int[] nums) {
        List<Double> list = new ArrayList<>();
        for (int i : nums)
            list.add((double) i);
        return helper(list);
    }

    private boolean helper(List<Double> list) {
        if (list.size() == 1) {
            if (Math.abs(list.get(0) - 24.0) < 0.1)
                return true;
            return false;
        }
        for (int i = 0; i < list.size(); i++) {
            for (int j = i + 1; j < list.size(); j++) {
                for (double c : compute(list.get(i), list.get(j))) {
                    List<Double> next = new ArrayList<>();
                    next.add(c);
                    for (int k = 0; k < list.size(); k++) {
                        if (k == i || k == j)
                            continue;
                        next.add(list.get(k));
                    }
                    if (helper(next))
                        return true;
                }
            }
        }
        return false;
    }

    private List<Double> compute(double a, double b) {
        List<Double> res = Arrays.asList(a + b, a - b, b - a, a * b, a / b, b / a);
        return res;
    }
}
