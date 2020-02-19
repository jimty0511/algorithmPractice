package practice.lintcode;

import java.util.HashMap;
import java.util.Map;

// 841. String Replace
public class StringReplace {
    /**
     * @param a: The A array
     * @param b: The B array
     * @param s: The S string
     * @return: The answer
     */
    public String stringReplace(String[] a, String[] b, String s) {
        // Write your code here
        if (s == null || a == null || b == null)
            return s;
        int MOD = (int) 1e9 + 7, seed = 31;
        Map<Integer, Integer> map = new HashMap<>(); // s.idx, a[i]
        for (int i = 0; i < a.length; i++) {
            String target = a[i];
            int targetLen = target.length();
            int targetHc = 0;
            for (int j = 0; j < targetLen; j++) {
                targetHc = (targetHc * seed + target.charAt(j) - 'a') % MOD;
                if (targetHc < 0)
                    targetHc += MOD;
            }
            int removeVal = 1;
            for (int k = 0; k < targetLen - 1; k++) {
                removeVal = removeVal * seed % MOD;
            }
            int curVal = 0;
            for (int m = 0; m < s.length(); m++) {
                if (m >= targetLen) {
                    curVal = (curVal - removeVal * (s.charAt(m - targetLen) - 'a')) % MOD;
                    if (curVal < 0)
                        curVal += MOD;
                }
                curVal = (curVal * seed + s.charAt(m) - 'a') % MOD;
                if (curVal == targetHc) {
                    if (!map.containsKey(m - targetLen + 1))
                        map.put(m - targetLen + 1, i);
                    if (map.containsKey(m - targetLen + 1) && a[map.get(m - targetLen + 1)].length() < a[i].length())
                        map.put(m - targetLen + 1, i);
                }
            }
        }
        StringBuilder sb = new StringBuilder(s);
        int len = s.length();
        for (int i = 0; i < len; i++) {
            if (map.containsKey(i)) {
                int idx = map.get(i);
                int l = b[idx].length();
                sb.replace(i, i + l, b[idx]);
                i = i + l - 1;
            }
        }
        return sb.toString();
    }
}
