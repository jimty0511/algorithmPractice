package practice.problem;

import java.util.*;

// 218. The Skyline Problem
public class TheSkylineProblem {
    public List<int[]> getSkyline(int[][] buildings) {
        List<int[]> height = new ArrayList<>();
        for (int[] b : buildings) {
            height.add(new int[]{b[0], -b[2]});
            height.add(new int[]{b[1], b[2]});
        }
        Collections.sort(height, (a, b) -> a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]);

        Queue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        pq.offer(0);
        int pre = 0;

        List<int[]> result = new ArrayList<>();
        for (int[] h : height) {
            if (h[1] < 0) {
                pq.offer(-h[1]);
            } else {
                pq.remove(h[1]);
            }
            int cur = pq.peek();
            if (pre != cur) {
                result.add(new int[]{h[0], cur});
                pre = cur;
            }
        }
        return result;
    }

    public List<int[]> getSkylineTreeMap(int[][] buildings) {
        List<int[]> height = new ArrayList<>();
        for (int[] b : buildings) {
            height.add(new int[]{b[0], -b[2]});
            height.add(new int[]{b[1], b[2]});
        }
        Collections.sort(height, (a, b) -> a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]);

        TreeMap<Integer, Integer> pq = new TreeMap<>();
        pq.put(0, 1);
        int pre = 0;

        List<int[]> result = new ArrayList<>();
        for (int[] h : height) {
            if (h[1] < 0) {
                pq.put(-h[1], pq.getOrDefault(-h[1], 0) + 1);
            } else {
                if (pq.get(h[1]) > 1) {
                    pq.put(h[1], pq.get(h[1]) - 1);
                } else {
                    pq.remove(h[1]);
                }
            }
            int cur = pq.lastKey();
            if (pre != cur) {
                result.add(new int[]{h[0], cur});
                pre = cur;
            }
        }
        return result;
    }

    public List<List<Integer>> getSkylineLC(int[][] buildings) {
        List<List<Integer>> result = new ArrayList<>();
        if (buildings == null || buildings.length == 0)
            return result;
        List<int[]> height = new ArrayList<>();
        for (int[] b : buildings) {
            height.add(new int[]{b[0], -b[2]});
            height.add(new int[]{b[1], b[2]});
        }
        Collections.sort(height, (a, b) -> a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]);

        Queue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        pq.offer(0);
        int preH = -height.get(0)[1], preIdx = height.get(0)[0];

        for (int[] h : height) {
            if (h[1] < 0) {
                pq.offer(-h[1]);
            } else {
                pq.remove(h[1]);
            }
            int curH = pq.peek();
            if (preH != curH) {
                if (preH != 0)
                    result.add(Arrays.asList(preIdx, h[0], preH));
                preH = curH;
                preIdx = h[0];
            }
        }
        return result;
    }
}
