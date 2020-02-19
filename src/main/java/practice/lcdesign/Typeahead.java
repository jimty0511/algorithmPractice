package practice.lcdesign;

import java.util.*;

// 231. Typeahead
// Chapter 10
public class Typeahead {

    Map<String, List<String>> map = new HashMap<>();

    /*
     * @param dict: A dictionary of words dict
     */
    public Typeahead(Set<String> dict) {
        // do intialization if necessary
        for (String d : dict) {
            int len = d.length();
            for (int i = 0; i < len; i++) {
                for (int j = i + 1; j <= len; j++) {
                    String tmp = d.substring(i, j);
                    if (!map.containsKey(tmp)) {
                        map.put(tmp, new ArrayList<>());
                        map.get(tmp).add(d);
                    } else {
                        List<String> list = map.get(tmp);
                        if (!d.equals(list.get(list.size() - 1)))
                            list.add(d);
                    }
                }
            }
        }
    }

    /*
     * @param str: a string
     * @return: a list of words
     */
    public List<String> search(String str) {
        // write your code here
        if (!map.containsKey(str))
            return new ArrayList<>();
        else
            return map.get(str);
    }
}
