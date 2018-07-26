package practice.problem;

import java.util.ArrayList;
import java.util.List;

// 306. Additive Number
public class AdditiveNumber {
    public boolean isAdditiveNumber(String num) {
        return helper(0, new ArrayList<>(), num);
    }

    private boolean helper(int curIdx, List<String> result, String s) {
        if (curIdx == s.length() && result.size() >= 3) {
            return true;
        }
        for (int i = curIdx; i <= s.length() - 1; i++) {
            if (s.charAt(curIdx) == '0' && i != curIdx) {
                break;
            }
            String num = s.substring(curIdx, i + 1);
            if (result.size() <= 1 || num.equals(String.valueOf(Long.parseLong(result.get(result.size() - 1)) +
                    Long.parseLong(result.get(result.size() - 2))))) {
                result.add(num);
                if (helper(i + 1, result, s)) {
                    return true;
                }
                result.remove(result.size() - 1);
            }
        }
        return false;
    }
}
