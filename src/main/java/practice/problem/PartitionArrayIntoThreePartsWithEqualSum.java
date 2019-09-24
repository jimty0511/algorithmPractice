package practice.problem;

import java.util.Arrays;

// 1013. Partition Array Into Three Parts With Equal Sum
public class PartitionArrayIntoThreePartsWithEqualSum {
    public boolean canThreePartsEqualSum(int[] A) {
        int sum = Arrays.stream(A).sum(), part = 0, cnt = 0;
        if (sum % 3 != 0)
            return false;
        for (int a : A) {
            part += a;
            if (part != sum / 3)
                continue;
            if (++cnt == 3)
                return true;
            part = 0;
        }
        return false;
    }
}
