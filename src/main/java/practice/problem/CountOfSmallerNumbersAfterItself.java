package practice.problem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 315. Count of Smaller Numbers After Self
public class CountOfSmallerNumbersAfterItself {

    /**
     * mergeSort way
     */
//    int[] count;
//
//    public List<Integer> countSmaller(int[] nums) {
//        List<Integer> res = new ArrayList<>();
//        count = new int[nums.length];
//        int[] indexes = new int[nums.length];
//        for (int i = 0; i < nums.length; i++) {
//            indexes[i] = i;
//        }
//        mergeSort(nums, indexes, 0, nums.length - 1);
//        for (int i = 0; i < count.length; i++) {
//            res.add(count[i]);
//        }
//        return res;
//    }
//
//    private void mergeSort(int[] nums, int[] indexes, int start, int end) {
//        if (end <= start)
//            return;
//        int mid = (start + end) / 2;
//        mergeSort(nums, indexes, start, mid);
//        mergeSort(nums, indexes, mid + 1, end);
//        merge(nums, indexes, start, end);
//    }
//
//    private void merge(int[] nums, int[] indexes, int start, int end) {
//        int mid = (start + end) / 2;
//        int leftIndex = start;
//        int rightIndex = mid + 1;
//        int rightCount = 0;
//        int[] newIndexes = new int[end - start + 1];
//        int sortIndex = 0;
//        while (leftIndex <= mid && rightIndex <= end) {
//            if (nums[indexes[rightIndex]] < nums[indexes[leftIndex]]) {
//                newIndexes[sortIndex] = indexes[rightIndex];
//                rightCount++;
//                rightIndex++;
//            } else {
//                newIndexes[sortIndex] = indexes[leftIndex];
//                count[indexes[leftIndex]] += rightCount;
//                leftIndex++;
//            }
//            sortIndex++;
//        }
//        while (leftIndex <= mid) {
//            newIndexes[sortIndex] = indexes[leftIndex];
//            count[indexes[leftIndex]] += rightCount;
//            leftIndex++;
//            sortIndex++;
//        }
//        while (rightIndex <= end) {
//            newIndexes[sortIndex++] = indexes[rightIndex++];
//        }
//        for (int i = start; i <= end; i++) {
//            indexes[i] = newIndexes[i - start];
//        }
//    }

    /**
     * BST way
     */
    class BstNode {
        BstNode left, right;
        int val, sum, dup = 1;

        public BstNode(int v, int s) {
            val = v;
            sum = s;
        }
    }

    public List<Integer> countSmaller(int[] nums) {
        Integer[] ans = new Integer[nums.length];
        BstNode root = null;
        for (int i = nums.length - 1; i >= 0; i--) {
            root = insert(nums[i], root, ans, i, 0);
        }
        return Arrays.asList(ans);
    }

    private BstNode insert(int num, BstNode node, Integer[] ans, int i, int preSum) {
        if (node == null) {
            node = new BstNode(num, 0);
            ans[i] = preSum;
        } else if (node.val == num) {
            node.dup++;
            ans[i] = preSum + node.sum;
        } else if (node.val > num) {
            node.sum++;
            node.left = insert(num, node.left, ans, i, preSum);
        } else {
            int sum = preSum + node.dup + node.sum;
            node.right = insert(num, node.right, ans, i, sum);
        }
        return node;
    }
}
