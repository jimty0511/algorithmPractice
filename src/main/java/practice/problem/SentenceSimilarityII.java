package practice.problem;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

// 737. Sentence Similarity II
public class SentenceSimilarityII {
    public boolean areSentencesSimilarTwo(String[] words1, String[] words2, String[][] pairs) {
        if (words1.length != words2.length)
            return false;
        Map<String, String> map = new HashMap<>();
        for (String[] p : pairs) {
            String word1 = p[0], word2 = p[1];
            if (!map.containsKey(word1))
                map.put(word1, word1);
            if (!map.containsKey(word2))
                map.put(word2, word2);
            setParent(map, word1, word2);
        }
        for (int i = 0; i < words1.length; i++) {
            String word1 = words1[i];
            String word2 = words2[i];
            String parent1 = getParent(word1, map);
            String parent2 = getParent(word2, map);
            if (!parent1.equals(parent2))
                return false;
        }
        return true;
    }

    private String getParent(String word, Map<String, String> map) {
        if (!map.containsKey(word))
            return word;
        while (word != map.get(word))
            word = map.get(word);
        return word;
    }

    private void setParent(Map<String, String> map, String word1, String word2) {
        String p1 = getParent(word1, map);
        String p2 = getParent(word2, map);
        map.put(p1, p2);
    }

    public boolean areSentencesSimilarTwo2(String[] words1, String[] words2, String[][] pairs) {
        if (words1.length != words2.length)
            return false;
        Map<String, String> map = new HashMap<>();
        for (String[] p : pairs) {
            String parent1 = find(map, p[0]), parent2 = find(map, p[1]);
            if (!parent1.equals(parent2))
                map.put(parent1, parent2);
        }
        for (int i = 0; i < words1.length; i++) {
            if (!words1[i].equals(words2[i]) && !find(map, words1[i]).equals(find(map, words2[i])))
                return false;
        }
        return true;
    }

    private String find(Map<String, String> map, String s) {
        if (!map.containsKey(s))
            map.put(s, s);
        return s.equals(map.get(s)) ? s : find(map, map.get(s));
    }

    public boolean areSentencesSimilarDfs(String[] words1, String[] words2, String[][] pairs) {
        if (words1.length != words2.length)
            return false;
        Map<String, Set<String>> graph = new HashMap<>();
        for (String[] p : pairs) {
            graph.putIfAbsent(p[0], new HashSet<>());
            graph.putIfAbsent(p[1], new HashSet<>());
            graph.get(p[0]).add(p[1]);
            graph.get(p[1]).add(p[0]);
        }
        for (int i = 0; i < words1.length; i++) {
            if (words1[i].equals(words2[i]))
                continue;
            if (!graph.containsKey(words1[i]))
                return false;
            if (!dfs(graph, words1[i], words2[i], new HashSet<>()))
                return false;
        }
        return true;
    }

    private boolean dfs(Map<String, Set<String>> graph, String source, String target, Set<String> visited) {
        if (graph.get(source).contains(target))
            return true;
        if (visited.add(source)) {
            for (String next : graph.get(source)) {
                if (!visited.contains(next) && dfs(graph, next, target, visited))
                    return true;
            }
        }
        return false;
    }
}
