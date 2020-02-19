package practice.lcdesign;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// 500. Inverted Index
// Chapter 10
public class InvertedIndex {

    class Document {
        public int id;
        public String content;
    }

    /**
     * @param docs a list of documents
     * @return an inverted index
     */
    public Map<String, List<Integer>> invertedIndex(List<Document> docs) {
        // Write your code here
        Map<String, List<Integer>> res = new HashMap<>();
        for (Document d : docs) {
            int id = d.id;
            String content = d.content;
            StringBuilder sb = new StringBuilder();
            int n = content.length();
            for (char c : content.toCharArray()) {
                if (c == ' ') {
                    insert(res, sb.toString(), id);
                    sb.setLength(0);
                } else
                    sb.append(c);
            }
            insert(res, sb.toString(), id);
        }
        return res;
    }

    private void insert(Map<String, List<Integer>> res, String s, int id) {
        if (s == null || s.isEmpty())
            return;
        res.putIfAbsent(s, new ArrayList<>());
        int n = res.get(s).size();
        if (n == 0 || res.get(s).get(n - 1) != id)
            res.get(s).add(id);
    }
}
