package practice.problem;

import java.util.Arrays;

public class SalaryAdjustment {
    public int getCap(int[] a, int target) {
        Arrays.sort(a);
        int sum = 0;
        for (int i = a.length - 1; i >= 0; i--) {
            int expect = (target - sum) / (i + 1);
            if (expect >= a[i])
                return (target - sum) % (i + 1) == 0 ? expect : expect + 1;
            sum += a[i];
        }
        return -1;
    }
}
