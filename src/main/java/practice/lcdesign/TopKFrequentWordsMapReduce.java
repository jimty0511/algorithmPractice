package practice.lcdesign;

import java.util.*;

// 549. Top K Frequent Words (Map Reduce)
// Chapter 9
public class TopKFrequentWordsMapReduce {

    class Document {
        public int id;
        public String content;
    }

    static class Pair {
        String key;
        int value;

        public Pair(String key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    public static class Map {
        public void map(String _, Document value,
                        OutputCollector<String, Integer> output) {
            // Write your code here
            // Output the results into output buffer.
            // Ps. output.collect(String key, int value);
            int id = value.id;
            String content = value.content;
            String[] words = content.split(" ");
            for (String w : words) {
                if (w.length() > 0)
                    output.collect(w, 1);
            }
        }
    }

    public static class Reduce {

        PriorityQueue<Pair> pq;
        int k;

        private Comparator<Pair> pairComparator = new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                if (o1.value != o2.value)
                    return o1.value - o2.value;
                return o2.key.compareTo(o1.key);
            }
        };

        public void setup(int k) {
            // initialize your data structure here
            this.k = k;
            pq = new PriorityQueue<>(k, pairComparator);
        }

        public void reduce(String key, Iterator<Integer> values) {
            // Write your code here
            int sum = 0;
            while (values.hasNext())
                sum += values.next();
            Pair pair = new Pair(key, sum);
            if (pq.size() < k)
                pq.offer(pair);
            else {
                Pair peek = pq.peek();
                if (pairComparator.compare(pair, peek) > 0) {
                    pq.poll();
                    pq.offer(pair);
                }
            }
        }

        public void cleanup(OutputCollector<String, Integer> output) {
            // Output the top k pairs <word, times> into output buffer.
            // Ps. output.collect(String key, Integer value);
            List<Pair> pairs = new ArrayList<>();
            while (!pq.isEmpty())
                pairs.add(pq.poll());
            int n = pairs.size();
            for (int i = n - 1; i >= 0; i--) {
                Pair pair = pairs.get(i);
                output.collect(pair.key, pair.value);
            }
        }
    }
}
