package practice.lcdesign;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

// 554. Sort Integers (Map Reduce)
// Chapter 9
public class SortIntegers {

    static class Element {
        int row, col, val;

        public Element(int row, int col, int val) {
            this.row = row;
            this.col = col;
            this.val = val;
        }
    }

    public static class Map {
        public void map(int _, List<Integer> value,
                        OutputCollector<String, List<Integer>> output) {
            // Write your code here
            // Output the results into output buffer.
            // Ps. output.collect(String key, List<Integer> value);
            Collections.sort(value);
            output.collect("", value);
        }
    }

    public static class Reduce {
        public void reduce(String key, List<List<Integer>> values,
                           OutputCollector<String, List<Integer>> output) {
            // Write your code here
            // Output the results into output buffer.
            // Ps. output.collect(String key, List<Integer> value);
            List<Integer> res = new ArrayList<>();
            if (values.size() == 0) {
                output.collect(key, res);
                return;
            }
            int size = 0;
            PriorityQueue<Element> pq = new PriorityQueue<>((a, b) -> a.val - b.val);
            int k = values.size();
            for (int i = 0; i < k; i++) {
                if (values.get(i).size() > 0) {
                    Element element = new Element(i, 0, values.get(i).get(0));
                    pq.offer(element);
                }
            }
            while (!pq.isEmpty()) {
                Element element = pq.poll();
                res.add(element.val);
                if (element.col + 1 < values.get(element.row).size()) {
                    element.col += 1;
                    element.val = values.get(element.row).get(element.col);
                    pq.offer(element);
                }
            }
            output.collect(key, res);
        }
    }
}
