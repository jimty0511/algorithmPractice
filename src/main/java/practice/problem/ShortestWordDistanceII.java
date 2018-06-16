package practice.problem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// 244. Shortest Word Distance II
public class ShortestWordDistanceII {

    Map<String, List<Integer>> map;

    public ShortestWordDistanceII(String[] words) {
        map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            String temp = words[i];
            if (map.containsKey(temp)) {
                map.get(temp).add(i);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(temp, list);
            }
        }
    }

    public int shortest(String word1, String word2) {
        int min = Integer.MAX_VALUE;
        List<Integer> list1 = map.get(word1);
        List<Integer> list2 = map.get(word2);
        int i = 0, j = 0;
        while (i < list1.size() && j < list2.size()) {
            int t1 = list1.get(i), t2 = list2.get(j);
            if (t1 < t2) {
                min = Math.min(min, t2 - t1);
                i++;
            } else {
                min = Math.min(min, t1 - t2);
                j++;
            }
        }
        return min;
    }
}
