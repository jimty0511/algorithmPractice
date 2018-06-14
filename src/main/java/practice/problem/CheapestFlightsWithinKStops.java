package practice.problem;

import java.util.*;

// 787. Cheapest Flights Within K Stops
public class CheapestFlightsWithinKStops {
    private class City implements Comparable<City> {
        int id, costFromSrc, stopFromSrc;

        public City(int id, int costFromSrc, int stopFromSrc) {
            this.id = id;
            this.costFromSrc = costFromSrc;
            this.stopFromSrc = stopFromSrc;
        }

        public boolean equals(City c) {
            if (c instanceof City) {
                return this.id == c.id;
            }
            return false;
        }

        @Override
        public int compareTo(City o) {
            return this.costFromSrc - o.costFromSrc;
        }
    }

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        int[][] srcToDst = new int[n][n];
        for (int i = 0; i < flights.length; i++) {
            srcToDst[flights[i][0]][flights[i][1]] = flights[i][2];
        }

        PriorityQueue<City> minHeap = new PriorityQueue<>();
        minHeap.offer(new City(src, 0, 0));
        int[] cost = new int[n];
        Arrays.fill(cost, Integer.MAX_VALUE);
        cost[src] = 0;
        int[] stop = new int[n];
        Arrays.fill(stop, Integer.MAX_VALUE);
        stop[src] = 0;

        while (!minHeap.isEmpty()) {
            City curCity = minHeap.poll();
            if (curCity.id == dst)
                continue;
            if (curCity.stopFromSrc == K + 1)
                continue;
            int[] nexts = srcToDst[curCity.id];
            for (int i = 0; i < n; i++) {
                if (nexts[i] != 0) {
                    int newCost = curCity.costFromSrc + nexts[i];
                    int newStop = curCity.stopFromSrc + 1;
                    if (newCost < cost[i]) {
                        minHeap.offer(new City(i, newCost, newStop));
                        cost[i] = newCost;
                    }
                    if (newStop < stop[i]) {
                        minHeap.offer(new City(i, newCost, newStop));
                        stop[i] = newStop;
                    }
                }
            }
        }
        return cost[dst] == Integer.MAX_VALUE ? -1 : cost[dst];
    }

    public int findCheapestPriceTwo(int n, int[][] flights, int src, int dst, int K) {
        Map<Integer, Map<Integer, Integer>> prices = new HashMap<>();
        for (int[] f : flights) {
            if (!prices.containsKey(f[0]))
                prices.put(f[0], new HashMap<>());
            prices.get(f[0]).put(f[1], f[2]);
        }
        Queue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        pq.add(new int[]{0, src, K + 1});
        while (!pq.isEmpty()) {
            int[] top = pq.remove();
            int price = top[0];
            int city = top[1];
            int stops = top[2];
            if (city == dst)
                return price;
            if (stops > 0) {
                Map<Integer, Integer> adj = prices.getOrDefault(city, new HashMap<>());
                for (int a : adj.keySet()) {
                    pq.add(new int[]{price + adj.get(a), a, stops - 1});
                }
            }
        }
        return -1;
    }
}
