package practice.problem;

import java.util.*;

// 692. Top K Frequent Words
public class TopKFrequentWords {
    public List<String> topKFrequent(String[] words, int k) {
        List<String> result = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        for (String w : words) {
            map.put(w, map.getOrDefault(w, 0) + 1);
        }

//        List<Map.Entry<String, Integer>> entryList = map.entrySet().stream().sorted((a, b) -> a.getValue() == b.getValue() ?
//                b.getKey().compareTo(a.getKey()) : a.getValue() - b.getValue())
//                .collect(Collectors.toList());
//
//        if (entryList.size() > k)
//            entryList = entryList.subList(entryList.size() - k, entryList.size());
//
//        for (Map.Entry<String, Integer> entry : entryList) {
//            result.add(0, entry.getKey());
//        }

        PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>(
                (a, b) -> a.getValue() == b.getValue() ? b.getKey().compareTo(a.getKey()) : a.getValue() - b.getValue()
        );

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            pq.offer(entry);
            if (pq.size() > k)
                pq.poll();
        }

        while (!pq.isEmpty())
            result.add(0, pq.poll().getKey());

        return result;
    }

    public List<String> topKFrequentBucketSort(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        int max = 0;
        for (String w : words) {
            map.put(w, map.getOrDefault(w, 0) + 1);
            max = Math.max(max, map.get(w));
        }
        List<String>[] bucket = new List[max + 1];
        for (String key : map.keySet()) {
            int freq = map.get(key);
            if (bucket[freq] == null)
                bucket[freq] = new ArrayList<>();
            bucket[freq].add(key);
        }
        List<String> res = new ArrayList<>();
        for (int i = max; i >= 0 && k >= 0; i--) {
            if (bucket[i] != null) {
                Collections.sort(bucket[i]);
                List<String> temp = bucket[i].subList(0, Math.min(bucket[i].size(), k));
                res.addAll(temp);
                k -= bucket[i].size();
            }
        }
        return res;
    }
}
