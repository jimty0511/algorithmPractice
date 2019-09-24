package practice.lintcode;

import java.util.*;

// 550. Top K Frequent Words II
public class TopKFrequentWordsII {

    private Map<String, Integer> map;
    private TreeSet<String> set;
    private int k;

    /*
     * @param k: An integer
     */
    public TopKFrequentWordsII(int k) {
        // do intialization if necessary
        this.k = k;
        map = new HashMap<>();
        set = new TreeSet<>((a, b) -> map.get(a) == map.get(b) ? a.compareTo(b) : map.get(b) - map.get(a));
    }

    /*
     * @param word: A string
     * @return: nothing
     */
    public void add(String word) {
        // write your code here
        if (map.containsKey(word)) {
            if (set.contains(word))
                set.remove(word);
            map.put(word, map.get(word) + 1);
        } else {
            map.put(word, 1);
        }
        set.add(word);
        if (set.size() > k)
            set.pollLast();
    }

    /*
     * @return: the current top k frequent words.
     */
    public List<String> topk() {
        // write your code here
        List<String> res = new ArrayList<>();
        Iterator<String> it = set.iterator();
        while (it.hasNext())
            res.add(it.next());
        return res;
    }
}
