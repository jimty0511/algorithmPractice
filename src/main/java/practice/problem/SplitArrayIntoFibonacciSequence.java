package practice.problem;

import java.util.ArrayList;
import java.util.List;

// 842. Split Array into Fibonacci Sequence
public class SplitArrayIntoFibonacciSequence {
    public List<Integer> splitIntoFibonacci(String S) {
        List<Integer> result = new ArrayList<>();
        helper(0, S, result);
        return result;
    }

    private boolean helper(int curIdx, String S, List<Integer> result) {
        if (curIdx == S.length() && result.size() >= 3) {
            return true;
        }
        for (int i = curIdx; i < S.length(); i++) {
            if (S.charAt(curIdx) == '0' && i > curIdx) {
                break;
            }
            long num = Long.valueOf(S.substring(curIdx, i + 1));
            if (num > Integer.MAX_VALUE) {
                break;
            }
            if (result.size() <= 1 || num == (long) result.get(result.size() - 1) + (long) result.get(result.size() - 2)) {
                result.add((int) num);
                if (helper(i + 1, S, result)) {
                    return true;
                }
                result.remove(result.size() - 1);
            }
        }
        return false;
    }
}
