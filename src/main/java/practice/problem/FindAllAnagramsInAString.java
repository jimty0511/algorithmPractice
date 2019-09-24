package practice.problem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// 438. Find All Anagrams in a String
public class FindAllAnagramsInAString {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> list = new ArrayList<>();
        if (s == null || s.length() == 0 || p == null || p.length() == 0 || s.length() < p.length()) return list;
//        Map<Character, Integer> map = new HashMap<>();
//        for (char c : p.toCharArray()) {
//            map.put(c, map.getOrDefault(c, 0) + 1);
//        }
//        int counter = map.size();
//        int begin = 0, end = 0;
//
//        while (end < s.length()) {
//            char c = s.charAt(end);
//            if (map.containsKey(c)) {
//                map.put(c, map.get(c) - 1);
//                if (map.get(c) == 0)
//                    counter--;
//            }
//            end++;
//
//            while (counter == 0) {
//                char tempc = s.charAt(begin);
//                if (map.containsKey(tempc)) {
//                    map.put(tempc, map.get(tempc) + 1);
//                    if (map.get(tempc) > 0) {
//                        counter++;
//                    }
//                }
//                if (end - begin == p.length()) {
//                    list.add(begin);
//                }
//                begin++;
//            }
//        }

        int[] hash = new int[128];
        for (char c : p.toCharArray()) {
            hash[c]++;
        }

//        int left = 0, right = 0, count = p.length();
//        while (right < s.length()) {
//            char a = s.charAt(right++);
//
//            if (hash[a]-- >= 1)
//                count--;
//
//            if (count == 0)
//                list.add(left);
//
//            if (right - left == p.length() && hash[s.charAt(left++)]++ >= 0)
//                count++;
//        }

        int start = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            hash[c]--;
            while (hash[c] < 0) {
                char cstart = s.charAt(start);
                hash[cstart]++;
                start++;
            }
            if (i - start + 1 == p.length()) {
                list.add(start);
            }
        }

        return list;
    }

    public List<Integer> findAnagramsTwo(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if (p.length() > s.length()) return result;
        Map<Character, Integer> map = new HashMap<>();
        for (char c : p.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int counter = map.size();
        int begin = 0, end = 0;
        while (end < s.length()) {
            char c = s.charAt(end);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) - 1);
                if (map.get(c) == 0)
                    counter--;
            }
            end++;
            while (counter == 0) {
                char tempc = s.charAt(begin);
                if (map.containsKey(tempc)) {
                    map.put(tempc, map.get(tempc) + 1);
                    if (map.get(tempc) > 0)
                        counter++;
                }
                if (end - begin == p.length()) {
                    result.add(begin);
                }
                begin++;
            }
        }
        return result;
    }

    public List<Integer> findAnagramsThree(String s, String p) {
        List<Integer> res = new ArrayList<>();
        if (s == null || s.length() == 0 || p == null || p.length() == 0)
            return res;
        int[] hash = new int[256];
        for (char c : p.toCharArray())
            hash[c]++;
        int left = 0, right = 0, count = p.length();
        while (right < s.length()) {
            if (hash[s.charAt(right++)]-- >= 1)
                count--;
            if (count == 0)
                res.add(left);
            if (right - left == p.length() && hash[s.charAt(left++)]++ >= 0)
                count++;
        }
        return res;
    }
}
