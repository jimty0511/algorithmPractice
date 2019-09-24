package practice.problem;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

// 854. K-Similar Strings
public class KSimilarStrings {
    public int kSimilarity(String A, String B) {
        if (A.equals(B))
            return 0;
        Set<String> visited = new HashSet<>();
        Queue<String> q = new LinkedList<>();
        q.offer(A);
        visited.add(A);
        int res = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            res++;
            for (int sz = 0; sz < size; sz++) {
                String s = q.poll();
                int i = 0;
                while (s.charAt(i) == B.charAt(i))
                    i++;
                for (int j = i + 1; j < s.length(); j++) {
                    if (s.charAt(j) == B.charAt(j) || s.charAt(j) != B.charAt(i))
                        continue;
                    String temp = swap(s, i, j);
                    if (temp.equals(B))
                        return res;
                    if (visited.add(temp))
                        q.offer(temp);
                }
            }
        }
        return res;
    }

    private String swap(String s, int i, int j) {
        char[] chars = s.toCharArray();
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
        return new String(chars);
    }
}
