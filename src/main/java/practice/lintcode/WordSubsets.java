package practice.lintcode;

import java.util.ArrayList;
import java.util.List;

// 1726. Word Subsets
public class WordSubsets {
    /**
     * @param A: a string array
     * @param B: a string array
     * @return: return an string array
     */
    public List<String> wordSubsets(String[] A, String[] B) {
        // write your code here
        List<String> res = new ArrayList<>();
        if (A == null || B == null || A.length == 0 || B.length == 0)
            return res;
        int[] total = new int[26];
        for (String b : B) {
            int[] tmp = new int[26];
            for (char c : b.toCharArray()) {
                tmp[c - 'a']++;
            }
            for (int i = 0; i < 26; i++) {
                total[i] = Math.max(total[i], tmp[i]);
            }
        }
        for (String a : A) {
            int[] tmp = new int[26];
            for (char c : a.toCharArray())
                tmp[c - 'a']++;
            int idx = 0;
            while (idx < 26) {
                if (tmp[idx] < total[idx])
                    break;
                idx++;
            }
            if (idx == 26)
                res.add(a);
        }
        return res;
    }
}
