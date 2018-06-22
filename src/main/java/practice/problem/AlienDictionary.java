package practice.problem;

import java.awt.*;
import java.util.*;
import java.util.List;

// 269. Alien Dictionary
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
}
