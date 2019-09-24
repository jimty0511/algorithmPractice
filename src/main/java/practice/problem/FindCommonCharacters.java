package practice.problem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 1002. Find Common Characters
public class FindCommonCharacters {
    public List<String> commonChars(String[] A) {
        List<String> res = new ArrayList<>();
        int[] count = new int[26];
        Arrays.fill(count, Integer.MAX_VALUE);
        for (String str : A) {
            int[] cnt = new int[26];
            for (char c : str.toCharArray())
                cnt[c - 'a']++;
            for (int i = 0; i < 26; i++)
                count[i] = Math.min(cnt[i], count[i]);
        }
        for (int i = 0; i < 26; i++) {
            while (count[i]-- > 0)
                res.add("" + (char) (i + 'a'));
        }
        return res;
    }
}
