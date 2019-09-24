package practice.problem;

import java.util.HashSet;
import java.util.Set;

// 421. Maximum XOR of Two Numbers in an Array
public class MaximumXOROfTwoNumbersInAnArray {
    public int findMaximumXOR(int[] nums) {
        int max = 0, mask = 0;
        for (int i = 31; i >= 0; i--) {
            mask = mask | (1 << i);
            Set<Integer> set = new HashSet<>();
            for (int num : nums) {
                set.add(num & mask);
            }
            int tmp = max | (1 << i);
            for (int prefix : set) {
                if (set.contains(tmp ^ prefix)) {
                    max = tmp;
                    break;
                }
            }
        }
        return max;
    }

    class Trie {
        Trie[] children;

        public Trie() {
            children = new Trie[2];
        }
    }

    public int findMaximumXORTrie(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        Trie root = new Trie();
        for (int n : nums) {
            Trie cur = root;
            for (int i = 6; i >= 0; i--) {
                int curBit = (n >>> i) & 1;
                if (cur.children[curBit] == null)
                    cur.children[curBit] = new Trie();
                cur = cur.children[curBit];
            }
        }
        int max = Integer.MIN_VALUE;
        for (int n : nums) {
            Trie cur = root;
            int curSum = 0;
            for (int i = 6; i >= 0; i--) {
                int curBit = (n >>> i) & 1;
                if (cur.children[curBit ^ 1] != null) {
                    curSum += (1 << i);
                    cur = cur.children[curBit ^ 1];
                } else
                    cur = cur.children[curBit];
            }
            max = Math.max(curSum, max);
        }
        return max;
    }
}
