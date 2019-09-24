package practice.problem;

import java.util.*;

// 760. Find Anagram Mappings
public class FindAnagramMappings {
    public int[] anagramMappings(int[] A, int[] B) {
        int[] result = new int[A.length];
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < B.length; i++) {
            map.computeIfAbsent(B[i], k -> new LinkedList<>()).add(i);
        }
        for (int i = 0; i < A.length; i++) {
            result[i] = map.get(A[i]).remove(map.get(A[i]).size() - 1);
        }
        return result;
    }

    public int[] anagramMappingsTwo(int[] A, int[] B) {
        int[] result = new int[A.length];
        Map<Integer, Stack<Integer>> map = new HashMap<>();
        for (int i = 0; i < B.length; i++) {
            map.computeIfAbsent(B[i], k -> new Stack<>()).push(i);
        }
        for (int i = 0; i < A.length; i++) {
            result[i] = map.get(A[i]).pop();
        }
        return result;
    }
}
