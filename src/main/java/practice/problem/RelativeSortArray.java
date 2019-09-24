package practice.problem;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

// 1122. Relative Sort Array
public class RelativeSortArray {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] cnt = new int[1001];
        for (int n : arr1)
            cnt[n]++;
        int i = 0;
        for (int n : arr2) {
            while (cnt[n]-- > 0)
                arr1[i++] = n;
        }
        for (int n = 0; n < cnt.length; n++) {
            while (cnt[n]-- > 0)
                arr1[i++] = n;
        }
        return arr1;
    }

    public int[] relativeSortArrayMap(int[] arr1, int[] arr2) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int a : arr1) {
            map.put(a, map.getOrDefault(a, 0) + 1);
        }
        int i = 0;
        for (int n : arr2) {
            while (map.get(n) > 0) {
                arr1[i++] = n;
                map.put(n, map.get(n) - 1);
            }
        }
        for (int key : map.keySet()) {
            while (map.get(key) > 0) {
                arr1[i++] = key;
                map.put(key, map.get(key) - 1);
            }
        }
        return arr1;
    }
}
