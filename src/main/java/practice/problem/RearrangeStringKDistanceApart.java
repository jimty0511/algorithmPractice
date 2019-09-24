package practice.problem;

import java.util.*;

// 358. Rearrange String k Distance Apart
public class RearrangeStringKDistanceApart {
    public String rearrangeString(String s, int k) {
        StringBuilder sb = new StringBuilder();
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray())
            map.put(c, map.getOrDefault(c, 0) + 1);
        PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
        pq.addAll(map.entrySet());
        Queue<Map.Entry<Character, Integer>> waitQ = new LinkedList<>();
        while (!pq.isEmpty()) {
            Map.Entry<Character, Integer> first = pq.poll();
            sb.append(first.getKey());
            first.setValue(first.getValue() - 1);
            waitQ.offer(first);
            if (waitQ.size() < k)
                continue;
            Map.Entry<Character, Integer> second = waitQ.poll();
            if (second.getValue() > 0)
                pq.offer(second);
        }
        return sb.length() == s.length() ? sb.toString() : "";
    }

    public String rearrangeStringTwo(String s, int k) {
        if (s == null || s.length() == 0 || k < 2)
            return s;
        int[] validPos = new int[26], letterCnt = new int[26];
        char[] res = new char[s.length()];
        for (char c : s.toCharArray())
            letterCnt[c - 'a']++;
        int n = s.length();
        for (int i = 0; i < n; i++) {
            int next = findNext(letterCnt, validPos, i);
            if (next == -1)
                return "";
            res[i] = (char) ('a' + next);
            validPos[next] = i + k;
            letterCnt[next]--;
        }
        return new String(res);
    }

    private int findNext(int[] letterCnt, int[] validPos, int idx) {
        int max = 0, res = -1;
        for (int i = 0; i < 26; i++) {
            if (letterCnt[i] > max && validPos[i] <= idx) {
                res = i;
                max = letterCnt[i];
            }
        }
        return res;
    }
}
