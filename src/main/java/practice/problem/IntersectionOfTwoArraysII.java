package practice.problem;

import java.util.*;

// 350. Intersection of Two Arrays II
public class IntersectionOfTwoArraysII {
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int n1 = 0, n2 = 0;
        List<Integer> list = new ArrayList<>();
        while (n1 < nums1.length && n2 < nums2.length) {
            if (nums1[n1] < nums2[n2]) {
                n1++;
            } else if (nums1[n1] > nums2[n2]) {
                n2++;
            } else {
                list.add(nums1[n1]);
                n1++;
                n2++;
            }
        }
        int[] result = list.stream().mapToInt(i -> i).toArray();
        return result;
    }

    public int[] intersectOn(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> res = new ArrayList<>();
        for (int n : nums1) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        for (int n : nums2) {
            if (map.containsKey(n) && map.get(n) > 0) {
                res.add(n);
                map.put(n, map.get(n) - 1);
            }
        }
        return res.stream().mapToInt(i -> i).toArray();
    }
}
