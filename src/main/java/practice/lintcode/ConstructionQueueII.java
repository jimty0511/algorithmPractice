package practice.lintcode;

import java.util.*;

// 1766. Construction Queue II
public class ConstructionQueueII {
    /**
     * @param arr1: The size
     * @param arr2: How many numbers bigger than itself
     * @return: The correct array
     */
    public int[] getQueue(int[] arr1, int[] arr2) {
        // Write your code here
        int len = arr1.length;
        int[] res = new int[len];
        List<Integer> list = new ArrayList<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] != b[0] ? b[0] - a[0] : a[1] - b[1]);
        for (int i = 0; i < len; i++) {
            pq.offer(new int[]{arr1[i], arr2[i]});
        }
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            list.add(cur[1], cur[0]);
        }
        int i = 0;
        while (i < len) {
            res[i] = list.get(i);
            i++;
        }
        return res;
    }

    public int[] getQueueTwo(int[] arr1, int[] arr2) {
        int[][] newArr = new int[arr1.length][2];
        for (int i = 0; i < arr1.length; i++) {
            newArr[i] = new int[]{arr1[i], arr2[i]};
        }
        Arrays.sort(newArr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] != o2[0] ? Integer.compare(o2[0], o1[0]) : Integer.compare(o1[1], o2[1]);
            }
        });
        List<int[]> list = new ArrayList<>();
        for (int[] p : newArr) {
            list.add(p[1], p);
        }
        int[] res = new int[arr1.length];
        int idx = 0;
        for (int[] l : list)
            res[idx++] = l[0];
        return res;
    }
}
