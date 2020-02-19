package practice.problem;

import java.util.Arrays;

// 1160. Find Words That Can Be Formed by Characters
public class FindWordsThatCanBeFormedByCharacters {
    public int countCharacters(String[] words, String chars) {
        if (words == null || words.length < 1)
            return 0;
        int[] cnt = new int[26];
        for (char c : chars.toCharArray())
            cnt[c - 'a']++;
        int total = 0;
        for (String w : words) {
            int[] tmp = Arrays.copyOf(cnt, cnt.length);
            int wCnt = 0;
            for (char c : w.toCharArray()) {
                if (tmp[c - 'a'] > 0) {
                    tmp[c - 'a']--;
                    wCnt++;
                } else
                    break;
            }
            if (wCnt == w.length())
                total += w.length();
        }
        return total;
    }
}
