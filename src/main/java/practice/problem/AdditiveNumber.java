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

    public boolean isAdditiveNumberTwo(String num) {
        if (num == null || num.length() == 0)
            return false;
        int n = num.length();
        for (int i = 1; i < n; i++) {
            if (i > 1 && num.charAt(0) == '0')
                break;
            for (int j = i + 1; j < n; j++) {
                int first = 0, second = i, third = j;
                if (num.charAt(second) == '0' && third > second + 1)
                    break;
                while (third < n) {
                    Long res = (Long.parseLong(num.substring(first, second)) +
                            Long.parseLong(num.substring(second, third)));
                    if (num.substring(third).startsWith(res.toString())) {
                        first = second;
                        second = third;
                        third += res.toString().length();
                    } else
                        break;
                }
                if (third == n)
                    return true;
            }
        }
        return false;
    }
}
