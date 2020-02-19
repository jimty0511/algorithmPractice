package practice.lintcode;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class MergeKSortedArray {
    public int[] mergekSortedArrays(int[][] arrays) {
        // write your code here
        return partition(arrays, 0, arrays.length - 1);
    }

    private int[] partition(int[][] arrays, int s, int e) {
        if (s == e)
            return arrays[s];
        if (s < e) {
            int mid = s + (e - s) / 2;
            int[] nums1 = partition(arrays, s, mid);
            int[] nums2 = partition(arrays, mid + 1, e);
            return merge(nums1, nums2);
        } else
            return null;
    }

    private int[] merge(int[] nums1, int[] nums2) {
        if (nums1 == null)
            return nums2;
        if (nums2 == null)
            return nums1;
        int m = nums1.length, n = nums2.length, i = 0, j = 0, idx = 0;
        int[] res = new int[m + n];
        while (i < m && j < n) {
            if (nums1[i] < nums2[j]) {
                res[idx++] = nums1[i++];
            } else {
                res[idx++] = nums2[j++];
            }
        }
        while (i < m)
            res[idx++] = nums1[i++];
        while (j < n)
            res[idx++] = nums2[j++];
        return res;
    }

    class Element {
        int row, col, val;

        public Element(int row, int col, int val) {
            this.row = row;
            this.col = col;
            this.val = val;
        }
    }

    public int[] mergekSortedArraysTwo(int[][] arrays) {
        if (arrays == null || arrays.length == 0)
            return new int[0];
        List<Integer> res = new ArrayList<>();
        PriorityQueue<Element> pq = new PriorityQueue<>((a, b) -> a.val - b.val);
        int m = arrays.length, n = arrays[0].length;
        for (int i = 0; i < m; i++) {
            pq.offer(new Element(i, 0, arrays[i][0]));
        }
        while (!pq.isEmpty()) {
            Element cur = pq.poll();
            res.add(cur.val);
            int row = cur.row, col = cur.col;
            if (col < arrays[row].length - 1)
                pq.offer(new Element(row, col + 1, arrays[row][col + 1]));
        }
        return res.stream().mapToInt(i -> i).toArray();
    }
}
