package practice.problem;

import java.util.*;

// 127. Word Ladder
public class WordLadder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord))
            return 0;
        Set<String> reached = new HashSet<>(), wordDict = new HashSet<>(wordList);
        reached.add(beginWord);
        int distance = 1;
        while (!reached.contains(endWord)) {
            Set<String> toAdd = new HashSet<>();
            for (String each : reached) {
                for (int i = 0; i < each.length(); i++) {
                    char[] chars = each.toCharArray();
                    for (char ch = 'a'; ch <= 'z'; ch++) {
                        chars[i] = ch;
                        String word = new String(chars);
                        if (wordDict.contains(word)) {
                            toAdd.add(word);
                            wordDict.remove(word);
                        }
                    }
                }
            }
            distance++;
            if (toAdd.size() == 0)
                return 0;
            reached = toAdd;
        }
        return distance;
    }

    public int ladderLengthTwoPointer(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord))
            return 0;
        if (wordList.size() == 2) {
            Set<Character> set = new HashSet<>();
            for (String w : wordList) {
                for (char c : w.toCharArray()) {
                    set.add(c);
                }
            }
            if (set.size() > 4)
                return 0;
        }
        Set<String> dict = new HashSet<>(wordList), visited = new HashSet<>(),
                beginSet = new HashSet<>(), endSet = new HashSet<>();
        beginSet.add(beginWord);
        endSet.add(endWord);
        int step = 1;
        while (!beginSet.isEmpty() && !endSet.isEmpty()) {
            if (beginSet.size() > endSet.size()) {
                Set<String> set = beginSet;
                beginSet = endSet;
                endSet = set;
            }
            Set<String> temp = new HashSet<>();
            for (String word : beginSet) {
                char[] chars = word.toCharArray();
                for (int i = 0; i < chars.length; i++) {
                    for (char c = 'a'; c <= 'z'; c++) {
                        char old = chars[i];
                        chars[i] = c;
                        String target = String.valueOf(chars);
                        if (endSet.contains(target)) {
                            return step + 1;
                        }
                        if (!visited.contains(target) && dict.contains(target)) {
                            temp.add(target);
                            visited.add(target);
                        }
                        chars[i] = old;
                    }
                }
            }
            beginSet = temp;
            step++;
        }
        return step;
    }

    public int ladderLengthQueue(String beginWord, String endWord, List<String> wordList) {
//        if (!wordList.contains(endWord))
//            return 0;
        Queue<String> queue = new LinkedList<>();
        Set<String> wordDict = new HashSet<>(wordList);
        int step = 1;
        queue.offer(beginWord);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String curr = queue.poll();
                if (curr.equals(endWord)) {
                    return step;
                }
                for (int j = 0; j < curr.length(); j++) {
                    StringBuilder newWord = new StringBuilder(curr);
                    for (char letter = 'a'; letter <= 'z'; letter++) {
                        newWord.setCharAt(j, letter);
                        if (wordDict.contains(newWord.toString())) {
                            wordDict.remove(newWord.toString());
                            queue.offer(newWord.toString());
                        }
                    }
                }
            }
            step++;
        }
        return 0;
    }

    public int lc(String start, String end, Set<String> dict) {
        if (dict == null)
            return 0;
        if (start.equals(end))
            return 1;
        dict.add(start);
        dict.add(end);
        HashSet<String> hash = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.offer(start);
        hash.add(start);
        int length = 1;
        while (!queue.isEmpty()) {            //开始bfs
            length++;
            int size = queue.size();        //当前步数的队列大小
            for (int i = 0; i < size; i++) {
                String word = queue.poll();
                for (String nextWord : getNextWords(word, dict)) {    //得到新单词
                    if (hash.contains(nextWord)) {
                        continue;
                    }
                    if (nextWord.equals(end)) {
                        return length;
                    }
                    hash.add(nextWord);
                    queue.offer(nextWord);            //存入队列继续搜索
                }
            }
        }
        return 0;
    }

    // replace character of a string at given index to a given character
    // return a new string
    private String replace(String s, int index, char c) {
        char[] chars = s.toCharArray();
        chars[index] = c;
        return new String(chars);
    }

    private List<String> getNextWords(String word, Set<String> dict) {
        List<String> nextWords = new ArrayList<>();
        for (char c = 'a'; c <= 'z'; c++) {                    //枚举当前替换字母
            for (int i = 0; i < word.length(); i++) {        //枚举替换位置
                if (c == word.charAt(i)) {
                    continue;
                }
                String nextWord = replace(word, i, c);
                if (dict.contains(nextWord)) {        //如果dict中包含新单词，存入nextWords
                    nextWords.add(nextWord);
                }
            }
        }
        return nextWords;                            //构造当前单词的全部下一步方案
    }
}
