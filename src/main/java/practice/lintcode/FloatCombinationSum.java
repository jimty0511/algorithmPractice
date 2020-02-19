package practice.lintcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

// 1800. Float Combination Sum
public class FloatCombinationSum {
    public int[] getArray(double[] A, int target) {
        double maxSum = 0;
        Double[] diff = new Double[A.length];
        for (int i = 0; i < A.length; i++) {
            double roundUp = Math.ceil(A[i]);
            maxSum += roundUp;
            diff[i] = roundUp - A[i];
        }
        double numberNeedToFloor = maxSum - target;
        Arrays.sort(diff, Comparator.reverseOrder());
        Map<Double, Integer> map = new HashMap<>();
        for (int i = 0; i < numberNeedToFloor; i++) {
            map.put(diff[i], map.getOrDefault(diff[i], 0) + 1);
        }
        int[] res = new int[A.length];
        for (int i = 0; i < A.length; i++) {
            double roundUpDiff = Math.ceil(A[i]) - A[i];
            if (map.getOrDefault(roundUpDiff, 0) > 0) {
                res[i] = (int) Math.floor(A[i]);
                map.put(roundUpDiff, map.get(roundUpDiff) - 1);
            } else {
                res[i] = (int) Math.ceil(A[i]);
            }
        }
        return res;
    }
}
