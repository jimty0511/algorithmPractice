package practice.problem;

import java.util.ArrayList;
import java.util.List;

// 1239. Maximum Length of a Concatenated String with Unique Characters
// https://leetcode.com/discuss/interview-question/401826/
public class MaximumLengthOfAConcatenatedStringWithUniqueCharacters {
    public int maxLength(List<String> arr) {
        List<Integer> dp = new ArrayList<>();
        dp.add(0);
        int res = 0;
        for (String s : arr) {
            int val = 0, dup = 0;
            for (char c : s.toCharArray()) {
                dup |= val & (1 << (c - 'a'));
                val |= 1 << (c - 'a');
            }
            if (dup > 0)
                continue;
            for (int i = dp.size() - 1; i >= 0; i--) {
                if ((dp.get(i) & val) > 0)
                    continue;
                dp.add(dp.get(i) | val);
                res = Math.max(res, Integer.bitCount(dp.get(i) | val));
            }
        }
        return res;
    }
}
