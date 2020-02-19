package practice.lintcode;

import java.util.PriorityQueue;

// 959. K Spaced Array Sorting
public class KSpacedArraySorting {

    class Pair {
        int value;
        int idx;

        public Pair(int value, int idx) {
            this.value = value;
            this.idx = idx;
        }
    }

    /**
     * @param arr: The K spaced array
     * @param k:   The param k
     * @return: Return the sorted array
     */
    public int[] getSortedArray(int[] arr, int k) {
        // Write your code here
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.value == b.value ? a.idx - b.idx : a.value - b.value);
        int[] ans = new int[arr.length];
        for (int i = 0; i < k; i++) {
            pq.offer(new Pair(arr[i], i));
        }
        int idx = 0;
        while (!pq.isEmpty()) {
            Pair cur = pq.poll();
            ans[idx++] = cur.value;
            if (cur.idx + k < arr.length)
                pq.offer(new Pair(arr[cur.idx + k], cur.idx + k));
        }
        return ans;
    }
}
