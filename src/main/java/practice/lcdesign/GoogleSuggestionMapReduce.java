package practice.lcdesign;

import java.util.*;

// 1787. Google Suggestion (Map Reduce)
// Chapter 10
public class GoogleSuggestionMapReduce {

    class Document {
        public int count;
        public String content;
    }

    static class Pair {
        private String content;
        private int count;

        public Pair(String key, int value) {
            this.content = key;
            this.count = value;
        }

        public String getContent() {
            return this.content;
        }

        public int getCount() {
            return this.count;
        }

    }

    public static class Map {
        public void map(Document value,
                        OutputCollector<String, Pair> output) {
            // Write your code here
            // Output the results into output buffer.
            // Ps. output.collect(String key, Pair value);
            String content = value.content;
            String words = "";
            Pair valuePair = new Pair(content, value.count);
            for (int i = 0; i < content.length(); i++) {
                words += content.charAt(i);
                output.collect(words, valuePair);
            }
        }
    }

    public static class Reduce {
        public void setup() {
            // initialize your data structure here
        }

        private Comparator<Pair> pairComparator = new Comparator<Pair>() {
            public int compare(Pair left, Pair right) {
                if (left.getCount() != right.getCount()) {
                    return left.getCount() - right.getCount();
                }
                return right.getContent().compareTo(left.getContent());
            }
        };

        public void reduce(String key, Iterator<Pair> values, OutputCollector<String, Pair> output) {
            // Write your code here
            // Output the results into output buffer.
            // Ps. output.collect(String key, Pair value);
            PriorityQueue<Pair> pq = new PriorityQueue<>(pairComparator);
            List<Pair> list = new ArrayList<>();
            while (values.hasNext()) {
                pq.offer(values.next());
                if (pq.size() > 10)
                    pq.poll();
            }
            while (!pq.isEmpty())
                list.add(pq.poll());
            int n = list.size();
            for (int i = n - 1; i >= 0; i--) {
                output.collect(key, list.get(i));
            }
        }
    }
}
