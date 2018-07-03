package practice.problem;

import java.util.*;

// 126. Word Ladder II
public class WordLadderII {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> res = new ArrayList<>();
        Set<String> wordDict = new HashSet<>(wordList);
        Map<String, Integer> ladder = new HashMap<>();
        Map<String, Set<String>> graph = new HashMap<>();
        ladder.put(beginWord, 0);
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);

        while (!queue.isEmpty()) {
            String word = queue.poll();
            if (word.equals(endWord))
                break;

            int step = ladder.get(word) + 1;
            for (int i = 0; i < word.length(); i++) {
                StringBuilder sb = new StringBuilder(word);
                for (char c = 'a'; c <= 'z'; c++) {
                    if (c == word.charAt(i)) {
                        continue;
                    }
                    sb.setCharAt(i, c);
                    String newWord = sb.toString();
                    if (!wordDict.contains(newWord)) {
                        continue;
                    }
                    if (step <= ladder.getOrDefault(newWord, Integer.MAX_VALUE)) {
                        queue.add(newWord);
                        ladder.put(newWord, step);
                        if (!graph.containsKey(word)) {
                            graph.put(word, new HashSet<>());
                        }
                        graph.get(word).add(newWord);
                    }
                }
            }
        }
        List<String> list = new ArrayList<>();
        findLaddersHelper(res, list, graph, beginWord, endWord);
        return res;
    }

    private void findLaddersHelper(List<List<String>> result, List<String> list, Map<String, Set<String>> map,
                                   String word, String endWord) {
        if (word.equals(endWord)) {
            list.add(word);
            result.add(new ArrayList<>(list));
            list.remove(list.size() - 1);
            return;
        }
        list.add(word);
        if (map.containsKey(word)) {
            for (String s : map.get(word)) {
                findLaddersHelper(result, list, map, s, endWord);
            }
        }
        list.remove(list.size() - 1);
    }

    boolean isConnected = false;

    public List<List<String>> findLaddersBiDirection(String beginWord, String endWord, List<String> wordList) {
        Set<String> fwd = new HashSet<>(), bwd = new HashSet<>(), dict = new HashSet<>(wordList);
        fwd.add(beginWord);
        bwd.add(endWord);

        Map<String, List<String>> hs = new HashMap<>();
        findLaddersBiDirectionBfs(fwd, bwd, dict, false, hs);

        List<List<String>> result = new ArrayList<>();
        if (!isConnected)
            return result;

        List<String> temp = new ArrayList<>();
        temp.add(beginWord);

        findLaddersBiDirectionDfs(result, temp, beginWord, endWord, hs);
        return result;
    }

    private void findLaddersBiDirectionBfs(Set<String> forward, Set<String> backward, Set<String> dict, boolean swap,
                                           Map<String, List<String>> hs) {
        if (forward.isEmpty() || backward.isEmpty())
            return;
        if (forward.size() > backward.size()) {
            findLaddersBiDirectionBfs(backward, forward, dict, !swap, hs);
        }
        dict.removeAll(forward);
        dict.removeAll(backward);
        Set<String> set3 = new HashSet<>();

        for (String str : forward) {
            for (int i = 0; i < str.length(); i++) {
                char[] ary = str.toCharArray();
                for (char j = 'a'; j <= 'z'; j++) {
                    ary[i] = j;
                    String temp = new String(ary);
                    if (!backward.contains(temp) && !dict.contains(temp)) {
                        continue;
                    }
                    String key = !swap ? str : temp;
                    String val = !swap ? temp : str;
                    if (!hs.containsKey(key)) {
                        hs.put(key, new ArrayList<>());
                    }
                    if (backward.contains(temp)) {
                        hs.get(key).add(val);
                        isConnected = true;
                    }
                    if (!isConnected && dict.contains(temp)) {
                        hs.get(key).add(val);
                        set3.add(temp);
                    }
                }
            }
        }
        if (!isConnected) {
            findLaddersBiDirectionBfs(set3, backward, dict, swap, hs);
        }
    }

    private void findLaddersBiDirectionDfs(List<List<String>> result, List<String> temp, String start, String end,
                                           Map<String, List<String>> hs) {
        if (start.equals(end)) {
            result.add(new ArrayList<>(temp));
            return;
        }
        if (!hs.containsKey(start))
            return;
        for (String s : hs.get(start)) {
            temp.add(s);
            findLaddersBiDirectionDfs(result, temp, s, end, hs);
            temp.remove(temp.size() - 1);
        }
    }

    public List<List<String>> findLaddersAbc(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> result = new ArrayList<>();
        if (!wordList.contains(endWord))
            return result;
        Set<String> wordDict = new HashSet<>(wordList);
        Map<String, Integer> steps = new HashMap<>();
        Map<String, Set<String>> graph = new HashMap<>();
        steps.put(beginWord, 0);
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        while (!queue.isEmpty()) {
            String word = queue.poll();
            if (word.equals(endWord))
                break;
            int step = steps.get(word) + 1;
            for (int i = 0; i < word.length(); i++) {
                StringBuilder sb = new StringBuilder(word);
                for (char letter = 'a'; letter <= 'z'; letter++) {
                    if (word.charAt(i) == letter)
                        continue;
                    sb.setCharAt(i, letter);
                    String newWord = sb.toString();
                    if (wordDict.contains(newWord) && step <= steps.getOrDefault(newWord, Integer.MAX_VALUE)) {
                        steps.put(newWord, step);
                        queue.offer(newWord);
                        if (!graph.containsKey(word)) {
                            graph.put(word, new HashSet<>());
                        }
                        graph.get(word).add(newWord);
                    }
                }
            }
        }
        List<String> list = new ArrayList<>();
        abcHelper(graph, list, result, beginWord, endWord);
        return result;
    }

    private void abcHelper(Map<String, Set<String>> graph, List<String> list, List<List<String>> result,
                           String beginWord, String endWord) {
        if (beginWord.equals(endWord)) {
            list.add(beginWord);
            result.add(new ArrayList<>(list));
            list.remove(list.size() - 1);
            return;
        }
        list.add(beginWord);
        if (graph.containsKey(beginWord)) {
            for (String word : graph.get(beginWord)) {
                abcHelper(graph, list, result, word, endWord);
            }
        }
        list.remove(list.size() - 1);
    }

    public List<List<String>> findLaddersBiDirectionTwo(String beginWord, String endWord, List<String> wordList) {
        Set<String> beginSet = new HashSet<>();
        Set<String> endSet = new HashSet<>();
        beginSet.add(beginWord);
        endSet.add(endWord);
        Map<String, Set<String>> graph = new HashMap<>();
        Set<String> wordDict = new HashSet<>(wordList);
        findLaddersBiDirectionTwoHelper(wordDict, beginSet, endSet, graph, false);
        List<List<String>> result = new ArrayList<>();
        List<String> list = new ArrayList<>(Arrays.asList(beginWord));
        generateList(beginWord, endWord, graph, list, result);
        return result;
    }

    private boolean findLaddersBiDirectionTwoHelper(Set<String> wordDict, Set<String> beginSet, Set<String> endSet,
                                                    Map<String, Set<String>> graph, boolean flip) {
        if (beginSet.isEmpty())
            return false;
        if (beginSet.size() > endSet.size()) {
            return findLaddersBiDirectionTwoHelper(wordDict, endSet, beginSet, graph, !flip);
        }
        wordDict.removeAll(beginSet);
        wordDict.removeAll(endSet);
        boolean done = false;
        Set<String> temp = new HashSet<>();
        for (String begin : beginSet) {
            for (int i = 0; i < begin.length(); i++) {
                StringBuilder sb = new StringBuilder(begin);
                for (char letter = 'a'; letter <= 'z'; letter++) {
                    sb.setCharAt(i, letter);
                    String newWord = sb.toString();
                    String key = flip ? newWord : begin;
                    String value = flip ? begin : newWord;

                    Set<String> set = graph.containsKey(key) ? graph.get(key) : new HashSet<>();
                    if (endSet.contains(newWord)) {
                        done = true;
                        set.add(value);
                        graph.put(key, set);
                    }
                    if (!done && wordDict.contains(newWord)) {
                        temp.add(newWord);
                        set.add(value);
                        graph.put(key, set);
                    }
                }
            }
        }
        return done || findLaddersBiDirectionTwoHelper(wordDict, endSet, temp, graph, !flip);
    }

    private void generateList(String beginWord, String endWord, Map<String, Set<String>> graph, List<String> list,
                              List<List<String>> result) {
        if (beginWord.equals(endWord)) {
            result.add(new ArrayList<>(list));
            return;
        }
        if (!graph.containsKey(beginWord))
            return;
        for (String word : graph.get(beginWord)) {
            list.add(word);
            generateList(word, endWord, graph, list, result);
            list.remove(list.size() - 1);
        }
    }
}
