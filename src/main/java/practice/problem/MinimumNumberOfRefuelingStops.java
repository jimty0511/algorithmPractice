package practice.problem;

import java.util.Comparator;
import java.util.PriorityQueue;

// 871. Minimum Number of Refueling Stops
public class MinimumNumberOfRefuelingStops {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder()); // decreasing
        int i = 0, res;
        for (res = 0; startFuel < target; res++) {
            while (i < stations.length && stations[i][0] <= startFuel)
                pq.offer(stations[i++][1]);
            if (pq.isEmpty())
                return -1;
            startFuel += pq.poll();
        }
        return res;
    }

    public int minRefuelStopsTwo(int target, int startFuel, int[][] stations) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int i = 0, res = 0;
        while (true) {
            while (i < stations.length && stations[i][0] <= startFuel) {
                pq.offer(-stations[i][1]);
                i++;
            }
            if (startFuel >= target)
                return res;
            if (pq.isEmpty())
                return -1;
            startFuel += -pq.poll();
            res++;
        }
    }
}
