package practice.problem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// 1178. Number of Valid Words for Each Puzzle
public class NumberOfValidWordsForEachPuzzle {
    public List<Integer> findNumOfValidWords(String[] words, String[] puzzles) {
        Map<Integer, Integer> map = new HashMap<>();
        for (String w : words) {
            int mask = 0;
            for (int i = 0; i < w.length(); i++) {
                mask |= 1 << (w.charAt(i) - 'a');
            }
            map.put(mask, map.getOrDefault(mask, 0) + 1);
        }
        List<Integer> res = new ArrayList<>();
        for (String p : puzzles) {
            int mask = 0;
            for (int i = 0; i < p.length(); i++) {
                mask |= 1 << (p.charAt(i) - 'a');
            }
            int count = 0;
            int sub = mask;
            int first = 1 << (p.charAt(0) - 'a');
            while (sub != 0) {
                if ((sub & first) == first && map.containsKey(sub))
                    count += map.get(sub);
                sub = (sub - 1) & mask; // get the next substring
            }
            res.add(count);
        }
        return res;
    }
}
