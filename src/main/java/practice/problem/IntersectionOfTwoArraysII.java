package practice.problem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 350. Intersection of Two Arrays II
public class IntersectionOfTwoArraysII {
    public int[] intersect(int[] nums1, int[] nums2) {
//        Map<Integer, Integer> map = new HashMap<>();
//        List<Integer> res = new ArrayList<>();
//        for (int i = 0; i < nums1.length; i++) {
//            map.put(nums1[i], map.getOrDefault(nums1[i], 0) + 1);
//        }
//        for (int i = 0; i < nums2.length; i++) {
//            if (map.containsKey(nums2[i]) && map.get(nums2[i]) > 0) {
//                res.add(nums2[i]);
//                map.put(nums2[i], map.get(nums2[i]) - 1);
//            }
//        }
//
//        int[] result = res.stream().mapToInt(i -> i).toArray();
//        return result;

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
}
