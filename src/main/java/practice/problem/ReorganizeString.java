package practice.problem;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

// 767. Reorganize String
public class ReorganizeString {
    public String reorganizeString(String S) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : S.toCharArray()) {
            int count = map.getOrDefault(c, 0) + 1;
            if (count > (S.length() + 1) / 2)
                return "";
            map.put(c, count);
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        for (char c : map.keySet()) {
            pq.offer(new int[]{c, map.get(c)});
        }
        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()) {
            int[] first = pq.poll();
            if (sb.length() == 0 || first[0] != sb.charAt(sb.length() - 1)) {
                sb.append((char) first[0]);
                if (--first[1] > 0)
                    pq.offer(first);
            } else {
                int[] second = pq.poll();
                sb.append((char) second[0]);
                if (--second[1] > 0)
                    pq.offer(second);
                pq.offer(first);
            }
        }
        return sb.toString();
    }

    public String reorganizeStringMap(String S) {
        if (S == null || S.length() == 0)
            return "";
        Map<Character, Integer> map = new HashMap<>();
        for (char c : S.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
        for (Map.Entry<Character, Integer> e : map.entrySet())
            pq.offer(e);
        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()) {
            Map.Entry<Character, Integer> first = pq.poll();
            if (sb.length() == 0 || sb.charAt(sb.length() - 1) != first.getKey()) {
                sb.append(first.getKey());
                first.setValue(first.getValue() - 1);
                if (first.getValue() > 0)
                    pq.offer(first);
            } else {
                Map.Entry<Character, Integer> second = pq.poll();
                if (second == null)
                    return "";
                sb.append(second.getKey());
                second.setValue(second.getValue() - 1);
                if (second.getValue() > 0)
                    pq.offer(second);
                pq.offer(first);
            }
        }
        return sb.toString();
    }

    public String reorganizeStringBucket(String S) {
        int[] hash = new int[26];
        int maxCnt = 0, maxLetter = 0;
        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            hash[c - 'a']++;
        }
        for (int i = 0; i < hash.length; i++) {
            if (hash[i] > maxCnt) {
                maxCnt = hash[i];
                maxLetter = i;
            }
        }
        if (maxCnt > (S.length() + 1) / 2)
            return "";
        char[] res = new char[S.length()];
        int idx = 0;
        while (hash[maxLetter] > 0) {
            res[idx] = (char) (maxLetter + 'a');
            idx += 2;
            hash[maxLetter]--;
        }
        for (int i = 0; i < hash.length; i++) {
            while (hash[i] > 0) {
                if (idx >= res.length)
                    idx = 1;
                res[idx] = (char) (i + 'a');
                idx += 2;
                hash[i]--;
            }
        }
        return new String(res);
    }
}
