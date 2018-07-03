package practice.problem;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// 89. Gray Code
public class GrayCode {
    public List<Integer> grayCodeBackTrack(int n) {
        List<Integer> result = new ArrayList<>();
        if (n == 0)
            return result;
        grayCodeHelper(result, "", n);
        return result;
    }

    // Backtracking for playaround
    private void grayCodeHelper(List<Integer> result, String cur, int n) {
        if (cur.length() == n) {
            result.add(Integer.parseInt(cur, 2));
        } else {
            for (int i = 0; i <= 1; i++) {
                cur += String.valueOf(i);
                grayCodeHelper(result, cur, n);
                cur = cur.substring(0, cur.length() - 1);
            }
        }
    }

    public List<Integer> grayCode(int n) {
//        List<Integer> result = new LinkedList<>();
//        for (int i = 0; i < 1 << n; i++) {
//            result.add(i ^ i >> 1);
//        }
//        return result;

        List<Integer> list = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        list.add(0);
        set.add(0);
        for (int i = 1; i < 1 << n; i++) {
            int k = list.get(i - 1);
            for (int j = 0; j < n; j++) {
                if (set.add(k ^ 1 << j)) {
                    list.add(k ^ 1 << j);
                    break;
                }
            }
        }
        return list;
    }
}
