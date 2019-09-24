package practice.problem;

import java.util.ArrayList;
import java.util.List;

// 842. Split Array into Fibonacci Sequence
public class SplitArrayIntoFibonacciSequence {
    public List<Integer> splitIntoFibonacci(String S) {
        List<Integer> res = new ArrayList<>();
        helper(0, S, res);
        return res;
    }

    private boolean helper(int idx, String S, List<Integer> res) {
        if (idx == S.length() && res.size() >= 3)
            return true;
        for (int i = idx; i < S.length(); i++) {
            if (S.charAt(idx) == '0' && i > idx)
                break;
            long num = Long.valueOf(S.substring(idx, i + 1));
            if (num > Integer.MAX_VALUE)
                break;
            int size = res.size();
            if (size >= 2 && num > res.get(size - 1) + res.get(size - 2))
                break;
            if (res.size() <= 1 || num == res.get(size - 1) + res.get(size - 2)) {
                res.add((int) num);
                if (helper(i + 1, S, res))
                    return true;
                res.remove(res.size() - 1);
            }
        }
        return false;
    }
}
