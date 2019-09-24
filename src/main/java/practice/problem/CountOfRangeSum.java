package practice.problem;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

// 327. Count of Range Sum
public class CountOfRangeSum {
    int count = 0;
    int lower, upper;

    public int countRangeSum(int[] nums, int lower, int upper) {
        long[] sum = new long[nums.length + 1];
        long[] temp = new long[nums.length + 1];
        sum[0] = 0;
        this.lower = lower;
        this.upper = upper;
        for (int i = 1; i <= nums.length; i++) {
            sum[i] = sum[i - 1] + nums[i - 1];
        }
        mergeSort(sum, 0, sum.length - 1, temp);
        return count;
    }

    private void mergeSort(long[] sum, int start, int end, long[] temp) {
        if (start >= end) {
            return;
        }
        int mid = start + (end - start) / 2;
        mergeSort(sum, start, mid, temp);
        mergeSort(sum, mid + 1, end, temp);
        merge(sum, start, mid, end, temp);
    }

    private void merge(long[] sum, int start, int mid, int end, long[] temp) {
        int right = mid + 1;
        int index = start;
        int low = mid + 1, high = mid + 1;
        for (int left = start; left <= mid; left++) {
            while (low <= end && sum[low] - sum[left] < lower) {
                low++;
            }
            while (high <= end && sum[high] - sum[left] <= upper) {
                high++;
            }
            while (right <= end && sum[right] < sum[left]) {
                temp[index++] = sum[right++];
            }
            temp[index++] = sum[left];
            count += high - low;
        }
        while (right <= end) {
            temp[index++] = sum[right++];
        }
        for (int i = start; i <= end; i++) {
            sum[i] = temp[i];
        }
    }

    class SegmentTreeNode {
        SegmentTreeNode left;
        SegmentTreeNode right;
        int count;
        long min;
        long max;

        public SegmentTreeNode(long min, long max) {
            this.min = min;
            this.max = max;
        }
    }

    public int countRangeSumTwo(int[] nums, int lower, int upper) {
        if (nums == null || nums.length == 0)
            return 0;
        int ans = 0;
        Set<Long> set = new HashSet<>();
        long sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += (long) nums[i];
            set.add(sum);
        }
        Long[] val = set.toArray(new Long[0]);
        Arrays.sort(val);
        SegmentTreeNode root = buildTree(val, 0, val.length - 1);
        for (int i = nums.length - 1; i >= 0; i--) {
            updateTree(root, sum);
            sum -= (long) nums[i];
            ans += getCount(root, (long) lower + sum, (long) upper + sum);
        }
        return ans;
    }

    private SegmentTreeNode buildTree(Long[] val, int low, int high) {
        if (low > high)
            return null;
        SegmentTreeNode node = new SegmentTreeNode(val[low], val[high]);
        if (low == high)
            return node;
        int mid = (low + high) / 2;
        node.left = buildTree(val, low, mid);
        node.right = buildTree(val, mid + 1, high);
        return node;
    }

    private void updateTree(SegmentTreeNode node, Long val) {
        if (node == null)
            return;
        if (val >= node.min && val <= node.max) {
            node.count++;
            updateTree(node.left, val);
            updateTree(node.right, val);
        }
    }

    private int getCount(SegmentTreeNode node, long min, long max) {
        if (node == null)
            return 0;
        if (min > node.max || max < node.min)
            return 0;
        if (min <= node.min && max >= node.max)
            return node.count;
        return getCount(node.left, min, max) + getCount(node.right, min, max);
    }
}
