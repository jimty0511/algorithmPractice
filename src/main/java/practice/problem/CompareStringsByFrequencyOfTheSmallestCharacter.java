package practice.problem;

import java.util.Arrays;

// 1170. Compare Strings by Frequency of the Smallest Character
public class CompareStringsByFrequencyOfTheSmallestCharacter {
    public int[] numSmallerByFrequency(String[] queries, String[] words) {
        int[] q = new int[queries.length], w = new int[words.length];
        for (int i = 0; i < q.length; i++)
            q[i] = getF(queries[i]);
        for (int i = 0; i < w.length; i++)
            w[i] = getF(words[i]);
        Arrays.sort(w);
        int[] res = new int[q.length];
        for (int i = 0; i < q.length; i++) {
            int l = 0, r = w.length - 1;
            while (l <= r) {
                int m = (l + r) / 2;
                if (w[m] <= q[i])
                    l = m + 1;
                else
                    r = m - 1;
            }
            res[i] = w.length - l;
        }
        return res;
    }

    private int getF(String s) {
        char ch = 'z';
        int cnt = 0;
        for (char c : s.toCharArray()) {
            if (c < ch) {
                ch = c;
                cnt = 1;
            } else if (c == ch)
                cnt++;
        }
        return cnt;
    }
}
