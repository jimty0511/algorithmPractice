package practice.lintcode;

import java.util.*;

// 1689. k Sum III
public class KSumIII {
    /**
     * @param a:      the array a
     * @param k:      the integer k
     * @param target: the integer target
     * @return: return the number of legal schemes
     */
    public int getAns(int[] a, int k, int target) {
        // write your code here
        helper(a, k, target, target, 0, new ArrayList<>(), new ArrayList<>(), new HashSet<>(), new boolean[a.length], new boolean[a.length]);
        return res;
    }

    int res = 0;

    private void helper(int[] a, int k, int evenTarget, int oddTarget, int idx, List<Integer> odd, List<Integer> even, Set<String> visited, boolean[] oddVisited, boolean[] evenVisited) {
        if ((odd.size() == k && oddTarget == 0 && visited.add(Arrays.toString(oddVisited))) || (even.size() == k) && evenTarget == 0 && visited.add(Arrays.toString(evenVisited))) {
            res++;
            return;
        }
        if (odd.size() > k || even.size() > k || evenTarget < 0 || oddTarget < 0)
            return;
        for (int i = idx; i < a.length; i++) {
            if (a[i] % 2 == 0) {
                even.add(a[i]);
                evenVisited[i] = true;
                helper(a, k, evenTarget - a[i], oddTarget, i + 1, odd, even, visited, oddVisited, evenVisited);
                even.remove(even.size() - 1);
                evenVisited[i] = false;
            } else {
                odd.add(a[i]);
                oddVisited[i] = true;
                helper(a, k, evenTarget, oddTarget - a[i], i + 1, odd, even, visited, oddVisited, evenVisited);
                odd.remove(odd.size() - 1);
                oddVisited[i] = false;
            }
        }
    }
}
