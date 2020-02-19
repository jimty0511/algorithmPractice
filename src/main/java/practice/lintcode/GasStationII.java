package practice.lintcode;

import java.util.Collections;
import java.util.PriorityQueue;

// 1408. Gas Station II
// Microsoft ladder
public class GasStationII {
    /**
     * @param target:   The target distance
     * @param original: The original gas
     * @param distance: The distance array
     * @param apply:    The apply array
     * @return: Return the minimum times
     */
    public int getTimes(int target, int original, int[] distance, int[] apply) {
        // Write your code here
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int res = 0, i = 0;
        while (original < target) {
            while (distance[i] <= original) {
                pq.offer(apply[i]);
                i++;
            }
            if (pq.size() == 0)
                break;
            original += pq.poll();
            res++;
        }
        return original >= target ? res : -1;
    }
}
