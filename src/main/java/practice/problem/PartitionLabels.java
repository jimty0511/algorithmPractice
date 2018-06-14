package practice.problem;

import java.util.ArrayList;
import java.util.List;

// 763. Partition Labels
public class PartitionLabels {
    public List<Integer> partitionLabels(String S) {
        if (S == null || S.length() == 0)
            return null;
        List<Integer> result = new ArrayList<>();
        int[] map = new int[26];
        for (int i = 0; i < S.length(); i++) {
            map[S.charAt(i) - 'a'] = i;
        }
        int last = 0, start = 0;
        for (int i = 0; i < S.length(); i++) {
            last = Math.max(last, map[S.charAt(i) - 'a']);
            if (last == i) {
                result.add(last - start + 1);
                start = last + 1;
            }
        }
        return result;
    }
}
