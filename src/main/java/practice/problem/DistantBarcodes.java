package practice.problem;

import java.util.*;

// 1054. Distant Barcodes
public class DistantBarcodes {
    public int[] rearrangeBarcodes(int[] barcodes) {
        if (barcodes == null || barcodes.length == 0)
            return new int[0];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : barcodes)
            map.put(i, map.getOrDefault(i, 0) + 1);
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(
                (a, b) -> a.getValue() == b.getValue() ? a.getKey() - b.getKey() : b.getValue() - a.getValue());
        pq.addAll(map.entrySet());
        int[] res = new int[barcodes.length];
        int i = 0;
        while (!pq.isEmpty()) {
            int k = 2;
            List<Map.Entry<Integer, Integer>> tmp = new ArrayList<>();
            while (k > 0 && !pq.isEmpty()) {
                Map.Entry<Integer, Integer> entry = pq.poll();
                entry.setValue(entry.getValue() - 1);
                res[i++] = entry.getKey();
                tmp.add(entry);
                k--;
            }
            for (Map.Entry<Integer, Integer> e : tmp) {
                if (e.getValue() > 0)
                    pq.offer(e);
            }
            if (pq.isEmpty())
                break;
        }
        return res;
    }
}
