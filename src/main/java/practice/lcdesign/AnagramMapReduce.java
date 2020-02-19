package practice.lcdesign;

import java.util.*;

// 503. Anagram (Map Reduce)
// Chapter 9
public class AnagramMapReduce {
    public static class Map {
        public void map(String key, String value,
                        OutputCollector<String, String> output) {
            // Write your code here
            // Output the results into output buffer.
            // Ps. output.collect(String key, String value);
            StringTokenizer stringTokenizer = new StringTokenizer(value);
            while (stringTokenizer.hasMoreTokens()) {
                String word = stringTokenizer.nextToken();
                String ori = word;
                char[] chars = ori.toCharArray();
                Arrays.sort(chars);
                String sorted = new String(chars);
                output.collect(sorted, word);
            }
        }
    }

    public static class Reduce {
        public void reduce(String key, Iterator<String> values,
                           OutputCollector<String, List<String>> output) {
            // Write your code here
            // Output the results into output buffer.
            // Ps. output.collect(String key, List<String> value);
            List<String> res = new ArrayList<>();
            while (values.hasNext())
                res.add(values.next());
            output.collect(key, res);
        }
    }
}
