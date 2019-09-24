package practice.lintcode;

import java.util.List;

// 784. The Longest Common Prefix II
public class TheLongestCommonPrefixII {
    public int the_longest_common_prefix(List<String> dic, String target) {
        // write your code here
        int max = 0;
        for (String d : dic) {
            int len = 0;
            for (int i = 0; i < d.length(); i++) {
                if (i > target.length() - 1 || d.charAt(i) != target.charAt(i))
                    break;
                len++;
            }
            max = Math.max(max, len);
        }
        return max;
    }
}
