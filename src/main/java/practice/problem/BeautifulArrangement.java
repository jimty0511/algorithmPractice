package practice.problem;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

// 526. Beautiful Arrangement
public class BeautifulArrangement {
    int count = 0;

    public int countArrangement(int N) {
        if (N == 0)
            return 0;
        helper(N, 1, new boolean[N + 1]);
        return count;
    }

    private void helper(int N, int pos, boolean[] used) {
        if (pos > N) {
            count++;
            return;
        }
        for (int i = 1; i <= N; i++) {
            if (!used[i] && (i % pos == 0 || pos % i == 0)) {
                used[i] = true;
                helper(N, pos + 1, used);
                used[i] = false;
            }
        }
    }

    public int countArrangementTwo(int N) {
        char[] used = new char[N + 1];
        Arrays.fill(used, 'f');
        return helperTwo(new HashMap<>(), 1, used);
    }

    private int helperTwo(Map<String, Integer> map, int idx, char[] used) {
        if (idx == used.length)
            return 1;
        String key = String.valueOf(used);
        if (map.containsKey(key))
            return map.get(key);
        int count = 0;
        for (int i = 1; i < used.length; i++) {
            if (used[i] == 'f' && (i % idx == 0 || idx % i == 0)) {
                used[i] = 't';
                count += helperTwo(map, idx + 1, used);
                used[i] = 'f';
            }
        }
        map.put(key, count);
        return count;
    }
}
