package practice.lcdesign;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;

// 504. Inverted Index (Map Reduce)
// Chapter 9
public class InvertedIndexMapReduce {

    class Document {
        public int id;
        public String content;
    }

    public static class Map {
        public void map(String _, Document value,
                        OutputCollector<String, Integer> output) {
            // Write your code here
            // Output the results into output buffer.
            // Ps. output.collect(String key, int value);
            int id = value.id;
            StringTokenizer stringTokenizer = new StringTokenizer(value.content);
            while (stringTokenizer.hasMoreTokens()) {
                String word = stringTokenizer.nextToken();
                output.collect(word, id);
            }
        }
    }

    public static class Reduce {
        public void reduce(String key, Iterator<Integer> values,
                           OutputCollector<String, List<Integer>> output) {
            // Write your code here
            // Output the results into output buffer.
            // Ps. output.collect(String key, List<Integer> value);
            List<Integer> res = new ArrayList<>();
            int prev = -1;
            while (values.hasNext()) {
                int now = values.next();
                if (prev != now)
                    res.add(now);
                prev = now;
            }
            output.collect(key, res);
        }
    }
}
