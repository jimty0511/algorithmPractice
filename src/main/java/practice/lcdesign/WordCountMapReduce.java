package practice.lcdesign;

import java.util.Iterator;
import java.util.StringTokenizer;

// 499. Word Count (Map Reduce)
// Chapter 9
public class WordCountMapReduce {
    public static class Map {
        public void map(String key, String value, OutputCollector<String, Integer> output) {
            // Write your code here
            // Output the results into output buffer.
            // Ps. output.collect(String key, int value);
            StringTokenizer stringTokenizer = new StringTokenizer(value);
            while (stringTokenizer.hasMoreTokens()) {
                String word = stringTokenizer.nextToken();
                output.collect(word, 1);
            }
        }
    }

    public static class Reduce {
        public void reduce(String key, Iterator<Integer> values,
                           OutputCollector<String, Integer> output) {
            // Write your code here
            // Output the results into output buffer.
            // Ps. output.collect(String key, int value);
            int sum = 0;
            while (values.hasNext())
                sum += values.next();
            output.collect(key, sum);
        }
    }
}
