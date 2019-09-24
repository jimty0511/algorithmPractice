package practice.problem;

import java.util.*;

// 347. Top K Frequent Elements
public class TopKFrequentElements {
    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer>[] bucket = new List[nums.length + 1];
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        for (int key : map.keySet()) {
            int freq = map.get(key);
            if (bucket[freq] == null)
                bucket[freq] = new ArrayList<>();
            bucket[freq].add(key);
        }
        List<Integer> res = new ArrayList<>();
//        for (int pos = bucket.length - 1; pos >= 0 && res.size() < k; pos--) {
//            if (bucket[pos] != null)
//                res.addAll(bucket[pos]);
//        }
        for (int i = bucket.length - 1; i >= 0; i--) {
            if (bucket[i] != null) {
                for (int j = 0; j < Math.min(bucket[i].size(), k); j++) {
                    res.add(bucket[i].get(j));
                }
                k -= bucket[i].size();
            }
        }
        return res;
    }

    public List<Integer> topKFrequentTwo(int[] nums, int k) {
        if (nums.length == 1)
            return Arrays.asList(nums[0]);

        List<Integer> result = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();

        Arrays.stream(nums).forEach(x -> map.put(x, map.getOrDefault(x, 0) + 1));

        PriorityQueue<Map.Entry<Integer, Integer>> max = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            max.add(entry);
        }

        while (result.size() < k) {
            Map.Entry<Integer, Integer> entry = max.poll();
            result.add(entry.getKey());
        }
        return result;
    }

    public List<Integer> topKFrequentTwoMinHeap(int[] nums, int k) {
        if (nums.length == 1)
            return Arrays.asList(nums[0]);

        List<Integer> result = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();

        Arrays.stream(nums).forEach(x -> map.put(x, map.getOrDefault(x, 0) + 1));

        PriorityQueue<Map.Entry<Integer, Integer>> max = new PriorityQueue<>((a, b) -> a.getValue() - b.getValue());
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            max.add(entry);
            if (max.size() > k)
                max.poll();
        }

        while (!max.isEmpty()) {
            Map.Entry<Integer, Integer> entry = max.poll();
            result.add(entry.getKey());
        }
        return result;
    }
}
