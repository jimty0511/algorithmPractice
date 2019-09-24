package practice.problem;

import java.util.ArrayList;
import java.util.List;

// 728. Self Dividing Numbers
public class SelfDividingNumbers {
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> result = new ArrayList<>();
        for (int i = left, j = 0; i <= right; i++) {
            for (j = i; j > 0; j /= 10) {
                if (j % 10 == 0 || i % (j % 10) != 0)
                    break;
            }
            if (j == 0)
                result.add(i);
        }
        return result;
    }

    public List<Integer> selfDividingNumbersTwo(int left, int right) {
        List<Integer> res = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            if (helper(i))
                res.add(i);
        }
        return res;
    }

    private boolean helper(int num) {
        int cur = num;
        while (cur != 0) {
            int digit = cur % 10;
            if (digit == 0 || num % digit != 0)
                return false;
            cur /= 10;
        }
        return true;
    }
}
