package practice.problem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

// 315. Count of Smaller Numbers After Self
public class CountOfSmallerNumbersAfterSelf {

    class Node {
        int val;
        int index;

        public Node(int val, int index) {
            this.val = val;
            this.index = index;
        }
    }

    private List<Integer> result = null;

    public List<Integer> countSmaller(int[] nums) {
        result = new ArrayList<>(nums.length);
        if (nums == null || nums.length == 0)
            return result;
        for (int i = 0; i < nums.length; i++)
            result.add(0);
        Node[] nodes = new Node[nums.length];
        for (int i = 0; i < nums.length; i++) {
            nodes[i] = new Node(nums[i], i);
        }
        helper(nodes, 0, nodes.length - 1);
        return result;
    }

    private void helper(Node[] nodes, int s, int e) {
        if (s >= e)
            return;
        int mid = s + (e - s) / 2;
        helper(nodes, s, mid);
        helper(nodes, mid + 1, e);
        for (int i = s, j = mid + 1; i <= mid; i++) {
            while (j <= e && nodes[j].val < nodes[i].val)
                j++;
            int originalIndex = nodes[i].index;
            result.set(originalIndex, result.get(originalIndex) + j - (mid + 1));
        }
        Arrays.sort(nodes, s, e + 1, Comparator.comparingInt(x -> x.val));
    }
}
