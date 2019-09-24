package practice.lintcode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

// 624 Remove Substrings (LC)
public class RemoveSubstrings {
    public int minLength(String s, Set<String> dict) {
        Queue<String> q = new LinkedList<>();
        Set<String> set = new HashSet<>();
        int min = Integer.MAX_VALUE;
        q.offer(s);
        set.add(s);
        while (!q.isEmpty()) {
            String str = q.poll();
            min = Math.min(str.length(), min);
            for (String sub : dict) {
                int idx = str.indexOf(sub);
                while (idx != -1) {
                    String newStr = str.substring(0, idx) + str.substring(idx + sub.length());
                    if (!set.contains(newStr)) {
                        if (newStr.length() < min)
                            min = newStr.length();
                        q.offer(newStr);
                        set.add(newStr);
                    }
                    idx = str.indexOf(sub, idx + 1);
                }
            }
        }
        return min;
    }
}
