package practice.problem;

import java.util.Arrays;

// 522. Longest Uncommon Subsequence II
public class LongestUncommonSubsequenceII {
    public int findLUSlength(String[] strs) {
        if (strs == null || strs.length == 0)
            return 0;
        Arrays.sort(strs, (s1, s2) -> Integer.compare(s2.length(), s1.length()));
        int n = strs.length;
        for (int i = 0; i < n; i++) {
            int subSeq = n;
            for (int j = 0; j < n; j++, subSeq--) {
                if (i != j && isSubSeq(strs[i], strs[j]))
                    break;
            }
            if (subSeq == 0)
                return strs[i].length();
        }
        return -1;
    }

    private boolean isSubSeq(String s1, String s2) {
        int i = 0, m = s1.length(), n = s2.length();
        for (int j = 0; i < m && j < n; j++) {
            if (s1.charAt(i) == s2.charAt(j))
                i++;
        }
        return i == m;
    }
}
