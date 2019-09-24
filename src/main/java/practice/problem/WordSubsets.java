package practice.problem;

import java.util.ArrayList;
import java.util.List;

// 916. Word Subsets
public class WordSubsets {
    public List<String> wordSubsets(String[] A, String[] B) {
        int[] uni = new int[26], tmp;
        int i;
        for (String b : B) {
            tmp = counter(b);
            for (i = 0; i < 26; i++)
                uni[i] = Math.max(uni[i], tmp[i]);
        }
        List<String> res = new ArrayList<>();
        for (String a : A) {
            tmp = counter(a);
            for (i = 0; i < 26; i++) {
                if (tmp[i] < uni[i])
                    break;
            }
            if (i == 26)
                res.add(a);
        }
        return res;
    }

    private int[] counter(String w) {
        int[] count = new int[26];
        for (char c : w.toCharArray())
            count[c - 'a']++;
        return count;
    }
}
