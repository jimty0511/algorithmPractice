package practice.problem;

import java.awt.*;
import java.util.*;
import java.util.List;

// 269. Alien Dictionary
// Airbnb ladder
public class AlienDictionary {
    public String alienOrder(String[] words) {
        List<Point> pairs = new LinkedList<>();
        Set<Character> characters = new HashSet<>();
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            boolean alreadySet = false;
            for (int j = 0; j < words[i].length(); j++) {
                if (!alreadySet && i > 0 && j < words[i - 1].length() && words[i].charAt(j) != words[i - 1].charAt(j)) {
                    pairs.add(new Point(words[i].charAt(j), words[i - 1].charAt(j)));
                    alreadySet = true;
                }
                characters.add(word.charAt(j));
            }
        }

        String res = "";
        int[] indegree = new int[256];
        Arrays.fill(indegree, Integer.MIN_VALUE);
        for (char c : characters) {
            indegree[c] = 0;
        }
        for (int i = 0; i < pairs.size(); i++) {
            indegree[pairs.get(i).x]++;
        }

        Queue<Character> queue = new LinkedList<>();
        for (int i = 0; i < 256; i++) {
            if (indegree[i] == 0) {
                res += (char) i;
                queue.offer((char) i);
            }
        }
        while (!queue.isEmpty()) {
            char predecessor = queue.poll();
            for (int i = 0; i < pairs.size(); i++) {
                if (pairs.get(i).y == predecessor) {
                    indegree[pairs.get(i).x]--;
                    if (indegree[pairs.get(i).x] == 0) {
                        res += (char) pairs.get(i).x;
                        queue.offer((char) pairs.get(i).x);
                    }
                }
            }
        }
        return res.length() == characters.size() ? res : "";
    }

    public String alienOrderTwo(String[] words) {
        String result = "";
        if (words == null || words.length == 0)
            return result;
        Map<Character, Set<Character>> map = new HashMap<>();
        Map<Character, Integer> degree = new HashMap<>();
        for (String s : words) {
            for (char c : s.toCharArray())
                degree.put(c, 0);
        }
        for (int i = 0; i < words.length - 1; i++) {
            String cur = words[i];
            String next = words[i + 1];
            int length = Math.min(cur.length(), next.length());
            for (int j = 0; j < length; j++) {
                char curChar = cur.charAt(j);
                char nextChar = next.charAt(j);
                if (curChar != nextChar) {
                    map.putIfAbsent(curChar, new HashSet<>());
                    Set<Character> set = map.get(curChar);
                    if (!set.contains(nextChar)) {
                        set.add(nextChar);
                        map.put(curChar, set);
                        degree.put(nextChar, degree.get(nextChar) + 1);
                    }
                    break;
                }
            }
        }
        Queue<Character> queue = new LinkedList<>();
        for (char c : degree.keySet()) {
            if (degree.get(c) == 0)
                queue.offer(c);
        }
        while (!queue.isEmpty()) {
            char c = queue.poll();
            result += c;
            if (map.containsKey(c)) {
                for (char c2 : map.get(c)) {
                    degree.put(c2, degree.get(c2) - 1);
                    if (degree.get(c2) == 0)
                        queue.offer(c2);
                }
            }
        }
        return result.length() == degree.size() ? result : "";
    }

    public String alienOrderThree(String[] words) {
        if (words == null || words.length == 0)
            return "";
        Map<Character, Set<Character>> graph = new HashMap<>();
        Map<Character, Integer> inDegree = new HashMap<>();
        for (String w : words) {
            for (char c : w.toCharArray()) {
                inDegree.put(c, 0);
            }
        }
        for (int i = 0; i < words.length - 1; i++) {
            String cur = words[i];
            String next = words[i + 1];
            int len = Math.min(cur.length(), next.length());
            for (int j = 0; j < len; j++) {
                char curChar = cur.charAt(j);
                char nextChar = next.charAt(j);
                if (curChar != nextChar) {
                    graph.putIfAbsent(curChar, new HashSet<>());
                    Set<Character> set = graph.get(curChar);
                    if (set.add(nextChar)) {
                        graph.put(curChar, set);
                        inDegree.put(nextChar, inDegree.get(nextChar) + 1);
                    }
                    break;
                }
            }
        }
        Queue<Character> queue = new PriorityQueue<>();
        for (char c : inDegree.keySet()) {
            if (inDegree.get(c) == 0)
                queue.offer(c);
        }
        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()) {
            char c = queue.poll();
            sb.append(c);
            if (graph.containsKey(c)) {
                for (char c2 : graph.get(c)) {
                    inDegree.put(c2, inDegree.get(c2) - 1);
                    if (inDegree.get(c2) == 0)
                        queue.offer(c2);
                }
            }
        }
        return sb.length() == inDegree.size() ? sb.toString() : "";
    }
}
